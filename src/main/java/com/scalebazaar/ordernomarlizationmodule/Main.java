/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalebazaar.ordernomarlizationmodule;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
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

import org.json.JSONArray;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.URL;
import java.net.HttpURLConnection;

 
public class Main {

    public static void main(String args[]) {
        Seller[] sellers = loadSellers();
        for(Seller seller : sellers) {
            getOrders(seller);
        }
    }

    public static Seller[] loadSellers() {
        File sellerDir = new File("sellers");
        int sellerCount = sellerDir.listFiles().length;
        File[] sellerFiles = sellerDir.listFiles();
        Seller[] sellers = new Seller[sellerCount];
        for (int i = 0; i < sellerCount; i++) {
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(sellerFiles[i]);
                //Todo : check formatting of the xml file and validate

                doc.getDocumentElement().normalize();

                sellers[i] = new Seller();
                sellers[i].setId(Integer.parseInt(((Element) (doc.getElementsByTagName("seller").item(0))).getAttribute("id")));
                sellers[i].setName(doc.getElementsByTagName("name").item(0).getTextContent());

                JSONObject properties = new JSONObject();

                NodeList propertyList = doc.getElementsByTagName("property");

                for (int j = 0; j < propertyList.getLength(); j++) {
                    Element property = (Element) propertyList.item(j);
                    String variable = property.getAttribute("name");
                    String value = property.getTextContent();
                    properties.put(variable, value);
                }

                sellers[i].setProperties(properties);

                sellers[i].setMarketPlaces(doc.getElementsByTagName("marketplaces").item(0).getTextContent().split(","));
            } catch (SAXException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sellers;
    }
    public static void getOrder_Bonanza(String[] args) {
        try {
            String devId = "myDevId";
            String certId = "myCertId";

            URL url = new URL("http://api.bonanza.com/api_requests/secure_request");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("X-BONANZLE-API-DEV-NAME", devId);
            connection.setRequestProperty("X-BONANZLE-API-CERT-NAME", certId);

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());

            String jsonPayload = new JSONStringer()
                .object()
                    .key("requesterCredentials")
                    .object()
                        .key("bonanzleAuthToken")
                        .value("myAuthToken")
                    .endObject()
                    .key("orderRole")
                    .value("seller")
                .endObject()
                .toString();

            String requestName = "GetOrdersRequest";

            String toWrite = requestName + "=" + jsonPayload;

            writer.write(toWrite);
            writer.flush();
            writer.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = in.readLine();

            JSONObject jsonResponse = new JSONObject(response);

            if (jsonResponse.optString("ack").equals("Success") 
                    && jsonResponse.optJSONObject("getOrdersResponse") != null) {

                // Success! Now read more keys from the json object
                JSONArray orderArray = jsonResponse.optJSONObject("getOrdersResponse").optJSONArray("orderArray");

                for (int i = 0; i < orderArray.length(); i++) {
                    JSONObject order = orderArray.optJSONObject(i).optJSONObject("order");
                    System.out.println("ORDER #" + i + " ======================");
                    System.out.println("Order ID: " + order.optInt("orderID"));
                    System.out.println("Buyer's Username: " + order.optString("buyerUserName"));
                    System.out.println("Amount Paid: " + order.optString("amountPaid"));
                    System.out.println("Creation Time: " + order.optString("createdTime"));
                    System.out.println("Status: " + order.optJSONObject("checkoutStatus").optString("status"));
                }
            } else {
                System.out.println(jsonResponse);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void getOrders(Seller seller) {
        JSONObject properties = Utils.addSystemProperties(seller.getProperties());
        String marketplaces[] = seller.getMarketPlaces();
        for (int i = 0; i < marketplaces.length; i++) {
            File marketplaceFile = new File("marketplaces/" + marketplaces[i] + ".xml");

            //Todo: check for file sanity
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(marketplaceFile);

                doc.getDocumentElement().normalize();

                Node ordersAPI = doc.getElementsByTagName("ordersapi").item(0);
                Node requestnode = ((Element) ordersAPI).getElementsByTagName("request").item(0);
                StringBuilder requestUrl = new StringBuilder();

                //compute host
                String host = ((Element) requestnode).getElementsByTagName("host").item(0).getTextContent();
                requestUrl.append(computeXmlVariables(host,properties));

                // compute params
                NodeList paramsNodes = ((Element) requestnode).getElementsByTagName("param");
                for (int j = 0; j < paramsNodes.getLength(); j++) {
                    if (j != 0) {
                        requestUrl.append("&");
                    }
                    String param = paramsNodes.item(j).getTextContent();
                    requestUrl.append(computeXmlVariables(param,properties));
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
                    headers.put(((Element) headerNodes.item(j)).getAttribute("name"), computeXmlVariables(headerValue,properties));
                }

                
                if(((Element) requestnode).getAttribute("type").equals("GET")) {
                    HttpConnector.sendGetRequest(requestUrl.toString(), headers);
                }else if (((Element) requestnode).getAttribute("type").equals("POST")) {
                    HttpConnector.sendPostRequest(requestUrl.toString(), headers);
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
        }
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

}
