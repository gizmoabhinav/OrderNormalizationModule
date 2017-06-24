/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalebazaar.ordernormalizationmodule;

/**
 *
 * @author abmukh
 */
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Path("/OrdersAPI")
public class RestEndpoint {

    @GET
    @Path("/GetOrders")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMsg(
            @QueryParam("sellerid") String sellerid,
            @QueryParam("marketplaceid") String msarketplaceid,
            @QueryParam("lasttimestamp") String lasttiemstamp) {

        Order order = new Order();
        order.setSellerid(sellerid);
        order.setMarketplaceid(msarketplaceid);
        return Response.status(200).entity(order).build();

    }

    @GET
    @Path("/LoadSellers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSellers() {
        HashMap<Integer, String> sellerList = new HashMap<Integer, String>();
        /*File sellerDir = new File("sellers");
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
        }*/
        sellerList.put(1,System.getProperty("user.dir"));
        return Response.status(200).entity(sellerList).build();
    }

}
