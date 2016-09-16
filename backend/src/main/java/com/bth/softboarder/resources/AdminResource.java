package com.bth.softboarder.resources;

import com.bth.softboarder.db.AdminDAO;
import com.bth.softboarder.entities.Admins;
import com.bth.softboarder.entities.Users;
import com.google.common.base.Preconditions;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


/**
 * Created by DIVYA on 16-09-2016.
 */

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("admin")
public class AdminResource {
    private AdminDAO adminDao;

    public AdminResource(AdminDAO adminDao) {
        Preconditions.checkNotNull(adminDao);
        this.adminDao = adminDao;
    }

    @GET
    @Path("/all/")
    public List<Admins> getBy() {
        return adminDao.getBy();
    }

    @GET
    @Path("/{username}/{password}")
    public Response getBy(@PathParam("username") String username, @PathParam("password") String password)
    {

        Admins admins = adminDao.getBy(username,password);
        if(admins != null) {
            String result = "login successful";
            return Response.status(200)
                    .entity(result)
                    .build();
        }

        else {
            String result = "login failed";
            return Response.status(200)
                    .entity(result)
                    .build();
        }
        //return null;
    }

}
