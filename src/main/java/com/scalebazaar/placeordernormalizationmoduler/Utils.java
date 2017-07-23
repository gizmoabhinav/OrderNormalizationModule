package com.scalebazaar.productPlaceModule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
//import org.apache.commons.io.IOUtils;
//import net.sf.json.JSONSerializer;

import org.json.JSONObject;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Utils {

    public void readCSV() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/ADMINIBM/git/OrderNormalizationModule/src/main/java/com/scalebazaar/placeordernormalizationmoduler/scalelabs.csv"));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+"|");
        }
        scanner.close();
    }
    public ArrayList<String[]> readCsvLineByLine(/*String filepath , String filename*/){
    	BufferedReader reader = null;
    	try {
//    		System.out.println("bla bla");
    		reader = new BufferedReader(new FileReader("lazada.csv"));
    	} catch (FileNotFoundException e1) {
    		e1.printStackTrace();
    	}
    	String [] col = null;
    	String line = "";
    	ArrayList<String [] > row = new ArrayList<>();
    	try {
    		while((line=reader.readLine())!=null){
    			col =line.trim().split(",");
    			row.add(col);
    			// if you want to check either it contains some name
    			//index 0 is first name, index 1 is last name, index 2 is ID
    			//System.out.println(col[0].toString());
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return row;
    }
    
    public String CheckScemas(){
    	
    	//Reading the Main template
    	BufferedReader reader = null;
    	try {
    		reader = new BufferedReader(new FileReader("Amazon-Temp.csv"));
    	} catch (FileNotFoundException e1) {
    		e1.printStackTrace();
    	}
    	String [] col = null;
    	String line = "";
    	ArrayList<String [] > template1 = new ArrayList<String[]>();
    	try {
    		while((line=reader.readLine())!=null){
    			col =line.trim().split(",");
    			template1.add(col);
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	//Reading the file to be checked
    	try {
    		reader = new BufferedReader(new FileReader("Book.csv"));
    	} catch (FileNotFoundException e1) {
    		e1.printStackTrace();
    	}
    	String [] col2 = null;
    	String line2 = "";
    	ArrayList<String [] > template2 = new ArrayList<String[]>();
    	try {
    		while((line=reader.readLine())!=null){
    			col2 =line2.trim().split(",");
    			template2.add(col);
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	// Checking both the arraylists
    	int flag =0 ;
    	if(template1.size() != template2.size())
    		return "Scemas Are Not Same";
    	
    	
    	for(Object s: template1){
    		if(!template2.contains(s)){
    			return "Scemas Are Not Same";
    		}
    	}
    	return "Scemas Are Not Same";
    }

    public JSONObject convertToJsonObject(Object obj){
		return null;
 
    }
    public void createJsonScema(String shopName){
    	
    	
    }


//   @SuppressWarnings("deprecation")
//	public JSONObject readJson(String filepath , String filename) throws Exception {
//    	InputStream is = Utils.class.getResourceAsStream( "sample-json.txt");
//        String jsonTxt = IOUtils.toString(is);
//        JSONObject json = (JSONObject) JSONSerializer.toJSON( jsonTxt );  
//        return json;
//    }
    public boolean checkForChange(JSONObject jo){
    	return false;
    }
    public JsonObject toJson(Map<String , String> map){
    	String s = new String("{");
		for (Map.Entry<String, String> entry : map.entrySet()){
			s = s + "\"" + entry.getKey() + "\"" + ":" + "\"" + entry.getValue() + "\"" + ",";
		}
    	s = s.substring(0, s.length()-1);
    	s = s + "}";
    	JsonElement je = new JsonParser().parse(s.toString());
    	JsonObject jo = je.getAsJsonObject();
    	return jo;
    }


}
