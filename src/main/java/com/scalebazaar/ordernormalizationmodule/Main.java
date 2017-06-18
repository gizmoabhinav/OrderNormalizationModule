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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author abmukh
 */
public class Main {

    public static void main(String args[]) {
        loadSellers();
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
                sellers[i].setId(Integer.parseInt(((Element)(doc.getElementsByTagName("seller").item(0))).getAttribute("id")));
                sellers[i].setName(doc.getElementsByTagName("name").item(0).getTextContent());
                
                JSONObject properties = new JSONObject();
                
                NodeList propertyList = doc.getElementsByTagName("property");
                
                for(int j=0;j<propertyList.getLength();j++) {
                    Element property = (Element)propertyList.item(j);
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

}
