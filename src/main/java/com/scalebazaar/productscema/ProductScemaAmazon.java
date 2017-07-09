/**
 * 
 */
package com.scalebazaar.productscema;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ravi
 *
 */
public class ProductScemaAmazon {

	Map<String , String> map =new HashMap<>();
	public ProductScemaAmazon() {   //constructor to initalize the attributes to " " 
		this.map.put("item_sku" , " ");                              //required
		this.map.put("external_product_id" , " ");                   //required
		this.map.put("external_product_id_type" , " ");			  //required
		this.map.put("item_name" , " ");							  //required
		this.map.put("product_description" , " ");
		this.map.put("feed_product_type" , " ");					  //required
		this.map.put("brand_name" , " ");
		this.map.put("manufacturer" , " ");
		this.map.put("part_number" , " ");
		this.map.put("item_type" , " ");							  //required
		this.map.put("update_delete" , " ");
		this.map.put("model" , " ");
		//offer attributes:
		this.map.put("standard_price" , " ");
		this.map.put("condition_type" , " ");
		this.map.put("condition_note" , " ");
		this.map.put("quantity" , " ");
		this.map.put("list_price" , " ");
		this.map.put("this.map_price" , " ");
		this.map.put("product_site_launch_date" , " ");
		this.map.put("merchant_release_date" , " ");
		this.map.put("restock_date" , " ");
		this.map.put("fulfillment_latency" , " ");
		this.map.put("product_tax_code" , " ");
		this.map.put("sale_price" , " ");
		this.map.put("sale_from_date" , " ");
		this.map.put("sale_end_date" , " ");
		this.map.put("item_package_quantity" , " ");
		this.map.put("max_aggregate_ship_quantity" , " ");
		this.map.put("offering_can_be_gift_messaged" , " ");
		this.map.put("offering_can_be_giftwrapped" , " ");
		this.map.put("is_discontinued_by_manufacturer" , " ");
		this.map.put("max_order_quantity" , " ");
		this.map.put("number_of_items" , " ");
		this.map.put("offering_start_date" , " ");
		this.map.put("merchant_shipping_group_name" , " ");		 //required
		//dimension attributes:
		this.map.put("website_shipping_weight" , " ");
		this.map.put("website_shipping_weight_unit_of_measure" , " ");
		this.map.put("item_display_length" , " ");
		this.map.put("item_display_width" , " ");
		this.map.put("item_display_height" , " "); 
		this.map.put("display_dimensions_unit_of_measure" , " ");
		this.map.put("item_display_weight" , " ");
		this.map.put("item_display_weight_unit_of_measure" , " ");
		this.map.put("volume_capacity_name" , " ");
		this.map.put("volume_capacity_name_unit_of_measure" , " ");
		this.map.put("item_height" , " ");
		this.map.put("item_width" , " ");
		this.map.put("item_length" , " ");
		this.map.put("item_length_unit_of_measure" , " ");
		this.map.put("item_weight" , " ");
		this.map.put("item_weight_unit_of_measure" , " ");
		//item discovery attributes:
		this.map.put("bullet_point1" , " ");
		this.map.put("bullet_point2" , " ");
		this.map.put("bullet_point3" , " ");
		this.map.put("bullet_point4" , " ");
		this.map.put("bullet_point5" , " ");
		this.map.put("target_audience_base" , " ");
		this.map.put("catalog_number" , " ");
		this.map.put("specific_uses_keywords1" , " ");
		this.map.put("specific_uses_keywords2" , " ");
		this.map.put("specific_uses_keywords3" , " ");
		this.map.put("specific_uses_keywords4" , " ");
		this.map.put("specific_uses_keywords5" , " ");
		this.map.put("target_audience_keywords1" , " "); 
		this.map.put("target_audience_keywords2" , " ");
		this.map.put("target_audience_keywords3" , " ");
		this.map.put("thesaurus_subject_keywords1" , " ");
		this.map.put("thesaurus_subject_keywords2" , " ");
		this.map.put("thesaurus_subject_keywords3" , " ");
		this.map.put("generic_keywords" , " ");
		//image attributes:
		this.map.put("main_image_url" , " ");						//required
		this.map.put("swatch_image_url" , " ");
		this.map.put("other_image_url1" , " ");
		this.map.put("other_image_url2" , " ");
		this.map.put("other_image_url3" , " ");
		//fulfillment attributes:
		this.map.put("fulfillment_center_id" , " ");
		this.map.put("package_height" , " ");
		this.map.put("package_width" , " ");
		this.map.put("package_length" , " ");
		this.map.put("package_length_unit_of_measure" , " ");
		this.map.put("package_weight" , " ");
		this.map.put("package_weight_unit_of_measure" , " ");
		this.map.put("legal_compliance_certification_metadata" , " ");
		this.map.put("legal_compliance_certification_expiration_date" , " ");
		//product variation attributes:
		this.map.put("parent_child" , " ");
		this.map.put("parent_sku" , " ");
		this.map.put("relationship_type" , " ");
		this.map.put("variation_theme" , " ");
	    //compliance attributes:
		this.map.put("prop_65" , " ");
		this.map.put("cpsia_cautionary_statement" , " ");
		this.map.put("cpsia_cautionary_description" , " ");
		this.map.put("country_string" , " ");
		this.map.put("country_of_origin" , " ");
		this.map.put("legal_disclaimer_description" , " ");
		this.map.put("safety_warning" , " ");
		this.map.put("lighting_facts_image_url" , " ");
		this.map.put("energy_efficiency_image_url" , " ");
		this.map.put("fabric_type" , " ");
		this.map.put("import_designation" , " ");
		//home and bed&bath product attributes:
		this.map.put("warranty_description" , " ");
		this.map.put("thesaurus_attribute_keywords1" , " ");
		this.map.put("thesaurus_attribute_keywords2" , " ");
		this.map.put("thesaurus_attribute_keywords3" , " ");
		this.map.put("thesaurus_attribute_keywords4" , " ");
		this.map.put("country_as_labeled" , " ");
		this.map.put("fur_description" , " ");
		this.map.put("number_of_sets" , " ");
		this.map.put("occasion" , " ");
		this.map.put("thread_count" , " ");
		this.map.put("number_of_pieces" , " ");
		this.map.put("item_shape" , " ");
		this.map.put("scent_name" , " ");
		this.map.put("included_components" , " ");
		this.map.put("light_source_type" , " ");
		this.map.put("color_name" , " ");
		this.map.put("color_this.map" , " ");
		this.map.put("size_name" , " ");
		this.map.put("size_this.map" , " ");
		this.map.put("material_type" , " ");
		this.map.put("style_name" , " ");
		this.map.put("wattage" , " ");
		this.map.put("specific_uses_for_product" , " ");
		this.map.put("special_features" , " ");
		this.map.put("usda_hardiness_zone1" , " ");
		this.map.put("usda_hardiness_zone2" , " ");
		this.map.put("pattern_name" , " ");
		this.map.put("battery_type" , " ");
		this.map.put("number_of_batteries" , " ");
		this.map.put("lithium_battery_weight" , " ");
		this.map.put("specification_met" , " ");
		this.map.put("mfg_minimum" , " ");
		this.map.put("mfg_maximum" , " ");
		this.map.put("material_composition" , " ");
		this.map.put("fill_material_type" , " ");
		this.map.put("lithium_battery_weight_unit_of_measure" , " ");
		this.map.put("wattage_unit_of_measure" , " ");
		//extra for kitchen:
		this.map.put("blade_edge_type" , " ");
		this.map.put("blade_material_type" , " ");
		//extra for outdoor living:
		this.map.put("theme" , " ");
		this.map.put("power_source_type" , " ");
		this.map.put("voltage" , " ");
		this.map.put("engine_type" , " ");
		this.map.put("hose_length" , " ");
		this.map.put("hose_length_unit_of_measure" , " ");
		//extra for Art and crafts:
		this.map.put("paint_type" , " ");
		//extra for seeds and plants: 
		this.map.put("thesaurus_attribute_keywords" , " ");
		
	}



	public boolean RequiredAttributesAmazon(){
		boolean success = true;
		boolean fail = false;
		if(this.map.get("item_sku") != " " && this.map.get("apexternal_product_id") != " " && this.map.get("external_product_id_type") != " " && this.map.get("item_name") != " " && this.map.get("feed_product_type") != " " && this.map.get("item_type") != " " && this.map.get("merchant_shipping_group_name") != " " && this.map.get("main_image_url") != " ")
		{
			return success;
		}
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
