package com.bth.softboarder.resources;

import com.bth.softboarder.db.OrderDAO;
import com.bth.softboarder.entities.Orders;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Preconditions;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by DIVYA on 01-09-2016.
 */

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("orders")

public class OrderResource {
    private OrderDAO orderDao;

    public OrderResource(OrderDAO orderDao) {
        Preconditions.checkNotNull(orderDao);
        this.orderDao = orderDao;
    }

    @GET
    @Path("/all/")
    public List<Orders> getBy() {
        return orderDao.getBy();
    }

    @POST
    @Path("/{uname}")
    public Orders getBy(@PathParam("uname") String emp_name) {
        return orderDao.getBy(emp_name);
    }

    @GET
    @Path("/{id}")
    public Orders getBy(@PathParam("id") int id) {
        return orderDao.getBy(id);
    }

    @POST
    @Timed
    public void insertOrders (Orders orders){
        orderDao.insertOrders(orders);
    }



}