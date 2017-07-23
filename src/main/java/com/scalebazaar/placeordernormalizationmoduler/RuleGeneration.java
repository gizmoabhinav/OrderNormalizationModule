package com.scalebazaar.productscema;

import java.util.HashMap;
import java.util.Map;

public class RuleGeneration {
	public Map<String, String> amazon(){
		Map<String , String> mapAmazon  = new HashMap<>();
		//mapAmazon.put(key, value);
		//mapAmazon.put(scalelabsscema,amazonscema);
		mapAmazon.put("itemSKU", "item_sku");
		mapAmazon.put("productID", "external_product_id");
		mapAmazon.put("ExternalProductIdType", "external_product_id_type");
		mapAmazon.put("productName", "item_name");
		mapAmazon.put("productDescription", "product_description");
		mapAmazon.put("itemTypeKeyword", "feed_product_type");
		mapAmazon.put("BrandName", "brand_name");
		mapAmazon.put("manufacturer", "manufacturer");
		mapAmazon.put("PartNumber", "part_number");
		mapAmazon.put("itemTypeKeyword", "item_type");
		mapAmazon.put("update_delete", "update_delete");
		mapAmazon.put("model", "model");
		mapAmazon.put("mrp", "standard_price");
		mapAmazon.put("ConditionType", "condition_type");
		mapAmazon.put("ConditionNote", "condition_note");
		mapAmazon.put("quantity", "quantity");
		mapAmazon.put("ListPrice", "list_price");
		mapAmazon.put("MapPrice", "map_price");
		mapAmazon.put("ProductSiteLaunchDate", "product_site_launch_date");
		mapAmazon.put("MerchantReleaseDate", "merchant_release_date");
		mapAmazon.put("RestockDate", "restock_date");
		mapAmazon.put("FulfillmentLatency", "fulfillment_latency");
		mapAmazon.put("ProductTaxCode", "product_tax_code");
		mapAmazon.put("specialPrice", "sale_price");
		mapAmazon.put("specialPriceFromDate", "sale_from_date");
		mapAmazon.put("specialPriceToDate", "sale_end_date");
		mapAmazon.put("item_package_quantity", "item_package_quantity");
		mapAmazon.put("max_aggregate_ship_quantity", "max_aggregate_ship_quantity");
		mapAmazon.put("offering_can_be_gift_messaged", "offering_can_be_gift_messaged");
		mapAmazon.put("offering_can_be_giftwrapped", "offering_can_be_giftwrapped");
		mapAmazon.put("is_discontinued_by_manufacturer", "is_discontinued_by_manufacturer");
		mapAmazon.put("maxOrderQuantity", "max_order_quantity");
		mapAmazon.put("NumberofItems", "number_of_items");
		mapAmazon.put("offering_start_date", "offering_start_date");
		mapAmazon.put("MerchantName", "merchant_shipping_group_name");
		mapAmazon.put("ShippingWeight", "website_shipping_weight");
		mapAmazon.put("ShippingWeight_UnitofMeasure", "website_shipping_weight_unit_of_measure");
		mapAmazon.put("ItemDisplayLength", "item_display_length");
		mapAmazon.put("ItemDisplayWidth", "item_display_width");
		mapAmazon.put("ItemDisplayHeight", "item_display_height");
		mapAmazon.put("display_dimensions_unit_of_measure", "display_dimensions_unit_of_measure");
		mapAmazon.put("item_display_weight", "item_display_weight");
		mapAmazon.put("item_display_weight_unit_of_measure", "item_display_weight_unit_of_measure");
		mapAmazon.put("volume_capacity_name", "volume_capacity_name");
		mapAmazon.put("volume_capacity_name_unit_of_measure", "volume_capacity_name_unit_of_measure");
		mapAmazon.put("ItemHeight", "item_height");
		mapAmazon.put("width", "item_width");
		mapAmazon.put("length", "item_length");
		mapAmazon.put("item_length_unit_of_measure", "item_length_unit_of_measure");
		mapAmazon.put("productWeight", "item_weight");
		mapAmazon.put("item_weight_unit_of_measure", "item_weight_unit_of_measure");
		mapAmazon.put("bullet_point1", "bullet_point1"); 
		mapAmazon.put("bullet_point2", "bullet_point2"); 
		mapAmazon.put("bullet_point3", "bullet_point3"); 
		mapAmazon.put("bullet_point4", "bullet_point4"); 
		mapAmazon.put("bullet_point5", "bullet_point5");
		mapAmazon.put("target_audience_base", "target_audience_base");
		mapAmazon.put("catalog_number", "catalog_number");
		mapAmazon.put("specific_uses_keywords1", "specific_uses_keywords1");
		mapAmazon.put("specific_uses_keywords2", "specific_uses_keywords2");
		mapAmazon.put("specific_uses_keywords3", "specific_uses_keywords3");
		mapAmazon.put("specific_uses_keywords4", "specific_uses_keywords4");
		mapAmazon.put("specific_uses_keywords5", "specific_uses_keywords5");
		mapAmazon.put("target_audience_keywords1", "target_audience_keywords1");
		mapAmazon.put("target_audience_keywords2", "target_audience_keywords2");
		mapAmazon.put("target_audience_keywords3", "target_audience_keywords3");
		mapAmazon.put("thesaurus_subject_keywords1", "thesaurus_subject_keywords1");
		mapAmazon.put("thesaurus_subject_keywords2", "thesaurus_subject_keywords2");
		mapAmazon.put("thesaurus_subject_keywords3", "thesaurus_subject_keywords3");
		mapAmazon.put("generic_keywords", "generic_keywords");
		mapAmazon.put("MainImageURL", "main_image_url");
		mapAmazon.put("SwatchImageURL", "swatch_image_url");
		mapAmazon.put("image1", "other_image_url1");
		mapAmazon.put("image2", "other_image_url2");
		mapAmazon.put("image3", "other_image_url3");
		mapAmazon.put("fulfillment_center_id", "fulfillment_center_id");
		mapAmazon.put("package_height", "package_height");
		mapAmazon.put("package_width", "package_width");
		mapAmazon.put("package_length", "package_length");
		mapAmazon.put("package_length_unit_of_measure", "package_length_unit_of_measure");
		mapAmazon.put("package_weight", "package_weight");
		mapAmazon.put("package_weight_unit_of_measure", "package_weight_unit_of_measure");
		mapAmazon.put("legal_compliance_certification_metadata", "legal_compliance_certification_metadata");
		mapAmazon.put("legal_compliance_certification_expiration_date", "legal_compliance_certification_expiration_date");
		mapAmazon.put("parent_child", "parent_child");
		mapAmazon.put("parent_sku", "parent_sku");
		mapAmazon.put("relationship_type", "relationship_type");
		mapAmazon.put("variation_theme", "variation_theme");
		mapAmazon.put("prop_65", "prop_65");
		mapAmazon.put("cpsia_cautionary_statement", "cpsia_cautionary_statement");
		mapAmazon.put("cpsia_cautionary_description", "cpsia_cautionary_description");
		mapAmazon.put("country_string", "country_string");
		mapAmazon.put("country_of_origin", "country_of_origin");
		mapAmazon.put("legal_disclaimer_description", "legal_disclaimer_description");
		mapAmazon.put("safety_warning", "safety_warning");
		mapAmazon.put("lighting_facts_image_url", "lighting_facts_image_url");
		mapAmazon.put("energy_efficiency_image_url", "energy_efficiency_image_url");
		mapAmazon.put("fabric_type", "fabric_type");
		mapAmazon.put("import_designation", "import_designation");
		mapAmazon.put("warranty_description", "warranty_description");
		mapAmazon.put("thesaurus_attribute_keywords1", "thesaurus_attribute_keywords1");
		mapAmazon.put("thesaurus_attribute_keywords2", "thesaurus_attribute_keywords2");
		mapAmazon.put("thesaurus_attribute_keywords3", "thesaurus_attribute_keywords3");
		mapAmazon.put("thesaurus_attribute_keywords4", "thesaurus_attribute_keywords4");
		mapAmazon.put("country_as_labeled", "country_as_labeled");
		mapAmazon.put("fur_description", "fur_description");
		mapAmazon.put("number_of_sets", "number_of_sets");
		mapAmazon.put("occasion", "occasion");
		mapAmazon.put("threadCount", "thread_count");
		mapAmazon.put("numberOfPieces", "number_of_pieces");
		mapAmazon.put("shape", "item_shape");
		mapAmazon.put("scent_name", "scent_name");
		mapAmazon.put("included_components", "included_components");
		mapAmazon.put("light_source_type", "light_source_type");
		mapAmazon.put("color_name", "color_name");
		mapAmazon.put("color_map", "color_map");
		mapAmazon.put("size_name", "size_name");
		mapAmazon.put("size_map", "size_map");
		mapAmazon.put("material", "material_type");
		mapAmazon.put("style_name", "style_name");
		mapAmazon.put("wattage", "wattage");
		mapAmazon.put("specific_uses_for_product", "specific_uses_for_product");
		mapAmazon.put("special_features", "special_features");
		mapAmazon.put("usda_hardiness_zone1", "usda_hardiness_zone1"); 
		mapAmazon.put("usda_hardiness_zone2", "usda_hardiness_zone2");
		mapAmazon.put("pattern_name", "pattern_name");
		mapAmazon.put("battery_type", "battery_type");
		mapAmazon.put("number_of_batteries", "number_of_batteries");
		mapAmazon.put("lithium_battery_weight", "lithium_battery_weight");
		mapAmazon.put("specification_met", "specification_met");
		mapAmazon.put("mfg_minimum", "mfg_minimum");
		mapAmazon.put("mfg_maximum", "mfg_maximum");
		mapAmazon.put("material_composition", "material_composition");
		mapAmazon.put("fill_material_type", "fill_material_type");
		mapAmazon.put("lithium_battery_weight_unit_of_measure", "lithium_battery_weight_unit_of_measure");
		mapAmazon.put("wattage_unit_of_measure", "wattage_unit_of_measure");
		mapAmazon.put("blade_edge_type", "blade_edge_type");
		mapAmazon.put("blade_material_type", "blade_material_type");
		mapAmazon.put("theme", "theme");
		mapAmazon.put("powerSource", "power_source_type");
		mapAmazon.put("inputVoltage", "voltage");
		mapAmazon.put("engine_type", "engine_type");
		mapAmazon.put("hose_length", "hose_length");
		mapAmazon.put("hose_length_unit_of_measure", "hose_length_unit_of_measure");
		mapAmazon.put("paint_type", "paint_type");
		mapAmazon.put("thesaurus_attribute_keywords", "thesaurus_attribute_keywords");
		return mapAmazon;
	}
	public Map<String, String> lazada(){
		Map<String , String> mapLazada  = new HashMap<>();
		mapLazada.put("productCategory" , "PrimaryCategory");
		mapLazada.put("productName" , "name");
		mapLazada.put("shortDescription" , "short_description" );
		mapLazada.put("productDescription" , "ProductDescription" );
		mapLazada.put("videoURL" , "video");
		mapLazada.put("BrandID" , "brand" );
		mapLazada.put("model" , "model " );
		mapLazada.put("colorFamily" , "color_family");
		mapLazada.put("hazmat" , "Hazmat");
		mapLazada.put("style" , "style");
		mapLazada.put("typeDigital" ,"type_digital");
		mapLazada.put("mounting" , "mounting");
		mapLazada.put("matetial" ,"matetial" );
		mapLazada.put("recommendedGender" ,"recommended_gender");
		mapLazada.put("threadCount" , "thread_count");
		mapLazada.put("thickness" ,"thickness");
		mapLazada.put("numberOfDoors" ,"number_of_doors");
		mapLazada.put("numberOfPieces" ,"number_of_pieces");
		mapLazada.put("foldable" ,"foldable");
		mapLazada.put("clockType" ,"clock_type");
		mapLazada.put("shape" ,"shape");
		mapLazada.put("typeCurtain" ,"type_curtain");
		mapLazada.put("paperType" ,"paper_type");
		mapLazada.put("paintingCategory" ,"painting_category");
		mapLazada.put("orientation" ,"orientation");
		mapLazada.put("capacityBattery" ,"capacity_battery");
		mapLazada.put("powerSource" ,"power_source");
		mapLazada.put("inputVoltage" ,"input_voltage");
		mapLazada.put("capacity" , "capacity");
		mapLazada.put("inductionVoltage" ,"induction_voltage");
		mapLazada.put("cookwareFinish" ,"cookware_finish");
		mapLazada.put("potPanSize" ,"pot_pan_size");
		mapLazada.put("calculatorPowerSource" ,"calculator_power_source");
		mapLazada.put("binding" ,"binding");
		mapLazada.put("numberOfPages" ,"number_of_pages");
		mapLazada.put("warrantyType" ,"warranty_type");
		mapLazada.put("warrantyPeriod" ,"warranty");
		mapLazada.put("productWarranty" ,"product_warranty");
		mapLazada.put("nameMs" ,"name_ms");
		mapLazada.put("productWarrantyEn" ,"product_warranty_en");
		mapLazada.put("productDescriptionMs" ,"description_ms");
		mapLazada.put("externalUrl" ,"external_url");
		mapLazada.put("itemVariantSKU" ,"SellerSku");
		mapLazada.put("associatedSKU" ,"AssociatedSku ");
		mapLazada.put("Barcode" ,"barcode_ean");
		mapLazada.put("maxOrderQuantity" ,"quantity");
		mapLazada.put("mrp" ,"price");
		mapLazada.put("specialPrice" ,"special_price");
		mapLazada.put("specialPriceFromoDate" ,"special_from_date");
		mapLazada.put("specialPriceToDate" ,"special_to_date");
		mapLazada.put("sellerPromotion" ,"seller_promotion");
		mapLazada.put("packageContent" ,"package_content");
		mapLazada.put("productWeight" ,"package_weight");
		mapLazada.put("length" ,"package_length");
		mapLazada.put("width" ,"package_width");
		mapLazada.put("image1" ,"MainImage");
		mapLazada.put("image2" ,"Image2");
		mapLazada.put("image3" ,"Image3");
		mapLazada.put("image4" ,"Image4");
		mapLazada.put("image5" ,"Image5");
		mapLazada.put("image6" ,"Image6");
		mapLazada.put("image7" ,"Image7");
		mapLazada.put("image8" ,"Image8");
		mapLazada.put("taxClass" ,"tax_class");
		mapLazada.put("publishedDate" ,"published_date");
		mapLazada.put("beddingSize2" ,"bedding_size_2");
		mapLazada.put("filling" ,"filling");
		mapLazada.put("size" ,"size");
		mapLazada.put("holdingCapactity" ,"holding_capacity");
		mapLazada.put("paperSize" ,"paper_size");
		return mapLazada;
	}
	public Map<String, String> street_11(){
		Map<String , String> mapStreet11  = new HashMap<>();
		mapStreet11.put("version" , "version");
		mapStreet11.put("CategoryNumber" , "productCategory");
		mapStreet11.put("ProductName" , "productName");
		mapStreet11.put("SellerProductCode" , "productID");
		mapStreet11.put("PromotionalText" , "sellerPromotion");
		mapStreet11.put("PurchasablebyUnderage" , "PurchasablebyUnderage");
		mapStreet11.put("GSTApplication" , "GSTApplication");
		mapStreet11.put("GSTFlatrate" , "mrp");
		mapStreet11.put("MainImage" , "image1");
		mapStreet11.put("AdditionalImage1" , "image2");
		mapStreet11.put("AdditionalImage2" , "image3");
		mapStreet11.put("AdditionalImage3" , "image4");
		mapStreet11.put("DetailedDescription" , "productDescription");
		mapStreet11.put("SellingPrice" , "webPrice");
		mapStreet11.put("DiscountbySeller" , "specialPrice");
		mapStreet11.put("ProductWeight" , "productWeight");
		mapStreet11.put("ProductDimension" , "ProductDimension");
		mapStreet11.put("ProductOptionType" , "ProductOptionType");
		mapStreet11.put("OptionalValue" , "OptionalValue");
		mapStreet11.put("OptionalSKUCode" , "associatedSKU");
		mapStreet11.put("OptionStockQty" , "OptionStockQty");
		mapStreet11.put("AdditionalAmmountofOption" , "AdditionalAmmountofOption");
		mapStreet11.put("AddtionalWeightofOption" , "AddtionalWeightofOption");
		mapStreet11.put("StockQuantity" , "StockQuantity");
		mapStreet11.put("ShppingMethod" , "ShppingMethod");
		mapStreet11.put("ShippingRate" , "ShippingRate");
		mapStreet11.put("ShippingRateWestMalaysia" , "ShippingRateWestMalaysia");
		mapStreet11.put("ShippingRateSabahLabuan" , "ShippingRateSabahLabuan");
		mapStreet11.put("ShippingRateSawawak" , "ShippingRateSawawak");
		mapStreet11.put("Shippingpromotions" , "Shippingpromotions");
		mapStreet11.put("ShippingDiscount" , "ShippingDiscount");
		mapStreet11.put("AfterSaleServices" , "AfterSaleServices");
		mapStreet11.put("ReturnPolicy" , "ReturnPolicy");
		mapStreet11.put("Errormessage" , "Errormessage");
		return mapStreet11;
		
	}
	public Map<String, String> ebay(){
		Map<String , String> mapEbay  = new HashMap<>();
		//mapEbay.put("key", "value");
		//mapEbay.put("ScaleLabsScema" , "EbayScema")
		mapEbay.put("Category", "Category");
		mapEbay.put("Title", "Title");
		mapEbay.put("Subtitle", "Subtitle");
		mapEbay.put("productDescription", "Description");
		mapEbay.put("ConditionID", "ConditionID");
		mapEbay.put("MainImageURL", "PicURL");
		mapEbay.put("Quantity", "Quantity");
		mapEbay.put("Format", "Format");
		mapEbay.put("mrp", "StartPrice");
		mapEbay.put("BuyItNowPrice", "BuyItNowPrice");
		mapEbay.put("Duration", "Duration");
		mapEbay.put("ImmediatePayRequired", "ImmediatePayRequired");
		mapEbay.put("Location", "Location");
		mapEbay.put("GalleryType", "GalleryType");
		mapEbay.put("PaisaPayAccepted", "PaisaPayAccepted");
		mapEbay.put("PaisaPayEscrow", "PaisaPayEscrow");
		mapEbay.put("PaisaPayEscrowEMI", "PaisaPayEscrowEMI");
		mapEbay.put("PaymentInstructions", "PaymentInstructions");
		mapEbay.put("StoreCategory", "StoreCategory");
		mapEbay.put("ShippingDiscountProfileID", "ShippingDiscountProfileID");
		mapEbay.put("ShippingType", "ShippingType");
		mapEbay.put("DispatchTimeMax", "DispatchTimeMax");
		mapEbay.put("CustomLabel", "CustomLabel");
		mapEbay.put("ReturnsAcceptedOption", "ReturnsAcceptedOption");
		mapEbay.put("RefundOption", "RefundOption");
		mapEbay.put("ReturnsWithinOption", "ReturnsWithinOption");
		mapEbay.put("ShippingCostPaidByOption", "ShippingCostPaidByOption");
		mapEbay.put("AdditionalDetails", "AdditionalDetails");
		mapEbay.put("warranty_description", "WarrantyOffered");
		mapEbay.put("WarrantyType", "WarrantyType");
		mapEbay.put("WarrantyDuration", "WarrantyDuration");
		mapEbay.put("ShippingProfileName", "ShippingProfileName");
		mapEbay.put("ReturnProfileName", "ReturnProfileName");
		mapEbay.put("PaymentProfileName", "PaymentProfileName");
		mapEbay.put("ShippingService_1Option","ShippingService_1.getOption()");
		mapEbay.put("ShippingService_1Cost","ShippingService_1.getCost()");
		mapEbay.put("ShippingService_1Priority","ShippingService_1.getPriority()");
		mapEbay.put("ShippingService_1ShippingSurcharge","ShippingService_1.getShippingSurcharge()");
		mapEbay.put("ShippingService_2Option","ShippingService_2.getOption()");
		mapEbay.put("ShippingService_2Cost","ShippingService_2.getCost()");
		mapEbay.put("ShippingService_2Priority","ShippingService_2.getPriority()");
		mapEbay.put("ShippingService_2ShippingSurcharge","ShippingService_2.getShippingSurcharge()");
		return mapEbay;
	}
	public Map<String, String> bonza() {
		// TODO Auto-generated method stub
		return null;
	}

}
