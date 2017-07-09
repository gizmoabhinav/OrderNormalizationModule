package com.scalebazaar.productscema;

import java.util.HashMap;
import java.util.Map;

public class ProductScema11Street {
	Map<String , String> map = new HashMap<>();
	public ProductScema11Street(){
		this.map.put("version" , " ");
		this.map.put("CategoryNumber" , " ");
		this.map.put("ProductName" , " ");
		this.map.put("SellerProductCode" , " ");
		this.map.put("PromotionalText" , " ");
		this.map.put("PurchasablebyUnderage" , " ");
		this.map.put("GSTApplication" , " ");
		this.map.put("GSTFlatrate" , " ");
		this.map.put("MainImage" , " ");
		this.map.put("AdditionalImage1" , " ");
		this.map.put("AdditionalImage2" , " ");
		this.map.put("AdditionalImage3" , " ");
		this.map.put("DetailedDescription" , " ");
		this.map.put("SellingPrice" , " ");
		this.map.put("DiscountbySeller" , " ");
		this.map.put("ProductWeight" , " ");
		this.map.put("ProductDimension" , " ");
		this.map.put("ProductOptionType" , " ");
		this.map.put("OptionalValue" , " ");
		this.map.put("OptionalSKUCode" , " ");
		this.map.put("OptionStockQty" , " ");
		this.map.put("AdditionalAmmountofOption" , " ");
		this.map.put("AddtionalWeightofOption" , " ");
		this.map.put("StockQuantity" , " ");
		this.map.put("ShppingMethod" , " ");
		this.map.put("ShippingRate" , " ");
		this.map.put("ShippingRateWestMalaysia" , " ");
		this.map.put("ShippingRateSabahLabuan" , " ");
		this.map.put("ShippingRateSawawak" , " ");
		this.map.put("Shippingpromotions" , " ");
		this.map.put("ShippingDiscount" , " ");
		this.map.put("AfterSaleServices" , " ");
		this.map.put("ReturnPolicy" , " ");
		this.map.put("Errormessage" , " ");
	}
	public String get(String params){
		String valueOfParmas;
		valueOfParmas = this.map.get(params);
		return valueOfParmas;
	}
	public void set(String params , String valueOfParams){
		this.map.replace(params, valueOfParams);
	}
	public Map<String, String> getElements(){
		Map<String , String> return_map = new HashMap<>();
		for (Map.Entry<String, String> entry : this.map.entrySet()){
			if(entry.getValue() == " "){
			    System.out.println(entry.getKey() + "/" + entry.getValue());

			}
			else{
				return_map.put(entry.getKey(), entry.getValue());
			}
		}
		return return_map;
	}
}
