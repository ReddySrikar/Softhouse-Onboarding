package com.bth.softboarder.resources;


import com.bth.softboarder.db.UserDAO;
import com.bth.softboarder.entities.Users;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Preconditions;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;




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
    public List<Users> getBy() {
        return userDao.getBy();
    }

    @GET
    @Path("/{username}/{password}")
    public Response getBy(@PathParam("username") String username, @PathParam("password") String password)
    {
        //String result = "login successful";
        //return Response.status(200)
          //      .entity(result)
            //    .build();


        /* if (Objects.equals(userDao.getBy(username, password), "")) return "Login Failed";
        else {
        return "Login Successful";
        } */

        Users users = userDao.getBy(username,password);
        if(users != null) {
            String result = "login successful";
            return Response.status(200)
                  .entity(result)
                .build();
        }

        else {
            //System.out.println(users);
           // return users;
            String result = "login failed";
            return Response.status(200)
                    .entity(result)
                    .build();
        }
        //return null;
    }

    //@POST
    //@Path("/name/{uname}")
    //public Users getBy(@PathParam("uname") String username) {
      //  return userDao.getBy(username);
    //}

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
