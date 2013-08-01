package com.c2b2.openlatitude;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import net.sf.ehcache.CacheManager;

@WebListener()
public class StartupListener implements ServletContextListener {

    private static CacheManager cacheManager = null;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        cacheManager = CacheManager.create();
        cacheManager.addCache("locationCache");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (cacheManager != null) {
            cacheManager.shutdown();
        }
        
    }
 
}
