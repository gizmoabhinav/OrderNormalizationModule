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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

@Path("/OrdersAPI")
public class RestEndpoint {

	@GET
        @Path("/GetOrders")
        @Produces(MediaType.APPLICATION_JSON)
	public Response getMsg(
                @QueryParam("sellerid") String sellerid,
                @QueryParam("marketplaceid") String msarketplaceid,
                @QueryParam("lasttimestamp") String lasttiemstamp) {
                
                Order order = new Order();
                order.setSellerid(sellerid);
                order.setMarketplaceid(msarketplaceid);

		return Response.status(200).entity(order).build();

	}

}
