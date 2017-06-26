/**
 *  Developed by Sagar Gupta
 */
package com.scalebazaar.placeordernormalizationmoduler;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * @author ADMINIBM
 *
 */
public class OrderScemaScalelabs {
	private String itemSKU;
	private String productID;
	private String productName;
	private String productCategory;
	private String itemTypeKeyword;
	private String shippingTemplate;
	private URL largeImageUrl ;
	private ArrayList<String> itemVariantSKU;
	private String BrandID;
	private double webPrice;
	private double mrp;
	private URL smallImageUrl;
	private Map<String , String> variants;
	private String DiliveryTime;
	private double productWeight;
	private String dimensions;
	private ArrayList<String> packageContent;
	private String Barcode;
	private double sepcialPrice;
	private Date startData;
	private Date endDate;
	private int maxOrderQuantity;
	private String warrantyType;
	private String warrantyPeriod;
	private String sellerID;
	
	public String getItemSKU() {
		return itemSKU;
	}
	public void setItemSKU(String itemSKU) {
		this.itemSKU = itemSKU;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getItemTypeKeyword() {
		return itemTypeKeyword;
	}
	public void setItemTypeKeyword(String itemTypeKeyword) {
		this.itemTypeKeyword = itemTypeKeyword;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getShippingTemplate() {
		return shippingTemplate;
	}
	public void setShippingTemplate(String shippingTemplate) {
		this.shippingTemplate = shippingTemplate;
	}
	public URL getLargeImageUrl() {
		return largeImageUrl;
	}
	public void setLargeImageUrl(URL largeImageUrl) {
		this.largeImageUrl = largeImageUrl;
	}
	public ArrayList<String> getItemVariantSKU() {
		return itemVariantSKU;
	}
	public void setItemVariantSKU(ArrayList<String> itemVariantSKU) {
		this.itemVariantSKU = itemVariantSKU;
	}
	public String getBrandID() {
		return BrandID;
	}
	public void setBrandID(String brandID) {
		BrandID = brandID;
	}
	public double getWebPrice() {
		return webPrice;
	}
	public void setWebPrice(double webPrice) {
		this.webPrice = webPrice;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	public Map<String , String> getVariants() {
		return variants;
	}
	public void setVariants(Map<String , String> variants) {
		this.variants = variants;
	}
	public URL getSmallImageUrl() {
		return smallImageUrl;
	}
	public void setSmallImageUrl(URL smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
	public String getDiliveryTime() {
		return DiliveryTime;
	}
	public void setDiliveryTime(String diliveryTime) {
		DiliveryTime = diliveryTime;
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	public ArrayList<String> getPackageContent() {
		return packageContent;
	}
	public void setPackageContent(ArrayList<String> packageContent) {
		this.packageContent = packageContent;
	}
	public double getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(double productWeight) {
		this.productWeight = productWeight;
	}
	public String getBarcode() {
		return Barcode;
	}
	public void setBarcode(String barcode) {
		Barcode = barcode;
	}
	public Date getStartData() {
		return startData;
	}
	public void setStartData(Date startData) {
		this.startData = startData;
	}
	public int getMaxOrderQuantity() {
		return maxOrderQuantity;
	}
	public void setMaxOrderQuantity(int maxOrderQuantity) {
		this.maxOrderQuantity = maxOrderQuantity;
	}
	public String getWarrantyType() {
		return warrantyType;
	}
	public void setWarrantyType(String warrantyType) {
		this.warrantyType = warrantyType;
	}
	public String getWarrantyPeriod() {
		return warrantyPeriod;
	}
	public void setWarrantyPeriod(String warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}
	public String getSellerID() {
		return sellerID;
	}
	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public double getSepcialPrice() {
		return sepcialPrice;
	}
	public void setSepcialPrice(double sepcialPrice) {
		this.sepcialPrice = sepcialPrice;
	}
}
