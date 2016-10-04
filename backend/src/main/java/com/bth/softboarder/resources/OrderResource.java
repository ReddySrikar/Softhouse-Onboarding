package com.bth.softboarder.resources;

import com.bth.softboarder.db.InventoryDAO;
import com.bth.softboarder.db.OrderDAO;
import com.bth.softboarder.entities.Orders;
import com.bth.softboarder.entities.Inventorys;
import com.bth.softboarder.resources.InventoryResource;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Preconditions;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Srikar on 01-09-2016.
 */

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("orders")

public class OrderResource {
    private OrderDAO orderDao;
    private InventoryDAO inventoryDao;

    public OrderResource(OrderDAO orderDao, InventoryDAO inventoryDao) {
        Preconditions.checkNotNull(orderDao);
        this.orderDao = orderDao;
        this.inventoryDao = inventoryDao;
    }


    @GET
    @Path("/all/")
    public List<Orders> getBy() {
        return orderDao.getBy();
    }

    //@POST
    //@Path("/{uname}")
    //public Orders getBy(@PathParam("uname") String emp_name) {
    // return orderDao.getBy(emp_name);
    //}

    @GET
    @Path("/select/{id}")
    public Orders getBy(@PathParam("id") int id) {
        return orderDao.getBy(id);
    }


    @POST
    @Timed
    public void saveOrder(Orders orders) {
        if (orders != null) {
            orderDao.insertOrder(orders);
            throw new WebApplicationException(Response.Status.OK);
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @PUT
    @Path("/update/{id}")
    public void update(@PathParam("id") int id, Orders orders) {
        orderDao.updateOrder(id);
        inventoryDao.updateInventory(orders);
        throw new WebApplicationException(Response.Status.OK);
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteOrder(@PathParam("id") int id) {
        orderDao.deleteOrderById(id);
        throw new WebApplicationException(Response.Status.OK);

    }


}