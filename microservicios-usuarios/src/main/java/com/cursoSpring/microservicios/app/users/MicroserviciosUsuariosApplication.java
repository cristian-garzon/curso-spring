package com.cursoSpring.microservicios.app.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.cursospring.microservicios.cammons.students.entity"})
public class MicroserviciosUsuariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviciosUsuariosApplication.class, args);
    }

}