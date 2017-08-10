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
import static com.scalebazaar.ordernormalizationmodule.RestEndpoint.sList;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/ProductsAPI")
public class RestEndpointProductUpload {

    @POST
    @Path("/ConvertProductsTemplate")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.MULTIPART_FORM_DATA)
    public Response convertProductUploadTemplate(
            @QueryParam("marketplaceid") String marketplaceid,
            @QueryParam("categoryid") String categoryid,
            @FormDataParam("file") InputStream uploadedInputStream,
	    @FormDataParam("file") FormDataContentDisposition fileDetail) {

        OutputStream outputStream = null;
        try {
            String uploadedFileLocation = "d://uploaded/" + fileDetail.getFileName();
            outputStream = new FileOutputStream(new File("../../temp/"+fileDetail.getFileName()));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            String output = "File uploaded to : " + uploadedFileLocation;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RestEndpointProductUpload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RestEndpointProductUpload.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(RestEndpointProductUpload.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        File file = new File("../../temp/"+fileDetail.getFileName());
            ResponseBuilder response = Response.ok((Object) file);
            response.header("Content-Disposition",
                    "attachment; filename=new-excel-file.xls");
        return response.build();
    }

    @GET
    @Path("/LoadCategories")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadCategories() {
        try {
            sList = new HashMap<Integer, Seller>();
            File productDir = new File("../../productfiles/categories.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(productDir);
            //Todo : check formatting of the xml file and validate
            
            doc.getDocumentElement().normalize();
            
            HashMap<Integer,String> categories = new HashMap<Integer, String>();
            NodeList categoryElements =  doc.getElementsByTagName("category");
            for(int i=0;i<categoryElements.getLength();i++) {
                categories.put(Integer.parseInt(((Element) categoryElements.item(i)).getAttribute("id")), categoryElements.item(i).getTextContent());
            }
            return Response.status(200).entity(categories).build();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RestEndpointProductUpload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(RestEndpointProductUpload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RestEndpointProductUpload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
