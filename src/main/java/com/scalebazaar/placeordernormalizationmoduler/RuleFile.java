package com.scalebazaar.productscema;

import java.util.Map;

import com.google.gson.JsonObject;
import com.scalebazaar.productPlaceModule.Utils;

public class RuleFile {
	public void genRuleFile(String company){
		Utils objUtils = new Utils();
		RuleGeneration objRuleGeneration = new RuleGeneration();
		JsonObject jo = null;
		if(company.equals("ebay")){
			jo = objUtils.toJson(objRuleGeneration.ebay());
		}
		else if(company.equals("bonza")){
			jo = objUtils.toJson(objRuleGeneration.bonza());
		}
		else if(company.equals("lazada")){
			jo = objUtils.toJson(objRuleGeneration.lazada());
		}
		else if(company.equals("11street")){
			jo = objUtils.toJson(objRuleGeneration.street_11());
		}
		else if(company.equals("amazon")){
			jo = objUtils.toJson(objRuleGeneration.amazon());
		}
		System.out.println(jo.toString());
	}

	public void genRuleFile(Map<String, String> map) {
		Utils objUtils = new Utils();
		JsonObject jo = objUtils.toJson(map);
		System.out.println(jo.toString());
	}
	
}
