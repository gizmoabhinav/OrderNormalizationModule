package com.scalebazaar.productPlaceModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.scalebazaar.productscema.ProductScema11Street;
import com.scalebazaar.productscema.ProductScemaAmazon;
import com.scalebazaar.productscema.ProductScemaEbay;
import com.scalebazaar.productscema.ProductScemaLazada;
import com.scalebazaar.productscema.ProductScemaScalelabs;
import com.scalebazaar.productscema.RuleGeneration;

public class CovertToDifferentClients {
	public Object covertToLazada(ProductScemaScalelabs pssl){
		RuleGeneration cjs = new RuleGeneration();
		ProductScemaLazada psl = new ProductScemaLazada();
		Map<String , String> mapScalelabs = new HashMap<>();
		mapScalelabs = pssl.getElements();
		Map<String ,String> mapMapping = new HashMap<>();
		mapMapping = cjs.lazada();
		for (Map.Entry<String, String> entry : mapMapping.entrySet()){
			String valueToAdd = mapScalelabs.get(entry.getKey());
			psl.set(entry.getValue(), valueToAdd);
		}
		return psl;
	}
	public Object covertTo11Street(ProductScemaScalelabs pssl){
		RuleGeneration cjs = new RuleGeneration();
		ProductScema11Street pss = new ProductScema11Street();
		Map<String , String> mapScalelabs = new HashMap<>();
		mapScalelabs = pssl.getElements();
		Map<String ,String> mapMapping = new HashMap<>();
		mapMapping = cjs.street_11();
		for (Map.Entry<String, String> entry : mapMapping.entrySet()){
			String valueToAdd = mapScalelabs.get(entry.getKey());
			pss.set(entry.getValue(), valueToAdd);
		}
		return pss;
	}
	// NEED TO CHANGE
	public Object covertToBonza(ProductScemaScalelabs pssl){
		RuleGeneration cjs = new RuleGeneration();
		ProductScemaLazada psb = new ProductScemaLazada();
		Map<String , String> mapScalelabs = new HashMap<>();
		mapScalelabs = pssl.getElements();
		Map<String ,String> mapMapping = new HashMap<>();
		mapMapping = cjs.bonza();
		for (Map.Entry<String, String> entry : mapMapping.entrySet()){
			String valueToAdd = mapScalelabs.get(entry.getKey());
			psb.set(entry.getValue(), valueToAdd);
		}
		return psb;
	}
	public Object covertToeBay(ProductScemaScalelabs pssl){
		RuleGeneration cjs = new RuleGeneration();
		ProductScemaEbay pse = new ProductScemaEbay();
		Map<String , String> mapScalelabs = new HashMap<>();
		mapScalelabs = pssl.getElements();
		Map<String ,String> mapMapping = new HashMap<>();
		mapMapping = cjs.ebay();
		for (Map.Entry<String, String> entry : mapMapping.entrySet()){
			String valueToAdd = mapScalelabs.get(entry.getKey());
			pse.set(entry.getValue(), valueToAdd);
		}
		return pse;
	}
	public Object covertToAmazon(ProductScemaScalelabs pssl){
		RuleGeneration cjs = new RuleGeneration();
		ProductScemaAmazon psa = new ProductScemaAmazon();
		Map<String , String> mapScalelabs = new HashMap<>();
		mapScalelabs = pssl.getElements();
		Map<String ,String> mapMapping = new HashMap<>();
		mapMapping = cjs.amazon();
		for (Map.Entry<String, String> entry : mapMapping.entrySet()){
			String valueToAdd = mapScalelabs.get(entry.getKey());
			psa.set(entry.getValue(), valueToAdd);
		}
		return psa;
	}
	public Object covertToScalelabs(ArrayList<String[]> row){
		System.out.println("hdljd;k'l"+ row.get(0).length);
		for(int  i =0 ; i < row.get(0).length ; i++){
			System.out.println(row.get(0)[i]);
		}
		System.out.println(row.size());
		return row;
		
		
	}

}
