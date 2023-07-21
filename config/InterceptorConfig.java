package Asm_ps20667.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import Asm_ps20667.interception.LoggerInterceptor;
import Asm_ps20667.interception.SecurityInterceptor;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	LoggerInterceptor loggerInterceptor;
	
	@Autowired
	SecurityInterceptor auth;
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loggerInterceptor).addPathPatterns("/*", "/**");
		
		
		registry.addInterceptor(auth)
		.addPathPatterns("/admin/**", "/home/myorder" , "/home/profile" ,"/home/myOrderDetail","/home/change-password")
		.excludePathPatterns("");
	}
	
	
}
