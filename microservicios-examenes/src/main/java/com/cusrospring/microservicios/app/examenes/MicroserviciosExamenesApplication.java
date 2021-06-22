package com.cusrospring.microservicios.app.examenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"com.cursopring.microservicios.cammons.examenes"})
public class MicroserviciosExamenesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviciosExamenesApplication.class, args);
    }

}
