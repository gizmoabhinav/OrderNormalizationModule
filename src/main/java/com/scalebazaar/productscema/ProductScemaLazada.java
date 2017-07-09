/**
 *  @author Sagar Gupta
 */
package com.scalebazaar.productscema;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ADMINIBM
 *
 */
public class ProductScemaLazada {
	Map<String , String> map = new HashMap<>();
	public ProductScemaLazada(){
		this.map.put("PrimaryCategory" , " ");
		this.map.put("name" , " ");
		this.map.put("short_description" , " ");
		this.map.put("ProductDescription" , " ");
		this.map.put("video" , " ");
		this.map.put("brand" , " ");
		this.map.put("model" , " ");
		this.map.put("color_family" , " ");
		this.map.put("Hazmat" , " ");
		this.map.put("style" , " ");
		this.map.put("type_digital" , " ");
		this.map.put("mounting" , " ");
		this.map.put("matetial" , " ");
		this.map.put("recommended_gender" , " ");
		this.map.put("thread_count" , " ");
		this.map.put("thickness" , " ");
		this.map.put("number_of_doors" , " ");
		this.map.put("number_of_pieces" , " ");
		this.map.put("foldable" , " ");
		this.map.put("clock_type" , " ");
		this.map.put("shape" , " ");
		this.map.put("type_curtain" , " ");
		this.map.put("paper_type" , " ");
		this.map.put("painting_category" , " ");
		this.map.put("orientation" , " ");
		this.map.put("capacity_battery" , " ");
		this.map.put("power_source" , " ");
		this.map.put("input_voltage" , " ");
		this.map.put("capacity" , " ");
		this.map.put("induction_voltage" , " ");
		this.map.put("cookware_finish" , " ");
		this.map.put("pot_pan_size" , " ");
		this.map.put("calculator_power_source" , " ");
		this.map.put("binding" , " ");
		this.map.put("number_of_pages" , " ");
		this.map.put("warranty_type" , " ");
		this.map.put("warranty" , " ");
		this.map.put("product_warranty" , " ");
		this.map.put("name_ms" , " ");
		this.map.put("product_warranty_en" , " ");
		this.map.put("description_ms" , " ");
		this.map.put("external_url" , " ");
		this.map.put("SellerSku" , " ");
		this.map.put("AssociatedSku" , " ");
		this.map.put("barcode_ean" , " ");
		this.map.put("quantity" , " ");
		this.map.put("price" , " ");
		this.map.put("special_price" , " ");
		this.map.put("special_from_date" , " ");
		this.map.put("special_to_date" , " ");
		this.map.put("seller_promotion" , " ");
		this.map.put("package_content" , " ");
		this.map.put("package_weight" , " ");
		this.map.put("package_length" , " ");
		this.map.put("package_width" , " ");
		this.map.put("MainImage" , " ");
		this.map.put("Image2" , " ");
		this.map.put("Image3" , " ");
		this.map.put("Image4" , " ");
		this.map.put("Image5" , " ");
		this.map.put("Image6" , " ");
		this.map.put("Image7" , " ");
		this.map.put("Image8" , " ");
		this.map.put("tax_class" , " ");
		this.map.put("published_date" , " ");
		this.map.put("bedding_size_2" , " ");
		this.map.put("filling" , " ");
		this.map.put("size" , " ");
		this.map.put("holding_capacity" , " ");
		this.map.put("paper_size" , " ");
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