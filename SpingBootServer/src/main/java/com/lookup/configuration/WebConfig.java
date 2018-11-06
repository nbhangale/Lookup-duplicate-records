package com.lookup.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * Description: Added CORS to allow client requests
	 * 				Allowed all 
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		log.info("addCorsMappings - Start");
		registry.addMapping("/**");
		log.info("addCorsMappings - End");
	}
}