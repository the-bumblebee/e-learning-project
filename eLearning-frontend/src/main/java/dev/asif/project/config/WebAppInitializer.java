package dev.asif.project.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { MyViewResolver.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// Is of interest to us
		return new String[] { "/" };
	}
	
	@Override
		protected void customizeRegistration(Dynamic registration) {
			registration.setMultipartConfig(new MultipartConfigElement("", 2097152, 4193304, 2097152));
		}

}
