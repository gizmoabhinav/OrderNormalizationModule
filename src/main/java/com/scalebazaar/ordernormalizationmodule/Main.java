/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalebazaar.ordernormalizationmodule;

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
public class Main {

    public static void main(String args[]) {
        Seller[] sellers = loadSellers();
        getOrders(sellers[0]);
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
                Document doc = dBuilder.parse(sellerFiles[0]);
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

    public static void getOrders(Seller seller) {
        JSONObject properties = Utils.addSystemProperties(seller.getProperties());
        String marketplaces[] = seller.getMarketPlaces();
        for (int i = 0; i < marketplaces.length; i++) {
            File marketplaceFile = new File("marketplaces/" + marketplaces[i] + ".xml");
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(marketplaceFile);

                doc.getDocumentElement().normalize();

                Node ordersAPI = doc.getElementsByTagName("ordersapi").item(0);
                Node requestnode = ((Element) ordersAPI).getElementsByTagName("request").item(0);
                StringBuilder requestUrl = new StringBuilder();
                requestUrl.append(((Element) requestnode).getElementsByTagName("host").item(0).getTextContent());

                NodeList paramsNodes = ((Element) requestnode).getElementsByTagName("param");
                for (int j = 0; j < paramsNodes.getLength(); j++) {
                    if(j!=0){
                        requestUrl.append("&");
                    }
                    String param = paramsNodes.item(j).getTextContent();
                    StringBuffer sb = new StringBuffer();
                    String regex = "(\\$\\{[^}]+\\})";
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(param);
                    while (m.find()) {
                        String variable = m.group(1);
                        variable = variable.substring(2,variable.length()-1);
                        String repString = properties.get(variable).toString();
                        if (repString != null) {
                            m.appendReplacement(sb, repString);
                        }
                    }
                    m.appendTail(sb);
                    param = sb.toString();
                    sb = new StringBuffer();
                    regex = "(\\^\\{[^}]+\\})";
                    p = Pattern.compile(regex);
                    m = p.matcher(param);
                    while (m.find()) {
                        String function = m.group(1);
                        function = function.substring(2,function.length()-1);
                        if(function.split(",")[0].equals("HMACSHA256")) {
                            m.appendReplacement(sb, Utils.HMACSHA256encode(function.split(",")[2], function.split(",")[1]));
                        }
                    }
                    m.appendTail(sb);
                    param = sb.toString();
                    requestUrl.append(param);
                }

                System.out.println(requestUrl.toString());
                
                HttpConnector.sendGetRequest(requestUrl.toString());

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

}
