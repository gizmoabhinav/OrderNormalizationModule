package com.scalebazaar.productPlaceModule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import net.sf.json.JSONSerializer;

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
    public ArrayList<String[]> readCsvLineByLine(String filepath , String filename){
    	BufferedReader reader = null;
    	try {
    		System.out.println("bla bla");
    		reader = new BufferedReader(new FileReader("/home/ADMINIBM/git/OrderNormalizationModule/src/main/java/com/scalebazaar/placeordernormalizationmoduler/scalelabs.csv"));
    	} catch (FileNotFoundException e1) {
    		// TODO Auto-generated catch block
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
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return row;
    }

    public JSONObject convertToJsonObject(Object obj){
		return null;
 
    }
    public void createJsonScema(String shopName){
    	
    	
    }


    @SuppressWarnings("deprecation")
	public JSONObject readJson(String filepath , String filename) throws Exception {
    	InputStream is = Utils.class.getResourceAsStream( "sample-json.txt");
        String jsonTxt = IOUtils.toString(is);
        JSONObject json = (JSONObject) JSONSerializer.toJSON( jsonTxt );  
        return json;
    }
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
