package com.bth.softboarder.resources;

import com.bth.softboarder.db.OrderDAO;
import com.bth.softboarder.entities.Orders;
import com.bth.softboarder.entities.Users;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Preconditions;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

    //@POST
    //@Path("/{uname}")
    //public Orders getBy(@PathParam("uname") String emp_name) {
    // return orderDao.getBy(emp_name);
    //}

    @GET
    @Path("/{id}")
    public Orders getBy(@PathParam("id") int id) {
        return orderDao.getBy(id);
    }


    //@GET
    //@Path("/{emp_id}/{emp_name}/{model}")
    //public Orders getBy(@PathParam("emp_id") String emp_id, @PathParam("emp_name") String emp_name, @PathParam("model") String model) {
    // orderDao.getBy(emp_id,emp_name,model);
    //  Orders orders = orderDao.getBy(emp_id,emp_name,model);
    //return orders;
    //}


    //@POST
    //@Path("/{emp_id}/{emp_name}/{model}")
    //public void insertOrders(Orders orders) { orderDao.insertOrder(orders); }

    /* @Path("/{emp_id}/{emp_name}/{model}")
    public List<Orders> insertOrders(@PathParam("emp_id") String emp_id, @PathParam("emp_name") String emp_name, @PathParam("model") String model) {
        orderDao.insertOrder(emp_id,emp_name,model);
    }
    //public void insertOrders(Orders orders) { orderDao.insertOrder(orders); }
*/

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

}