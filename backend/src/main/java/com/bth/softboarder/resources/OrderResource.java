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
    public List<Orders> getBy() { return orderDao.getBy(); }

    @GET
    @Path("/status/{flag}")
    public List<Orders> getStatus(@PathParam("flag") int flag) { return orderDao.getStatus(flag); }

    //@POST
    //@Path("/{uname}")
    //public Orders getBy(@PathParam("uname") String emp_name) {
    // return orderDao.getBy(emp_name);
    //}

    @GET
    @Path("/select/{emp_id}")
    public List<Orders> getBy(@PathParam("emp_id") int emp_id) {
        return orderDao.getBy(emp_id);
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
    @Path("/update/{emp_id}")
    public void update(@PathParam("emp_id") int emp_id, Orders orders) {
        orderDao.updateOrder(emp_id);
        inventoryDao.updateInventory(orders);
        throw new WebApplicationException(Response.Status.OK);
    }

    @PUT
    @Path("/delete/{emp_id}")
    public void deleteOrder(@PathParam("emp_id") int emp_id) {
        orderDao.deleteOrderById(emp_id);
        throw new WebApplicationException(Response.Status.OK);

    }
}