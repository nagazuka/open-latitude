/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b2.openlatitude.service;

import com.c2b2.openlatitude.entity.Location;
import java.util.Date;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author shanny
 */
@Path("location")
public class LocationService {
    private static final Logger LOG = Logger.getLogger(LocationService.class.getName());

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LocationResource
     */
    public LocationService() {
    }

    /**
     * Retrieves representation of an instance of com.c2b2.openlatitude.LocationResource
     * @return an instance of com.c2b2.openlatitude.location
     */
    @GET
    @Produces("application/json")
    public Location get(String userName) {
        //TODO return proper representation object
        LOG.info("WOT");
        throw new UnsupportedOperationException();
    }

    @POST
    @Path("update")
    @Consumes("application/json")
    public void update(Location location) {
        location.setLastUpdated(new Date());        
        LOG.info("Updated location: " + location);
    }
}
