package com.bth.softboarder.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Srikar on 29-08-2016.
 */

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class DemoResource {
    @GET
    public String getWords(){
        return "Hello World," +
                "Welcome... " +
                "To the first dropwizard Program";
    }
}
