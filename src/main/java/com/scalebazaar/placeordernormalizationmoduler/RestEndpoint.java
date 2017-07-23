package com.scalebazaar.productPlaceModule;

/**
 * @author ADMINIBM
 *
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
//
import java.security.NoSuchAlgorithmException;
//
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import java.util.*;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
//import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.apache.log4j.Logger;

import com.alibaba.normandie.api.core.LazadaClient;
import com.alibaba.normandie.api.core.exception.LazadaException;
import com.alibaba.normandie.api.endpoint.product.model.Attribute;
import com.alibaba.normandie.api.endpoint.product.model.Category;
import com.alibaba.normandie.api.endpoint.product.request.GetCategoryAttributes;
import com.alibaba.normandie.api.endpoint.product.request.GetCategoryTree;
import com.alibaba.normandie.api.endpoint.product.request.UpdateProduct;
import com.alibaba.normandie.api.endpoint.product.response.GetCategoryAttributesResponse;
import com.alibaba.normandie.api.endpoint.product.response.GetCategoryTreeResponse;
import com.alibaba.normandie.api.endpoint.product.response.ModifyProductResponse;
import com.alibaba.normandie.api.endpoint.product.request.CreateProduct;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.scalebazaar.productscema.ProductScemaLazada;

public class RestEndpoint {
	
	private static Logger logger = Logger.getLogger(RestEndpoint.class);
	private Integer recordCount;
	private String URL ;
//	public RestEndpoint(String URL){
//		this.setURL(URL);
//		System.out.println(this.getURL());
//	}
	public void GetCategoryAttribute(long CategoryId){
		GetCategoryAttributes getCategoryAttributes = new GetCategoryAttributes(2L);
		try {
		    GetCategoryAttributesResponse response = getCategoryAttributes.execute();
		    System.out.println("\n\n\n");
		    System.out.println(response.getBody());
		    System.out.println("\n\n\n");
		    System.out.println("Product mandatory attributes:");
		    for(Attribute attribute: response.getProductMandatoryAttributes()) {
		        System.out.println(String.format("name:[%s], type:[%s],options:%s",
		          attribute.getName(), attribute.getInputType(), attribute.getOptionValues().toString()));
		        
		    }
		    
		    System.out.println("Sku mandatory attributes:");
		    for(Attribute attribute: response.getSkuMandatoryAttributes()) {
		        System.out.println(String.format("name:[%s], type:[%s],options:%s",
		          attribute.getName(), attribute.getInputType(), attribute.getOptionValues().toString()));
		    }
		} catch (LazadaException e) {
		    System.out.println(e.getResponseStr());
		}
	}
	
	public ArrayList<Long> queryCategoryId(){
		disableSslVerification();
		LazadaClient.init("https://api.sellercenter.lazada.com.my/","kandu2017.sl@gmail.com", "dHw1RQTaGlFi4bHrHGxKe6ys1JOy_mzzahWDBWpWX0scNU_W0YLz_vFX");		
		GetCategoryTree getCategoryTree = new GetCategoryTree();
		try {
		    GetCategoryTreeResponse response = getCategoryTree.execute();
		    System.out.println(response.getBody());
		    List<Category> categories = response.getBody();
//		    System.out.println(categories.toString());
		    ArrayList<Long> li = new ArrayList<>();
		    for(Category category: categories) {
		    	System.out.println(category.getCategoryId());
		    	li.add(category.getCategoryId());
		    }
		    	return li;
		      /*  for(Category leaf: category.getLeaves()) {
		        	System.out.println("kjdsh2");
		            System.out.println(leaf.getCategoryId());
		       }*/
		    
		} catch (LazadaException e) {
//			System.out.println("kjdshcatch");
		    System.out.println(e.getResponseStr());
		}
		return null;
	}
	
	public List<Attribute> allFields(long CategoryId){
		GetCategoryAttributes getCategoryAttributes = new GetCategoryAttributes(2L);
		try {
		    GetCategoryAttributesResponse response = getCategoryAttributes.execute();
		    return response.getBody();	    
		}
		catch (LazadaException e) {
		    System.out.println(e.getResponseStr());
		}
		return null;
	}
	
	public List<Attribute> mandatoryProductAttributes(long CategoryId){
//		 for(Attribute attribute: response.getProductMandatoryAttributes()) {
//		        System.out.println(String.format("name:[%s], type:[%s],options:%s",
//		          attribute.getName(), attribute.getInputType(), attribute.getOptionValues().toString()));
//		        
//		    }
		GetCategoryAttributes getCategoryAttributes = new GetCategoryAttributes(2L);
		try {
		    GetCategoryAttributesResponse response = getCategoryAttributes.execute();
		    return response.getProductMandatoryAttributes();	    
		}
		catch (LazadaException e) {
		    System.out.println(e.getResponseStr());
		}
		return null;
	}
	
	public List<Attribute> mandatorySkuAttributes(long CategoryId){
		GetCategoryAttributes getCategoryAttributes = new GetCategoryAttributes(2L);
		try {
		    GetCategoryAttributesResponse response = getCategoryAttributes.execute();
		    return response.getSkuMandatoryAttributes();	    
		}
		catch (LazadaException e) {
		    System.out.println(e.getResponseStr());
		}
		return null;
	}
	
	public void createLazadaAttributes(ProductScemaLazada psl, long CategoryId){
		 List<Attribute> li = mandatoryProductAttributes(CategoryId);
		Map<String, Object> attributes = new HashMap<String, Object>();
//		attributes.put("warranty_type", "No Warranty");
//		attributes.put("package_height", 11.1);
//		attributes.put("short_description", "yucheng CreateProduct test");
//		attributes.put("name", "yucheng's first product");
//		attributes.put("name_ms", "yucheng's first product");
//		attributes.put("model", "test model");
//		attributes.put("brand", "Huawei");
//		attributes.put("display_size_mobile", "4.3");
//		attributes.put("operating_system_version", "Android 5.1 Lollipop");
//		attributes.put("operating_system","Android");
		for(Attribute a: li){
			attributes.put(a.getName(), psl.get(a.getName()));
		}
		System.out.println("\n\n\n attributes:");
		System.out.println(attributes.toString());
		System.out.println("\n\n\n");
	}
	
	public void createLazadaSku(ProductScemaLazada psl, long CategoryId){
		List<Attribute> li = mandatorySkuAttributes(CategoryId);
		Map<String, Object> sku = new HashMap<String, Object>();
		for(Attribute a: li){
			sku.put(a.getName(), psl.get(a.getName()));
		}
		System.out.println("\n\n\n attributes:");
		System.out.println(sku.toString());
		System.out.println("\n\n\n");
		
	}
	
	public void CreateProduct(Map<String, Object> attributes, List<Map<String, Object>> skusList){
		CreateProduct createProduct = new CreateProduct(3L, attributes, skusList);
		try {
		  ModifyProductResponse response = createProduct.execute();
		  System.out.println(String.format("CreateProduct succeeded?%b",response.getBody()));
		} catch (LazadaException e) {
		  System.out.println(e.getResponseStr());
		}
	}
	
	public void updateProduct(Map<String, Object> attributes, List<Map<String, Object>> skusList){
		UpdateProduct request = new UpdateProduct(attributes, skusList);
		try {
		  ModifyProductResponse response = request.execute();
		  System.out.println("UpdateProduct succeed?" + response.getBody());
		} catch (LazadaException e) {
		  System.out.println(e.getResponseStr());
		}
	}
	
	public String getSearchID(String auth_token, String query_expression)  {
		HttpsURLConnection connection = null;
		String urlParameters =query_expression;
		String encodedUrl;
		try {
			encodedUrl = URLEncoder.encode(urlParameters, "UTF-8");
			urlParameters = "?query_expression="+encodedUrl;
			System.out.println(encodedUrl.toString());
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
//		System.out.println("*************step1***************************"); 
		String newURL = getURL();
		String restURL = new String("http://svcs.ebay.com/services/marketplacecatalog/ProductService/v1");
		String targetURL = newURL + restURL;
		System.out.println(targetURL);
		targetURL = targetURL+urlParameters;
		URL url = null;
		try {
			url = new URL(targetURL);
			System.out.println(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		disableSslVerification();
		// creating object for establishing connection
		try {
			connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			// headers
			//connection.setSSLSocketFactory(sslContext.getSocketFactory());
			connection.setRequestProperty("Content-Type","application/json");
			connection.setRequestProperty("SEC", auth_token);
			connection.setRequestProperty("Accept","application/json");
			System.out.println(Integer.toString(urlParameters.getBytes().length));
			// check the headers
			for (String header : connection.getRequestProperties().keySet()) {
				if (header != null) {
					for (String value : connection.getRequestProperties().get(header)) {
						System.out.println(header + ":" + value);
					}
				}
			}
			connection.setUseCaches(false);
			connection.setDoOutput(true);
		} catch (IOException e) {
			System.out.println("ERROR in Creating Connection");
			e.printStackTrace();
		}
		DataOutputStream wr = null;
		try {
			wr = new DataOutputStream (connection.getOutputStream());
			wr.close();
		} catch (IOException e) {
			System.out.println("ERROR in writing DATAOUTPUTSTREAM in GetSearchID");
			e.printStackTrace();
		}
		int status = 0;
		try {
			status = connection.getResponseCode();
			System.out.println("*********status********\n"+status +"  " + connection.getResponseMessage());
		} catch (IOException e1) {
			System.out.println("ERROR in GETTING RESPONSE CODE in GetSearchID");
			e1.printStackTrace();
		}
		if(status !=201){
			return "Search id not found";
		}
		InputStream is = null;
		try {
			is = connection.getInputStream();
		} catch (IOException e) {
			System.out.println("ERROR in Recieving Back Data from Input Stream in GetSearchID method");
			e.printStackTrace();
		}
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		StringBuffer response = new StringBuffer(); 
		String line;
		try {
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			connection.disconnect();
		}
		JsonElement je = new JsonParser().parse(response.toString());
		JsonObject jo = je.getAsJsonObject();
		JsonElement searchID = jo.get("search_id");
		System.out.println(jo.get("search_id").toString());
		return searchID.toString();
	}
	
	public String checkStatus(String auth_token , String searchID){
//		System.out.println("************************step 2*********************");
		HttpURLConnection connectiontes = null;
		while(true){
			String newURL = getURL();
			String restURL = new String("http://svcs.ebay.com/services/marketplacecatalog/ProductService/v1"+searchID);
			String targetURL = newURL + restURL;
			System.out.println(targetURL);
			URL url = null;
			try {
				url = new URL(targetURL);
			} catch (MalformedURLException e10) {
				System.out.println("ERROR in PARSING URL in checkStatus Method");
				e10.printStackTrace();
			}
			try {
				connectiontes = (HttpURLConnection) url.openConnection();
				connectiontes.setRequestProperty("Content-Type","application/json");
				connectiontes.setRequestProperty("Version", "8.0");  
				connectiontes.setRequestProperty("SEC", auth_token);
				connectiontes.setRequestProperty("Accept","application/json");
				connectiontes.setRequestMethod("GET");
			} catch (IOException e9) {
				e9.printStackTrace();
			}
			try {
				if(connectiontes.getResponseCode() != 200){
						System.out.println(connectiontes.getResponseCode());
						return "failed error code : "+ connectiontes.getResponseCode();
				}
				System.out.println(connectiontes.getResponseCode());
			} catch (IOException e5) {
				System.out.println("ERROR Connot generate Response Code in checkStatus Method");
				e5.printStackTrace();
			}
			System.out.println("GET - http://svcs.ebay.com/services/marketplacecatalog/ProductService/v1"+searchID);
			InputStream is = null;
			try {
				is = connectiontes.getInputStream();
			} catch (IOException e3) {
				System.out.println("ERROR could not read from InputStream in checkStatus Method");
				e3.printStackTrace();
			}
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuffer response = new StringBuffer();
			String line;
			try {
				while ((line = rd.readLine()) != null) {
					response.append(line);
					response.append('\r');
				}
				rd.close();
			} 
			catch (IOException e2) {
				e2.printStackTrace();
			}
			finally{
				connectiontes.disconnect();
			}
			JsonElement je = new JsonParser().parse(response.toString());
			JsonObject jo = je.getAsJsonObject();
			String status = jo.get("status").toString();
			System.out.println(status);
			status = status.substring(1,status.length()-1);
			if(status.equals("COMPLETED")){
				return "completed";
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				System.out.println("ERROR Could Not Sleep in checkStatus method");
				e.printStackTrace();
			}
		}
	} 

	public ArrayList<String> getUserID(String auth_token , String searchID){
//		System.out.println("*****************************step3 *********************");
		ArrayList<String> usernames = new ArrayList<>();
		if(searchID == null){
			System.out.println("query did not work");
			return null;
		}
		else{
			HttpsURLConnection connection = null;
			disableSslVerification();
			String newURL = getURL();
			String restURL = new String("http://svcs.ebay.com/services/marketplacecatalog/ProductService/v1"+searchID+"/results");
			String targetURL = newURL + restURL;
			System.out.println(targetURL);
			URL url = null;
			try {
				url = new URL(targetURL);
				System.out.println(url);
			} catch (MalformedURLException e) {
				System.out.println("ERROR Could Not Parse URL in getUserID method");
				e.printStackTrace();
			}
			
			try {
				connection = (HttpsURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setRequestProperty("Content-Type","application/json");
				connection.setRequestProperty("Version", "8.0");  
				connection.setRequestProperty("SEC", auth_token);
				connection.setRequestProperty("Accept","application/json");
				connection.setUseCaches(false);
			} catch (IOException e) {
				System.out.println("ERROR could not establish connection");
				e.printStackTrace();
			}
			int status =0;
			try {
				status = connection.getResponseCode();
				if(status != 200){
					System.out.println("failed error code : "+ connection.getResponseCode());
				}
			} catch (IOException e5) {
				e5.printStackTrace();
			}
			InputStream is;
			BufferedReader rd;
			StringBuffer response = new StringBuffer();
			try {
				is = connection.getInputStream();
				rd = new BufferedReader(new InputStreamReader(is));
				String line;
				while ((line = rd.readLine()) != null) {
					response.append(line);
					response.append('\r');
				}
				rd.close();
			}catch (IOException e2) {
				e2.printStackTrace();
			}
			finally{
				if (connection != null) {
					connection.disconnect();
				}
			}
			JsonElement je = new JsonParser().parse(response.toString());
			JsonObject jo = je.getAsJsonObject();
			JsonElement jee = new JsonParser().parse(jo.get("events").toString());
			JsonArray ja = jee.getAsJsonArray();
			
			for(int i =0 ; i< ja.size() ; i++){
				JsonElement jeee = new JsonParser().parse(ja.get(i).toString());
				JsonObject joo = jeee.getAsJsonObject();
				//System.out.println(joo.get("username").toString());
				usernames.add(joo.get("username").toString());
			}
			System.out.println(ja.get(0).toString());
			String events = jo.get("events").toString();
			System.out.println(events);
		}


		return usernames;
	}

	
	
	
	
	
	private static void disableSslVerification() {
	    try
	    {
	        // Create a trust manager that does not validate certificate chains
	        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
	            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	                return null;
	            }
	            public void checkClientTrusted(X509Certificate[] certs, String authType) {
	            }
	            public void checkServerTrusted(X509Certificate[] certs, String authType) {
	            }
	        }
	        };

	        // Install the all-trusting trust manager
	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

	        // Create all-trusting host name verifier
	        HostnameVerifier allHostsValid = new HostnameVerifier() {
	            public boolean verify(String hostname, SSLSession session) {
	                return true;
	            }
	        };

	        // Install the all-trusting host verifier
	        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch (KeyManagementException e) {
	        e.printStackTrace();
	    }
	}
	
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		RestEndpoint.logger = logger;
	}
}
