package com.c2b2.openlatitude.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author shanny
 */
public class LatitudeUser implements Serializable {
    
    private String userName;
    
    private Set<LatitudeUser> friends = new HashSet<LatitudeUser>(0);

    public Set<LatitudeUser> getFriends() {
        return friends;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public LatitudeUser withUserName(String userName) {
        setUserName(userName);
        return this;
    }
   
}
