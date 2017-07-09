package com.scalebazaar.productPlaceModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.scalebazaar.productscema.CreateJsonScema;
import com.scalebazaar.productscema.ProductScema11Street;
import com.scalebazaar.productscema.ProductScemaAmazon;
import com.scalebazaar.productscema.ProductScemaLazada;
import com.scalebazaar.productscema.ProductScemaScalelabs;

public class CovertToDifferentClients {
	public Object covertToLazada(ProductScemaScalelabs pssl){
		CreateJsonScema cjs = new CreateJsonScema();
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
		CreateJsonScema cjs = new CreateJsonScema();
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
	public Object covertToBonza(ProductScemaScalelabs pssl){
		CreateJsonScema cjs = new CreateJsonScema();
		ProductScemaLazada psl = new ProductScemaLazada();
		Map<String , String> mapScalelabs = new HashMap<>();
		mapScalelabs = pssl.getElements();
		Map<String ,String> mapMapping = new HashMap<>();
		mapMapping = cjs.bonza();
		for (Map.Entry<String, String> entry : mapMapping.entrySet()){
			String valueToAdd = mapScalelabs.get(entry.getKey());
			psl.set(entry.getValue(), valueToAdd);
		}
		return psl;
	}
	public Object covertToeBay(ProductScemaScalelabs pssl){
		CreateJsonScema cjs = new CreateJsonScema();
		ProductScemaLazada psl = new ProductScemaLazada();
		Map<String , String> mapScalelabs = new HashMap<>();
		mapScalelabs = pssl.getElements();
		Map<String ,String> mapMapping = new HashMap<>();
		mapMapping = cjs.ebay();
		for (Map.Entry<String, String> entry : mapMapping.entrySet()){
			String valueToAdd = mapScalelabs.get(entry.getKey());
			psl.set(entry.getValue(), valueToAdd);
		}
		return psl;
	}
	public Object covertToAmazon(ProductScemaScalelabs pssl){
		CreateJsonScema cjs = new CreateJsonScema();
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
