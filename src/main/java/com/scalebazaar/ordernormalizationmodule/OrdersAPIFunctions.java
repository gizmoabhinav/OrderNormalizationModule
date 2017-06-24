/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalebazaar.ordernormalizationmodule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author abmukh
 */
public class OrdersAPIFunctions {

    public static ArrayList<Order> getOrders(Seller seller, File marketplaceFile, String marketplaceid) {
        String OrdersResponse = null;
        JSONObject properties = null;
        try {
            properties = Utils.addSystemProperties(new JSONObject(seller.getProperties()));
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(marketplaceFile);

            doc.getDocumentElement().normalize();

            Node ordersAPI = doc.getElementsByTagName("ordersapi").item(0);
            Node requestnode = ((Element) ordersAPI).getElementsByTagName("request").item(0);
            StringBuilder requestUrl = new StringBuilder();

            //compute host
            String host = ((Element) requestnode).getElementsByTagName("host").item(0).getTextContent();
            requestUrl.append(computeXmlVariables(host, properties));

            // compute params
            NodeList paramsNodes = ((Element) requestnode).getElementsByTagName("param");
            for (int j = 0; j < paramsNodes.getLength(); j++) {
                if (j != 0) {
                    requestUrl.append("&");
                }
                String param = paramsNodes.item(j).getTextContent();
                requestUrl.append(computeXmlVariables(param, properties));
            }

            System.out.println(requestUrl.toString());

            //compute headers
            JSONObject headers = new JSONObject();

            NodeList headerNodes = ((Element) requestnode).getElementsByTagName("header");
            for (int j = 0; j < headerNodes.getLength(); j++) {
                if (j != 0) {
                    requestUrl.append("&");
                }
                String headerValue = headerNodes.item(j).getTextContent();
                headers.put(((Element) headerNodes.item(j)).getAttribute("name"), computeXmlVariables(headerValue, properties));
            }

            if (((Element) requestnode).getAttribute("type").equals("GET")) {
                OrdersResponse = HttpConnector.sendGetRequest(requestUrl.toString(), headers);
            } else if (((Element) requestnode).getAttribute("type").equals("POST")) {
                OrdersResponse = HttpConnector.sendPostRequest(requestUrl.toString(), headers);
            }

            Node responsenode = ((Element) ordersAPI).getElementsByTagName("response").item(0);
            
            ArrayList<String> orderList = extractOrderProps(OrdersResponse, ((Element) responsenode).getElementsByTagName("orderidentifierpattern").item(0).getTextContent());

            //extract orderids
            ArrayList<Order> orders = new ArrayList();
            for (int i = 0; i < orderList.size(); i++) {
                Order or1 = new Order();
                or1.setSellerid("" + seller.getId());
                or1.setMarketplaceid(marketplaceid);
                or1.setOrderid(extractOrderProp(orderList.get(i), ((Element) responsenode).getElementsByTagName("orderidpattern").item(0).getTextContent()));
                or1.setTimestamp(extractOrderProp(orderList.get(i), ((Element) responsenode).getElementsByTagName("timestamppattern").item(0).getTextContent()));
                or1.setPaymentmethod(extractOrderProp(orderList.get(i), ((Element) responsenode).getElementsByTagName("paymentmethodpattern").item(0).getTextContent()));
                or1.setOrderstatus(extractOrderProp(orderList.get(i), ((Element) responsenode).getElementsByTagName("orderstatuspattern").item(0).getTextContent()));
                or1.setCustomername(extractOrderProp(orderList.get(i), ((Element) responsenode).getElementsByTagName("customernamepattern").item(0).getTextContent()));
                or1.setCustomeremail(extractOrderProp(orderList.get(i), ((Element) responsenode).getElementsByTagName("customeremailpattern").item(0).getTextContent()));
                or1.setCustomeraddress(extractOrderProp(orderList.get(i), ((Element) responsenode).getElementsByTagName("customeraddresspattern").item(0).getTextContent()));
                or1.setOrderdump(orderList.get(i));
                orders.add(or1);
            }
            return orders;

        } catch (SAXException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList();
    }

    public static ArrayList<OrderItem> getOrdersById(Seller seller, File marketplaceFile, String orderid, String marketplaceid) {
        ArrayList<OrderItem> ol = new ArrayList();

        String OrdersResponse = null;
        JSONObject properties = null;
        try {
            properties = Utils.addSystemProperties(new JSONObject(seller.getProperties()));
            properties.put("orderid", orderid);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(marketplaceFile);

            doc.getDocumentElement().normalize();

            Node ordersAPI = doc.getElementsByTagName("orderbyidapi").item(0);
            Node requestnode = ((Element) ordersAPI).getElementsByTagName("request").item(0);
            StringBuilder requestUrl = new StringBuilder();

            //compute host
            String host = ((Element) requestnode).getElementsByTagName("host").item(0).getTextContent();
            requestUrl.append(computeXmlVariables(host, properties));

            // compute params
            NodeList paramsNodes = ((Element) requestnode).getElementsByTagName("param");
            for (int j = 0; j < paramsNodes.getLength(); j++) {
                if (j != 0) {
                    requestUrl.append("&");
                }
                String param = paramsNodes.item(j).getTextContent();
                requestUrl.append(computeXmlVariables(param, properties));
            }

            System.out.println(requestUrl.toString());

            //compute headers
            JSONObject headers = new JSONObject();

            NodeList headerNodes = ((Element) requestnode).getElementsByTagName("header");
            for (int j = 0; j < headerNodes.getLength(); j++) {
                if (j != 0) {
                    requestUrl.append("&");
                }
                String headerValue = headerNodes.item(j).getTextContent();
                headers.put(((Element) headerNodes.item(j)).getAttribute("name"), computeXmlVariables(headerValue, properties));
            }

            if (((Element) requestnode).getAttribute("type").equals("GET")) {
                OrdersResponse = HttpConnector.sendGetRequest(requestUrl.toString(), headers);
            } else if (((Element) requestnode).getAttribute("type").equals("POST")) {
                OrdersResponse = HttpConnector.sendPostRequest(requestUrl.toString(), headers);
            }

            Node responsenode = ((Element) ordersAPI).getElementsByTagName("response").item(0);
            
            ArrayList<String> orderList = extractOrderProps(OrdersResponse, ((Element) responsenode).getElementsByTagName("orderitemidentifierpattern").item(0).getTextContent());
            
            for (int i = 0; i < orderList.size(); i++) {
                OrderItem order = new OrderItem();
                order.setOrderdump(orderList.get(i));
                order.setOrderid(orderid);
                order.setMarketplaceid(marketplaceid);
                order.setSellerid("" + seller.getId());
                order.setSku(extractOrderProp(orderList.get(i), ((Element) responsenode).getElementsByTagName("skupattern").item(0).getTextContent()));
                order.setValue(extractOrderProp(orderList.get(i), ((Element) responsenode).getElementsByTagName("valuepattern").item(0).getTextContent()));
                order.setCurrencycode(extractOrderProp(orderList.get(i), ((Element) responsenode).getElementsByTagName("currencycodepattern").item(0).getTextContent()));
                order.setQuantity(extractOrderProp(orderList.get(i), ((Element) responsenode).getElementsByTagName("quantitypattern").item(0).getTextContent()));
                order.setItemname(extractOrderProp(orderList.get(i), ((Element) responsenode).getElementsByTagName("itemnamepattern").item(0).getTextContent()));
                ol.add(order);
            }

        } catch (SAXException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ol;
    }

    private static String computeXmlVariables(String input, JSONObject properties) throws JSONException, Exception {
        StringBuffer sb = new StringBuffer();
        String regex = "(\\$\\{[^}]+\\})";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while (m.find()) {
            String variable = m.group(1);
            variable = variable.substring(2, variable.length() - 1);
            String repString = properties.get(variable).toString();
            if (repString != null) {
                m.appendReplacement(sb, repString);
            }
        }
        m.appendTail(sb);
        input = sb.toString();
        sb = new StringBuffer();
        regex = "(\\^\\{[^}]+\\})";
        p = Pattern.compile(regex);
        m = p.matcher(input);
        while (m.find()) {
            String function = m.group(1);
            function = function.substring(2, function.length() - 1);
            if (function.split(",")[0].equals("HMACSHA256")) {
                m.appendReplacement(sb, Utils.HMACSHA256encode(function.split(",")[2], function.split(",")[1]));
            } else if (function.split(",")[0].equals("HMACSHA256BASE64")) {
                m.appendReplacement(sb, Utils.HMACSHA256encodeBase64(function.split(",")[2], function.split(",")[1]));
            }
        }
        m.appendTail(sb);
        input = sb.toString();
        return input;
    }

    private static ArrayList<String> extractOrderProps(String data, String patternstr) {
        ArrayList<String> orderprop = new ArrayList<String>();
        Pattern pattern = Pattern.compile(patternstr);
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            orderprop.add(matcher.group(1));
            System.out.println(matcher.group(1));
        }
        return orderprop;
    }
    
    private static String extractOrderProp(String data, String patternstr) {
        String orderprop = "";
        Pattern pattern = Pattern.compile(patternstr);
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            orderprop = matcher.group(1);
            System.out.println(matcher.group(1));
        }
        return orderprop;
    }
}
