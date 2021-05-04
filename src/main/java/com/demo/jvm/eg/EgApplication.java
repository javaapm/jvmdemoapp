package com.demo.jvm.eg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@ComponentScan({"com.demo.jvm","com.ibc"})
@SpringBootApplication
public class EgApplication {

	public static void main(String[] args) {
		SpringApplication.run(EgApplication.class, args);
	}
	
	 public void addResourceHandlers(ResourceHandlerRegistry registry){ 
	            registry.addResourceHandler("/**")
	                 .addResourceLocations("classpath:/static/");
	    }

}
