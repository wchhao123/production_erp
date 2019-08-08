package com.team.config;

import com.team.converter.String2DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.team.controller")
public class SpringMvcConfig implements WebMvcConfigurer {

    @Autowired
    ConfigurableConversionService conversionService;

    @PostConstruct
    public void addConverter() {
        conversionService.addConverter(new String2DateConverter());
    }

    //格式转换
    @Bean
    @Primary
    public ConversionService conversionService() {
        return conversionService;
    }

    //静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pic/**")
                .addResourceLocations("/WEB-INF/image/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/WEB-INF/css/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/WEB-INF/js/");
    }


}
