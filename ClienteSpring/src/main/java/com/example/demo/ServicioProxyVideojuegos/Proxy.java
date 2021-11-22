package com.example.demo.ServicioProxyVideojuegos;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.clienteEntidad.Videojuegos;


@Service
public class Proxy {
	
	public static final String  URL = "http://localhost:2018/videojuegos/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * recibe un parametro id para comunicarse con el servidor con el verbo get 
	 * @param id
	 * @return
	 */
	public Videojuegos getVideojuego(int id) {
		try {
			ResponseEntity<Videojuegos> re = restTemplate.getForEntity(URL+ + id, Videojuegos.class);
			HttpStatus hs= re.getStatusCode();
			if(hs == HttpStatus.OK) {				
				return re.getBody();
			}else {
				System.out.println("Respuesta no contemplada");
				return null;
			}
		}catch (HttpClientErrorException e) {
			System.out.println("obtener -> El videojuego con este id " + id + " no existe");
		    System.out.println("obtener -> Codigo de respuesta: " + e.getStatusCode());
		    return null;
		}
	}
	/**
	 * Se le introduce los parametros de un videojuego para comunicarse con el servidor con el verbo post y añadirlo
	 * @param v
	 * @return
	 */
	public Videojuegos newVideojuego(Videojuegos v) {
		try {
			ResponseEntity<Videojuegos> re = restTemplate.postForEntity(URL, v, Videojuegos.class);
			System.out.println("alta -> Codigo de respuesta " + re.getStatusCode());
			return re.getBody();
		} catch (HttpClientErrorException e) {
			System.out.println("alta -> El videojuego no se ha creado, id: " + v);
		    System.out.println("alta -> Codigo de respuesta: " + e.getStatusCode());
		    return null;
		}
	}
	/**
	 * Recibe un videojuego para comnicarse con el servidor con el verbo put y añadirlo
	 * @param v
	 * @return
	 */
	public boolean updateVideojuegos(Videojuegos v) {
		try {
			restTemplate.put(URL + v.getId(), v, Videojuegos.class);
			return true;
		} catch (HttpClientErrorException e) {
			System.out.println("modificar -> El videojuego NO se ha modificado, id: " + v.getId());
		    System.out.println("modificar -> Codigo de respuesta: " + e.getStatusCode());
		    return false;
		}
	}
	
	/**
	 * Reecibe un parametro id, para comunicarse con el servidor con el verbo delete y borrar el juego
	 * @param id
	 * @return
	 */
	public boolean deleteVideojuego (int id) {
		try {
			restTemplate.delete(URL + id);
			return true;
		} catch (HttpClientErrorException e) {
			System.out.println("borrar -> El videojuego NO se ha borrado, id: " + id);
		    System.out.println("borrar -> Codigo de respuesta: " + e.getStatusCode());
		    return false;
		}
	}
	
	/**
	 * NO recibe nada solo se comunica con el servidor con el verbo get para listar los videojuegos
	 * @return
	 */
	public List<Videojuegos> list(){
		try {
			ResponseEntity<Videojuegos[]> response =
					  restTemplate.getForEntity(URL,Videojuegos[].class);
			Videojuegos[] arrayVideojuegos = response.getBody();
			return Arrays.asList(arrayVideojuegos);
		} catch (HttpClientErrorException e) {
			System.out.println("listar -> Error al obtener la lista de Videojuegos");
		    System.out.println("listar -> Codigo de respuesta: " + e.getStatusCode());
		    return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
