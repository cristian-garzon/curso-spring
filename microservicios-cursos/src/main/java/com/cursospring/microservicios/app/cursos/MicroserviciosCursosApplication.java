package com.cursospring.microservicios.app.cursos;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.cursospring.microservicios.cammons.students.entity",
            "com.cursospring.microservicios.app.cursos.entity",
            "com.cursopring.microservicios.cammons.examenes"})
public class MicroserviciosCursosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviciosCursosApplication.class, args);
    }


}
