package com.scalebazaar.placeordernormalizationmoduler;

import java.util.ArrayList;

import com.scalebazaar.productscema.ProductScemaLazada;
import com.scalebazaar.productscema.ProductScemaScalelabs;

public class CovertToDifferentClients {
	public Object covertToLazada(ProductScemaScalelabs pssl){
		ProductScemaLazada psl = new ProductScemaLazada();
		psl.setSellerSku(pssl.getItemSKU());
		psl.setName(pssl.getProductName());
		//psl.setAssociatedSku(pssl.getItemVariantSKU());
		psl.setBarcode_ean(pssl.getBarcode());
		psl.setPrimaryCategory(pssl.getProductCategory());
		
		return psl;
		
	}
	public Object covertTo11Street(ProductScemaScalelabs pssl){
		return pssl;
		
	}
	public Object covertToBonza(ProductScemaScalelabs pssl){
		return pssl;
		
	}
	public Object covertToeBay(ProductScemaScalelabs pssl){
		return pssl;
		
	}
	public Object covertToAmazon(ProductScemaScalelabs pssl){
		return pssl;
		
	}
	public void covertToScalelabs(ArrayList<String[]> row){
		System.out.println("hdljd;k'l"+ row.get(0).length);
		for(int  i =0 ; i < row.get(0).length ; i++){
			System.out.println(row.get(0)[i]);
		}
		System.out.println(row.size());
		
		
	}

}
