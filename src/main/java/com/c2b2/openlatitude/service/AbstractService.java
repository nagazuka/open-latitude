package com.c2b2.openlatitude.service;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

public class AbstractService {
    
        private final Cache cache = CacheManager.create().getCache("locationCache");

        protected Cache getCache() {
            return cache;
        }
    
}
