package com.scalebazaar.productscema;
import java.util.*;


public class ProductScemaEbay {
							
	Map<String , String> map = new HashMap<>();
	
	ShippingService ShippingService_1 = new ShippingService(); 
	ShippingService ShippingService_2 = new ShippingService();
	
	public ProductScemaEbay(){
		this.map.put("Category" , " ");					//required
		this.map.put("Title" , " ");						//required
		this.map.put("Subtitle" , " ");
		this.map.put("Description" , " ");					//required
		this.map.put("ConditionID" , " ");					//required
		this.map.put("PicURL" , " ");
		this.map.put("Quantity" , " ");					//required
		this.map.put("Format" , " ");						//required
		this.map.put("StartPrice" , " ");					//required
		this.map.put("BuyItNowPrice" , " ");
		this.map.put("Duration" , " ");					//required
		this.map.put("ImmediatePayRequired" , " ");
		this.map.put("Location" , " ");					//required
		this.map.put("GalleryType" , " ");
		this.map.put("PaisaPayAccepted" , " ");
		this.map.put("PaisaPayEscrow" , " ");
		this.map.put("PaisaPayEscrowEMI" , " ");
		this.map.put("PaymentInstructions" , " ");
		this.map.put("StoreCategory" , " ");
		this.map.put("ShippingDiscountProfileID" , " ");
		this.map.put("ShippingType" , " ");
		this.map.put("DispatchTimeMax" , " ");
		this.map.put("CustomLabel" , " ");
		this.map.put("ReturnsAcceptedOption" , " ");
		this.map.put("RefundOption" , " ");
		this.map.put("ReturnsWithinOption" , " ");
		this.map.put("ShippingCostPaidByOption" , " ");
		this.map.put("AdditionalDetails" , " ");
		this.map.put("WarrantyOffered" , " ");
		this.map.put("WarrantyType" , " ");
		this.map.put("WarrantyDuration" , " ");
		this.map.put("ShippingProfileName" , " ");
		this.map.put("ReturnProfileName" , " ");
		this.map.put("PaymentProfileName" , " ");
	}
	
	public boolean RequiredAttributesEbay(){
		boolean success = true;
		boolean fail = false;
		if(this.map.get("Category") != " " && this.map.get("Title") != " " && this.map.get("Description") != " " && this.map.get("ConditionID") != " " && this.map.get("Quantity") != " " && this.map.get("Format") != " " && this.map.get("StartPrice") != " " && this.map.get("Duration") != " " && this.map.get("Location")!= " ")
			return success;
		else 
			return fail;
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

