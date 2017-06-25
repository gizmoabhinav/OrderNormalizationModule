/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalebazaar.ordernormalizationmodule;

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
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author abmukh
 */
public class HttpConnector {

    public static String sendGetRequest(String requestUrl, JSONObject headers) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(requestUrl);
            Iterator<String> keys = headers.keys();

            while (keys.hasNext()) {
                String key = (String) keys.next(); 
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
    
    public static String sendPostRequest(String requestUrl, JSONObject headers, String body) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost getRequest = new HttpPost(requestUrl);
            Iterator<String> keys = headers.keys();

            System.out.println("url = "+requestUrl);
            while (keys.hasNext()) {
                String key = (String) keys.next();
                if (headers.get(key) instanceof String) {
                   getRequest.addHeader(key, headers.get(key).toString());
                }
            }
            System.out.println(headers.toString());

            if(!body.isEmpty()) {
                getRequest.addHeader("Content-Type","text/xml");
                HttpEntity entity = new ByteArrayEntity(body.getBytes("UTF-8"));
                getRequest.setEntity(entity);
            }
            
            System.out.println("body = "+body);
            
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
