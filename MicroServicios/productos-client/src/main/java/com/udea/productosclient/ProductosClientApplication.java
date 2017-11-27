package com.udea.productosclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false)
@EnableHystrix  //Activar circuit breaker
@EnableCircuitBreaker   //Activar circuit breaker
@RestController
@ComponentScan(basePackages = { "com.udea.productosclient" })
public class ProductosClientApplication {

    private static final String SERVICE_URL = "http://localhost:5555";

    public static void main(String[] args) {
        SpringApplication.run(ProductosClientApplication.class, args);
    }
    
    @LoadBalanced
    @Bean
    public static RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
    @Bean
    public static ProductoService productoService(){
        return new ProductoService(SERVICE_URL);
    }
    
    @Bean
    public ProductoController productoController(){
        return new ProductoController();
    }
}
