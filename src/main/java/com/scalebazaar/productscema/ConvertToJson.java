package com.scalebazaar.productscema;
import com.google.gson.Gson;

//import org.json.simple.*;

public class ConvertToJson {
	public String JavaToJson_Ebay(ProductScemaEbay ob){
		Gson gson = new Gson();
		String json = gson.toJson(ob);
		return json.toString();
	}
}
