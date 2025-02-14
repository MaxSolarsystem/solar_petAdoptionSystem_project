package com.solar.petadoptionsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.solar.petadoptionsystem.system.**.mapper")
public class PetAdoptionSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetAdoptionSystemApplication.class, args);
    }

}
