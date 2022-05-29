package com.example.goodsprovider;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient //能够被注册中心扫描到
@MapperScan("com.example.goodsprovider.dao")
@EnableHystrix
public class GoodsProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsProviderApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setName("HystrixMetricsStreamServlet");
        registrationBean.setLoadOnStartup(1);//配置启动优先级，控制启动顺序
        registrationBean.addUrlMappings("/hystrix.stream");
        return registrationBean;
    }
}
