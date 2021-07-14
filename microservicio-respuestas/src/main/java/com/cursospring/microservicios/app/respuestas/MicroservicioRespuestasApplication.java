package com.cursospring.microservicios.app.respuestas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"com.cursospring.microservicios.app.respuestas.entity",
    "com.cursopring.microservicios.cammons.examenes"})
public class MicroservicioRespuestasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioRespuestasApplication.class, args);
    }

}
