/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalebazaar.ordernormalizationmodule;

/**
 *
 * @author abmukh
 */
public class OrderItem {
    String itemname,itemid,orderid,sellerid,marketplaceid,sku,value,quantity,itemstatus,currencycode,orderdump;

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getMarketplaceid() {
        return marketplaceid;
    }

    public void setMarketplaceid(String marketplaceid) {
        this.marketplaceid = marketplaceid;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getItemstatus() {
        return itemstatus;
    }

    public void setItemstatus(String itemstatus) {
        this.itemstatus = itemstatus;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public String getOrderdump() {
        return orderdump;
    }

    public void setOrderdump(String orderdump) {
        this.orderdump = orderdump;
    }
}
