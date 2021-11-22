package com.example.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.ServicioProxyVideojuegos.Proxy;
import com.example.demo.clienteEntidad.Videojuegos;

@SpringBootApplication
public class ClienteSpringApplication implements CommandLineRunner {
	
	private boolean repetir = true;
	Videojuegos v = new Videojuegos();

	@Autowired
	private Proxy spv;
	
	@Autowired
	private ApplicationContext context;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	

	public static void main(String[] args) {
		System.out.println("Cliente --> Cargando contexto de spring");
		SpringApplication.run(ClienteSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (repetir==true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Elija una de las siguientes opciones :");
		System.out.println("Dar de alta un videojuego ---> pulsar el 1");
		System.out.println("Dar de baja un videojuego por ID ---> pulsar el 2");
		System.out.println("Modificar un videojuego por ID ---> pulsar el 3");
		System.out.println("Obtener un videojuego por ID ---> pulsar el 4");
		System.out.println("Listar todos los videojuegos ---> pulsar el 5");
		System.out.println("Salir ---> pulsar el 6");


		int opcion;
		opcion = sc.nextInt();
		
		
		switch(opcion) {
		
		case 1 : 
			System.out.println("Has elegido dar de alta un videojego");
			System.out.println("Introduce el nombre del juego :");
			String nombre = sc.next();
			System.out.println("Introduce la compañia");
			String compania = sc.next();
			System.out.println("Introduce la nota que le das al juego");
			Double nota = sc.nextDouble();
			v.setNombre(nombre);
			v.setCompania(compania);
			v.setNota(nota);
			spv.newVideojuego(v);
			System.out.println("El videojuego que se ha creado es "+ v);
			break;
		case 2 :
			System.out.println("Has elegido borrar un videojuego ");
			System.out.println("Introduce el ID del juego que quieres eliminar");
			int borrar = sc.nextInt();
			
			if(spv.deleteVideojuego(borrar)==true) {
				System.out.println("El videojuego se ha borrado correctamente" );
			}else {
				System.out.println("El videojuego no se ha borrado");
			}
			break;
		case 3 :
			System.out.println("Has elegido modificar un videojuego por ID");
			System.out.println("Introduce el ID del videojuego a modificar");
			int id = sc.nextInt();
			System.out.println("Introduce el nombre del juego :");
			String nombreU = sc.next();
			System.out.println("Introduce la compañia");
			String companiaU = sc.next();
			System.out.println("Introduce la nota que le das al juego");
			Double notaU = sc.nextDouble();
			v.setId(id);
			v.setNombre(nombreU);
			v.setCompania(companiaU);
			v.setNota(notaU);
			spv.updateVideojuegos(v);
			System.out.println("El videojuego que se ha modificado es "+ v);
			break;
		case 4 :	
			System.out.println("has elegido obtener un videojuego por ID");
			System.out.println("Introduce el ID");
			int obtener = sc.nextInt();
			v=spv.getVideojuego(obtener);
			System.out.println("El videojuego es " + v);
			break;
		case 5 :
			System.out.println("Has elegido obtener la lista de videojuegos ");
			List<Videojuegos> lista =spv.list();
			System.out.println(lista);
			break;
		case 6 :
			System.out.println("Has elegido salir ");
			System.out.println("Hasta luego lucaar!");
			repetir=false;
			break;
		}
	}
	}
}
