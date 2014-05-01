package com.woniper.hibernate.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.PathExtensionContentNegotiationStrategy;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.woniper.hibernate"}, excludeFilters=@ComponentScan.Filter(Configuration.class))
public class WebAppConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/").addResourceLocations("/resources/**");
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    // ViewResolver
    @Bean
    public ContentNegotiatingViewResolver viewResolver() {
    	ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
    	resolver.setOrder(1);
    	ContentNegotiationManager cnm = new ContentNegotiationManager(
    											new PathExtensionContentNegotiationStrategy(getMediaType()));
    	
    	resolver.setDefaultViews(getViewList());
    	resolver.setContentNegotiationManager(cnm);
    	
    	return resolver;
    }
    
    // viewResolver MediaType
    private Map<String, MediaType> getMediaType() {
    	Map<String, MediaType> map = new HashMap<String, MediaType>();
    	map.put("json", MediaType.APPLICATION_JSON);
    	map.put("xml", MediaType.APPLICATION_XML);
    	return map;
    }
    
    // viewResolver ViewList
    private List<View> getViewList() {
    	List<View> list = new ArrayList<View>();
    	list.add(new MappingJackson2JsonView());
    	// 추후에 xml도 추가 해야함 
    	return list;
    }
}
