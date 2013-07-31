/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b2.openlatitude.service;

import com.c2b2.openlatitude.entity.LatitudeUser;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author shanny
 */
@Stateless
@Path("user")
public class LatitudeUserService extends AbstractFacade<LatitudeUser> {
    @PersistenceContext(unitName = "com.c2b2_openlatitude_persistenceunit")
    private EntityManager em;

    public LatitudeUserService() {
        super(LatitudeUser.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(LatitudeUser entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(LatitudeUser entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public LatitudeUser find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<LatitudeUser> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("{id}/friends")
    @Produces({"application/xml", "application/json"})
    public Set<LatitudeUser> friends(@PathParam("id") Long id) {
        LatitudeUser u = super.find(id);
        return u.getFriends();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<LatitudeUser> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
