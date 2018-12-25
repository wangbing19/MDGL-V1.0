package com.md.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.md.common.web.AccessInterCeptor;

/**
 * 在此配置类中实现spring mvc 资源对象的整合
 * 
 * @author ta
 */
@ComponentScan(value = "com.md", useDefaultFilters = false, includeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes = { Controller.class, ControllerAdvice.class}) })
@EnableWebMvc
@EnableAspectJAutoProxy //启用AOP配置
public class AppMvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/pages/", ".html");
	}

	/**
	 * 注册拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 构建拦截器对象
		AccessInterCeptor interceptor = new AccessInterCeptor();
		// 注册拦截器对象
		InterceptorRegistration addInterceptor = registry.addInterceptor(interceptor);
		// 配置要拦截的url
		addInterceptor.addPathPatterns("/user/doLogin.do");
	}

}
