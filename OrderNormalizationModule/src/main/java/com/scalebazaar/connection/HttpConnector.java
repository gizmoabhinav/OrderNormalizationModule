/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalebazaar.connection;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author abmukh
 */
@SuppressWarnings("unused")
public class HttpConnector {

    public static String sendGetRequest(String requestUrl, JSONObject headers) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(requestUrl);
            @SuppressWarnings("unchecked")
			Iterator<String> keys = headers.keys();

            while (keys.hasNext()) {
                String key = keys.next(); 
                if (headers.get(key) instanceof String) {
                   getRequest.addHeader(key, headers.get(key).toString());
                }
            }
            System.out.println(headers.toString());

            HttpResponse response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            StringBuilder ServerOutput = new StringBuilder();
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                ServerOutput.append(output);
            }

            httpClient.getConnectionManager().shutdown();
            
            return ServerOutput.toString();

        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        } catch (JSONException ex) {
            Logger.getLogger(HttpConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "no result";
    }
    
    public static String sendPostRequest(String requestUrl, JSONObject headers) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost getRequest = new HttpPost(requestUrl);
            @SuppressWarnings("unchecked")
			Iterator<String> keys = headers.keys();

            while (keys.hasNext()) {
                String key = keys.next();
                if (headers.get(key) instanceof String) {
                   getRequest.addHeader(key, headers.get(key).toString());
                }
            }
            System.out.println(headers.toString());

            HttpResponse response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            StringBuilder ServerOutput = new StringBuilder();
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                ServerOutput.append(output);
            }

            httpClient.getConnectionManager().shutdown();
            
            return ServerOutput.toString();

        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        } catch (JSONException ex) {
            Logger.getLogger(HttpConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "no result";
    }
}
