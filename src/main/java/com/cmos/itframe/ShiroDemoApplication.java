package com.cmos.itframe;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@MapperScan("com.cmos.itframe.dao")
public class ShiroDemoApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(ShiroDemoApplication.class,args);
    }
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
