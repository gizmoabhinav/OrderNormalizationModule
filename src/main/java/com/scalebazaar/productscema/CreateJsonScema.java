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
		String json = new String("");
		json = "{" +mapLazada.get("PrimaryCategory")+ ":"+ "PrimaryCategory" +"}";
		Map<String , String> json_main = new HashMap<>();
		json_main.put("SPU Attributes", json);
		json = new String("{" + mapLazada.get("name") + ":" + "name , " + mapLazada.get("short_description") +":" + "short_description , " + mapLazada.get("description") + ":" + "\"description\" , "+mapLazada.get("video")+ "\"video\""+"}");
		json_main.put("Basic Attributes", json);
		json =new String("{"+mapLazada.get("brand")+":"+"\"brand\" , "+mapLazada.get("model") + "\"model\" ,"+mapLazada.get("color_family")+":"+"\"color_family\" , "+mapLazada.get("Hazmat") + "\"Hazmat\" ,"+mapLazada.get("style") + "\"style\" ,"+mapLazada.get("type_digital") + "\type_digital\" ,"+mapLazada.get("") + "\"style\" ,"+"}");
		json  = new String("{"+"\"\""+mapLazada.get("")+"\"\""+mapLazada.get("")+"\"\""+mapLazada.get("")+"\"\""+mapLazada.get("")+"}");
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
