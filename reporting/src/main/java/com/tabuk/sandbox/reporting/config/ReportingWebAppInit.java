package com.tabuk.sandbox.reporting.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ReportingWebAppInit implements WebApplicationInitializer {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		logger.info("Initializing...");
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		/**
		 * Add Context Listener
		 */
		appContext.setConfigLocations(new String[]{"classpath:spring-reporting-*.xml"});
		servletContext.addListener(new ContextLoaderListener(appContext));

		/**
		 * Servlet config
		 */
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("spring", new DispatcherServlet(appContext));
		dispatcher.setInitParameter("contextConfigLocation", "/WEB-INF/spring-servlet.xml");
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		logger.info("done");
	}

}
