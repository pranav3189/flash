package com.bookstore.controller;


import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan("com.bookstore")
public class AppConfig  implements WebMvcConfigurer,ServletContextAware {
    
 
    
    @Bean
    public RestTemplate restTemplate() {
    	RestTemplate restTemplate=new RestTemplate();
    	ObjectMapper objectMapper=new ObjectMapper();
    	objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    	MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
    	messageConverter.setPrettyPrint(true);
    	messageConverter.setObjectMapper(objectMapper);
    	restTemplate.getMessageConverters().removeIf(m -> m.getClass().getName().equals(MappingJackson2HttpMessageConverter.class.getName()));
    	restTemplate.getMessageConverters().add(messageConverter);
        return restTemplate;
    }
    
  
 @Override
    public void addViewControllers(ViewControllerRegistry registry) {
   
  }

    @Override
    public void setServletContext(ServletContext servletContext) {
        
        //Set Environment path and startup configurations
    }

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCorsMappings(CorsRegistry arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFormatters(FormatterRegistry arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInterceptors(InterceptorRegistry arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry arg0) {
		//  Auto-generated method stub
		
	}

	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
    
}
