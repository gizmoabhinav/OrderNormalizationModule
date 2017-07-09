package com.scalebazaar.productscema;

public class ShippingService {
	private String Option;
	private String Cost;
	private String Priority;
	private String ShippingSurcharge;
	
	ShippingService(){
		this.Option = null;
		this.Cost = null;
		this.Priority = null;
		this.ShippingSurcharge = null;
	}
	
	public String getOption() {
		return Option;
	}
	public void setOption(String option) {
		Option = option;
	}
	public String getCost() {
		return Cost;
	}
	public void setCost(String cost) {
		Cost = cost;
	}
	public String getShippingSurcharge() {
		return ShippingSurcharge;
	}
	public void setShippingSurcharge(String shippingSurcharge) {
		ShippingSurcharge = shippingSurcharge;
	}

	public String getPriority() {
		return Priority;
	}

	public void setPriority(String priority) {
		Priority = priority;
	}
}
