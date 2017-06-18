/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalebazaar.ordernormalizationmodule;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;

/**
 *
 * @author abmukh
 */
public class HttpConnector {
    
    /*public static void main(String[] args) {
        
        System.out.println(new File("sellers").listFiles().length);
        
        
	  /*try {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(
			"https://api.sellercenter.lazada.com.my?Action=GetOrders&CreatedAfter=2014-02-25T23%3A46%3A11%2B00%3A00&Format=json&Timestamp=2017-06-17T18%3A53%3A40%2B00%3A00&UserID=kandu2017.sl%40gmail.com&Version=1.0&Signature=b65f5f5e5c583939199658935958ad763437df69c31afc3708eb981182a05cbc");
		getRequest.addHeader("accept", "application/json");

		HttpResponse response = httpClient.execute(getRequest);

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			   + response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(
                         new InputStreamReader((response.getEntity().getContent())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		httpClient.getConnectionManager().shutdown();

	  } catch (ClientProtocolException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();
	  }


    }*/
    
}
