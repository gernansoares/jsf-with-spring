package com.jsfwithspring.config;

import org.jboss.weld.environment.servlet.EnhancedListener;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import com.sun.faces.config.FacesInitializer;

public class JsfInitializer implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext context) throws ServletException {
        EnhancedListener cdiInitializer = new EnhancedListener();
        cdiInitializer.onStartup(null, context);

        ServletContainerInitializer facesInitializer = new FacesInitializer();
        facesInitializer.onStartup(null, context);
    }

}