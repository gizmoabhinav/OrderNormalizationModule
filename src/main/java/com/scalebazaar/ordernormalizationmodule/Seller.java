/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalebazaar.ordernormalizationmodule;
import org.json.JSONObject;

/**
 *
 * @author abmukh
 */
public class Seller {
    private int id;
    private String name;
    private String properties;
    private String[] marketPlaces;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String[] getMarketPlaces() {
        return marketPlaces;
    }

    public void setMarketPlaces(String[] marketPlaces) {
        this.marketPlaces = marketPlaces;
    }
}
