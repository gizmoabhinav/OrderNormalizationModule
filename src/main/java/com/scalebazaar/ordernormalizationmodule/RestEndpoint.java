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
import static com.scalebazaar.ordernormalizationmodule.OrdersAPIFunctions.setItemShipmentDetails;
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

    public static HashMap<Integer,Seller> sList = new HashMap<Integer,Seller>();
    public static HashMap<Integer,String> mList = new HashMap<Integer,String>();
    
    @GET
    @Path("/GetOrders")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrders(
            @QueryParam("sellerid") String sellerid,
            @QueryParam("marketplaceid") String marketplaceid,
            @QueryParam("lasttimestamp") String lasttiemstamp) {

        if(!sList.containsKey(Integer.parseInt(sellerid)) || !mList.containsKey(Integer.parseInt(marketplaceid))) {
            return Response.status(200).entity("invalid SellerId or MarketplaceId").build();
        }
        Seller seller = sList.get(Integer.parseInt(sellerid));
        String marketplace = mList.get(Integer.parseInt(marketplaceid));
        File marketplaceFile = new File("../../marketplaces/"+marketplace);
        marketplace = marketplace.substring(0,marketplace.indexOf("."));
        for(String marketplace1 : seller.getMarketPlaces()) {
            if(marketplace1.equals(marketplace)) {
                return Response.status(200).entity(OrdersAPIFunctions.getOrders(seller,marketplaceFile,marketplaceid)).build();
            }
        }
        return Response.status(200).entity("Seller not applicable for marketplace").build();
    }
    
    @GET
    @Path("/GetOrdersById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrdersById(
            @QueryParam("sellerid") String sellerid,
            @QueryParam("marketplaceid") String marketplaceid,
            @QueryParam("orderid") String orderid) {

        if(!sList.containsKey(Integer.parseInt(sellerid)) || !mList.containsKey(Integer.parseInt(marketplaceid))) {
            return Response.status(200).entity("invalid SellerId or MarketplaceId").build();
        }
        Seller seller = sList.get(Integer.parseInt(sellerid));
        String marketplace = mList.get(Integer.parseInt(marketplaceid));
        File marketplaceFile = new File("../../marketplaces/"+marketplace);
        marketplace = marketplace.substring(0,marketplace.indexOf("."));
        for(String marketplace1 : seller.getMarketPlaces()) {
            if(marketplace1.equals(marketplace)) {
                return Response.status(200).entity(OrdersAPIFunctions.getOrdersById(seller,marketplaceFile,orderid,marketplaceid)).build();
            }
        }
        return Response.status(200).entity("Seller not applicable for marketplace").build();
    }   

    @GET
    @Path("/LoadSellers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadSellers() {
        sList = new HashMap<Integer,Seller>();
        File sellerDir = new File("../../sellers");
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

                sellers[i].setProperties(properties.toString());

                sellers[i].setMarketPlaces(doc.getElementsByTagName("marketplaces").item(0).getTextContent().split(","));
                
                sList.put(sellers[i].getId(), sellers[i]);
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
        return Response.status(200).entity(sellers).build();
    }
    
    @GET
    @Path("/GetSellers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSellers(
            @QueryParam("sellerid") String sellerid) {
    
        if(sList.containsKey(Integer.parseInt(sellerid))) {
            return Response.status(200).entity(sList.get(Integer.parseInt(sellerid))).build();
        }
        
        return Response.status(200).entity(null).build();
        
    }
    
    @GET
    @Path("/LoadMarketplaces")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadMarketplaces() {
        mList = new HashMap<Integer,String>();
        File marketplaceDir = new File("../../marketplaces");
        File[] marketplaceFiles = marketplaceDir.listFiles();        
        int marketplaceCount = marketplaceDir.listFiles().length;
        for (int i = 0; i < marketplaceCount; i++) {
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(marketplaceFiles[i]);
                //Todo : check formatting of the xml file and validate

                doc.getDocumentElement().normalize();
                
                mList.put(Integer.parseInt(((Element) (doc.getElementsByTagName("marketplace").item(0))).getAttribute("id")), marketplaceFiles[i].getName());
                
            } catch (SAXException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RestEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        return Response.status(200).entity(mList).build();
    }

    @GET
    @Path("/BookShipment")
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookShipment(
            @QueryParam("sellerid") String sellerid,
            @QueryParam("marketplaceid") String marketplaceid,
            @QueryParam("orderid") String orderid,
            @QueryParam("shippername") String shippername,
            @QueryParam("trackingnumber") String trackingnumber,
            @QueryParam("itemid") String itemid,
            @QueryParam("quantity") int quantity) {
        if(!sList.containsKey(Integer.parseInt(sellerid)) || !mList.containsKey(Integer.parseInt(marketplaceid))) {
            return Response.status(200).entity("invalid SellerId or MarketplaceId").build();
        }
        Seller seller = sList.get(Integer.parseInt(sellerid));
        String marketplace = mList.get(Integer.parseInt(marketplaceid));
        File marketplaceFile = new File("../../marketplaces/"+marketplace);
        marketplace = marketplace.substring(0,marketplace.indexOf("."));
        for(String marketplace1 : seller.getMarketPlaces()) {
            if(marketplace1.equals(marketplace)) {
                return Response.status(200).entity(OrdersAPIFunctions.setItemShipmentDetails(seller,marketplaceFile,orderid,marketplaceid,shippername,trackingnumber,itemid,quantity)).build();
            }
        }
        return Response.status(200).entity("Seller not applicable for marketplace").build();
        
    }

}
