package com.sarvah.config;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.sarvah.dao.ProductDAO;
import com.sarvah.dao.ProductInterface;

@Configuration        
@ComponentScan("com.sarvah")
@ImportResource({"classpath:Spring-Datasource.xml"})
public class HelloConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloConfig.class);
	// autowire the DataSource bean declared in Spring-Datasource.xml
    @Autowired 
    DataSource dataSource;
	
    @Bean(name="productDAO")
	public ProductInterface returnProductDAO()
	{
    	if(dataSource == null)
    	{
    			logger.info("Datasource is returning null!");
    	}
		return new ProductDAO();
	}
    
    
    
   
}
