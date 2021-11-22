package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entidad.Videojuegos;

//Aqui arrancamos la aplicacion
@SpringBootApplication
public class SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

}
