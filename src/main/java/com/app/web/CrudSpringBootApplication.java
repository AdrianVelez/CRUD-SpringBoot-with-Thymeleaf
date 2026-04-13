package com.app.web;

import com.app.web.entity.Estudiante;
import com.app.web.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudSpringBootApplication implements CommandLineRunner {
 @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public void run(String... args) throws Exception {

        /*Estudiante estudiante1 = new Estudiante("Adrian", "Velez", "adrianvelez@gmail.com");
        estudianteRepository.save(estudiante1);

        Estudiante estudiante2 = new Estudiante("Andre", "Carrillo", "carrillo20@gmail.com");
        estudianteRepository.save(estudiante2);*/
    }


    public static void main(String[] args) {
        SpringApplication.run(CrudSpringBootApplication.class, args);
    }

}
