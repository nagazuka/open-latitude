package com.c2b2.openlatitude.service;

import com.c2b2.openlatitude.entity.Location;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import net.sf.ehcache.Element;

@Path("location")
public class LocationService extends AbstractService {

    private static final Logger LOG = Logger.getLogger(LocationService.class.getName());

    @Context
    private UriInfo context;

    public LocationService() {
    }

    @GET
    @Path("{userName}")
    @Produces({"application/xml", "application/json"})
    public Location get(@PathParam("userName") String userName) {
        Element res = getCache().get(userName);

        Location loc = null;
        if (res != null) {
            loc = (Location) res.getObjectValue();
        } else {
            throw new NotFoundException();
        }
        return loc;
    }

    @GET
    @Path("all")
    @Produces("application/json")
    public List<Location> findAll() {
        List<Location> users = Collections.emptyList();

        List keys = getCache().getKeys();
        if (keys != null && keys.size() > 0) {
            Map<Object, Element> allElements = getCache().getAll(keys);
            users = getValues(keys, allElements);
        }

        return users;
    }

    @POST
    @Path("update")
    @Consumes("application/json")
    public void update(Location location) {
        if (location != null) {
            location.setLastUpdated(new Date());
            LOG.info("Updated location: " + location);

            String userName = location.getUserName();
            Element el = new Element(userName, location);
            getCache().put(el);
        }

        LOG.info("Keys: " + getCache().getKeys());
    }

    private List<Location> getValues(List keys, Map<Object, Element> elements) throws IllegalStateException {
        List<Location> users = new ArrayList<Location>(keys.size());
        for (Object key : keys) {
            Element el = elements.get(key);            
            if (el != null) {
                Object o = el.getObjectValue();
                if (o instanceof Location) {
                    Location u = (Location) o;
                    users.add(u);
                } else {
                    throw new IllegalStateException("Object retrieved from Cache is not of type LatitudeUser: " + o.getClass());
                }
            }
        }
        return users;
    }
}
