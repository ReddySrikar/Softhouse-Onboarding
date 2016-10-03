package com.bth.softboarder.resources;

import com.bth.softboarder.db.InventoryDAO;
import com.bth.softboarder.entities.Inventorys;
import com.bth.softboarder.entities.Users;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Preconditions;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Srikar on 16-09-2016.
 */

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("inventory")
public class InventoryResource {
    private InventoryDAO inventoryDao;

    public InventoryResource(InventoryDAO inventoryDao) {
        Preconditions.checkNotNull(inventoryDao);
        this.inventoryDao = inventoryDao;
    }

    @GET
    @Path("/all/")
    public List<Inventorys> getBy() {
        return inventoryDao.getBy();
    }

    @POST
    @Timed
    public void saveInventory(Inventorys inventorys) {
        if (inventorys != null) {
            inventoryDao.insertInventory(inventorys);
            throw new WebApplicationException(Response.Status.OK);

        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

    }
}
