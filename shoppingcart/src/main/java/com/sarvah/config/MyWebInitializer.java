/**
 * 
 */
package com.sarvah.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @author shivu s
 *
 */
public class MyWebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		
		// Create the 'root' Spring application context
	      AnnotationConfigWebApplicationContext rootContext =
	        new AnnotationConfigWebApplicationContext();
	      rootContext.register(HelloConfig.class);

	      // Manage the lifecycle of the root application context
	      container.addListener(new ContextLoaderListener(rootContext));


		
	}

}
