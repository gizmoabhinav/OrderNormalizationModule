/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalebazaar.ordernormalizationmodule;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author abmukh
 */
public class Utils {

    public static JSONObject addSystemProperties(JSONObject jobj) {
        try {
            jobj.put("currenttimestampYYYYMMDDTHHMMSSZ", getCurrentTime("yyyy-MM-dd'T'HH:mm:ssZ"));
            jobj.put("currenttimestampDDMMYYYYHHMM", getCurrentTime("ddMMyyyyHHmm"));
        } catch (JSONException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jobj;
    }

    public static String getCurrentTime(String format) throws UnsupportedEncodingException {
        return URLEncoder.encode(new SimpleDateFormat(format).format(new Date()), "UTF-8");
    }

    public static void main(String[] args) throws Exception {
        //System.out.println(getCurrentTime("ddMMyyyyHHmm"));
    }

    public static String HMACSHA256encode(String key, String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        return Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes("UTF-8")));
    }
}
