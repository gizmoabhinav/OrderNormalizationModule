package com.scalebazaar.productscema;

import java.util.HashMap;
import java.util.Map;

public class CreateJsonScema {
	public void amazon(){
		@SuppressWarnings("unused")
		Map<String , String> mapAmazon  = new HashMap<>();
		//mapAmazon.put(key, value);
		
	}
	public void lazada(){
		Map<String , String> mapLazada  = new HashMap<>();
		mapLazada.put("PrimaryCategory","productCategory");
		mapLazada.put("name","productName");
		mapLazada.put("short_description" , "shortDescription");
		mapLazada.put("ProductDescription" , "productDescription");
		mapLazada.put("video" , "videoURL");
		mapLazada.put("brand", "BrandID");
		mapLazada.put("model ", "model");
		mapLazada.put("color_family", "colorFamily");
		mapLazada.put("Hazmat", "hazmat");
		mapLazada.put("style", "style");
		mapLazada.put("type_digital", "typeDigital");
		mapLazada.put("mounting", "mounting");
		mapLazada.put("matetial", "matetial");
		mapLazada.put("recommended_gender", "recommendedGender");
		mapLazada.put("thread_count", "threadCount");
		mapLazada.put("thickness", "thickness");
		mapLazada.put("number_of_doors", "numberOfDoors");
		mapLazada.put("number_of_pieces", "numberOfPieces");
		mapLazada.put("foldable", "foldable");
		mapLazada.put("clock_type", "clockType");
		mapLazada.put("shape", "shape");
		mapLazada.put("type_curtain", "typeCurtain");
		mapLazada.put("paper_type", "paperType");
		mapLazada.put("painting_category", "paintingCategory");
		mapLazada.put("orientation", "orientation");
		mapLazada.put("capacity_battery", "capacityBattery");
		mapLazada.put("power_source", "powerSource");
		mapLazada.put("input_voltage", "inputVoltage");
		mapLazada.put("capacity", "capacity");
		mapLazada.put("induction_voltage", "inductionVoltage");
		mapLazada.put("cookware_finish", "cookwareFinish");
		mapLazada.put("pot_pan_size", "potPanSize");
		mapLazada.put("calculator_power_source", "calculatorPowerSource");
		mapLazada.put("binding", "binding");
		mapLazada.put("number_of_pages", "numberOfPages");
		mapLazada.put("warranty_type", "warrantyType");
		mapLazada.put("warranty", "warrantyPeriod");
		mapLazada.put("product_warranty", "productWarranty");
		mapLazada.put("name_ms", "nameMs");
		mapLazada.put("product_warranty_en", "productWarrantyEn");
		mapLazada.put("description_ms", "productDescriptionMs");
		mapLazada.put("external_url", "externalUrl");
		mapLazada.put("SellerSku", "itemVariantSKU");
		mapLazada.put("AssociatedSku ", "associatedSKU");
		mapLazada.put("barcode_ean", "Barcode");
		mapLazada.put("quantity", "maxOrderQuantity");
		mapLazada.put("price", "mrp");
		mapLazada.put("special_price", "specialPrice");
		mapLazada.put("special_from_date", "specialPriceFromoDate");
		mapLazada.put("special_to_date", "specialPriceToDate");
		mapLazada.put("seller_promotion", "sellerPromotion");
		mapLazada.put("package_content", "packageContent");
		mapLazada.put("package_weight", "productWeight");
		mapLazada.put("package_length", "length");
		mapLazada.put("package_width", "width");
		mapLazada.put("MainImage", "image1");
		mapLazada.put("Image2", "image2");
		mapLazada.put("Image3", "image3");
		mapLazada.put("Image4", "image4");
		mapLazada.put("Image5", "image5");
		mapLazada.put("Image6", "image6");
		mapLazada.put("Image7", "image7");
		mapLazada.put("Image8", "image8");
		mapLazada.put("tax_class", "taxClass");
		mapLazada.put("published_date", "publishedDate");
		mapLazada.put("bedding_size_2", "beddingSize2");
		mapLazada.put("filling", "filling");
		mapLazada.put("size", "size");
		mapLazada.put("holding_capacity", "holdingCapactity");
		mapLazada.put("paper_size", "paperSize");
		String json = new String("");
		json = "{" +mapLazada.get("PrimaryCategory")+ ":"+ "PrimaryCategory" +"}";
		Map<String , String> json_main = new HashMap<>();
		json_main.put("SPU Attributes", json);
		json = new String("{" + mapLazada.get("name") + ":" + "name , " + mapLazada.get("short_description") +":" + "short_description , " + mapLazada.get("description") + ":" + "\"description\" , "+mapLazada.get("video")+ "\"video\""+"}");
		json_main.put("Basic Attributes", json);
		json =new String("{"+mapLazada.get("brand")+":"+"\"brand\" , "+mapLazada.get("model") + "\"model\" ,"+mapLazada.get("color_family")+":"+"\"color_family\" , "+mapLazada.get("Hazmat") + "\"Hazmat\" ," "}");
	}
	public void street_11(){
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
	}
	public void ebay(){
		Map<String , String> mapEbay  = new HashMap<>();
		mapEbay.put("key", "value");
		
	}

}
