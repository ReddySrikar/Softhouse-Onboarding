package com.bth.softboarder.resources;


import com.bth.softboarder.db.UserDAO;
import com.bth.softboarder.entities.Users;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Preconditions;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Srikar on 31-08-2016.
 */


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("users")
public class UserResource {
    private UserDAO userDao;

    public UserResource(UserDAO userDao) {
        Preconditions.checkNotNull(userDao);
        this.userDao = userDao;
    }

    @GET
    @Path("/all/")
    public Users getBy() {
        return userDao.getBy();
    }

    @POST
    @Path("/name/{uname}")
    public Users getBy(@PathParam("uname") String username) {
        return userDao.getBy(username);
    }

    @GET
    @Path("/{id}")
    public Users getBy(@PathParam("id") int id) {
        return userDao.getBy(id);
    }

    @POST
    @Timed
    public void insertUsers(Users users) {
        userDao.insertUser(users);
    }

}
