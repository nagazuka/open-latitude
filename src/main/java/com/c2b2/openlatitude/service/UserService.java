/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b2.openlatitude.service;

import com.c2b2.openlatitude.entity.LatitudeUser;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author shanny
 */
@Path("users")
public class UserService extends AbstractService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserService
     */
    public UserService() {
    }

    /**
     * Retrieves representation of an instance of com.c2b2.openlatitude.service.UserService
     * @return an instance of com.c2b2.openlatitude.entity.LatitudeUser
     */
    @GET
    @Produces("application/json")
    public List<LatitudeUser> findAll() {
        List keys = getCache().getKeys();
        
        List<LatitudeUser> users = new ArrayList<LatitudeUser>(keys.size());
        for (Object key: keys) {
            if (key instanceof String) {
                LatitudeUser u = new LatitudeUser().withUserName((String)key);                
                users.add(u);
            } else {
                throw new IllegalStateException("Cache keys not of type String, type = " + key.getClass());
            }
        }
        
        return users;
    }

}
