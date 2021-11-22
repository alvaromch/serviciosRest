package com.example.demo.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Videojuegos;
import com.example.demo.persistencia.DaoVideojuego;

@RestController
public class Controlador {
	@Autowired
	private DaoVideojuego daovideojuego;
	
	/**
	 * con el verbo get se mapea la lista y se devuelve un videojuego 
	 * usando el metodo getVideojuego(); en formato json
	 * @param id
	 * @return
	 */
	@GetMapping(path="videojuegos/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuegos> getVideojuego(@PathVariable("id")int id){
		System.out.println("Buscando videojuego por id " + id);
		Videojuegos v = daovideojuego.getVideojuego(id);
		if(v!= null) {
			return new ResponseEntity<Videojuegos>(v,HttpStatus.OK);
		}else 
			return new ResponseEntity<Videojuegos>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Este post mapea por el path videojuego y usando el metodo newVideojuego();
	 * se añade el videojuego en formato json 
	 * @param v
	 * @return
	 */
	@PostMapping(path="videojuegos", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuegos> altaVideojuego(@RequestBody Videojuegos v){
		System.out.println("Añadiendo videojuego");
		daovideojuego.newVideojuego(v);
		return new ResponseEntity<Videojuegos>(v,HttpStatus.CREATED);
		
	}
	@GetMapping(path="videojuegos",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuegos>> listarVideojuegos(){
		List<Videojuegos> listarVideojuegos;
		listarVideojuegos=daovideojuego.listaVideojuegos;
		System.out.println(listarVideojuegos);
		
		return new ResponseEntity<List<Videojuegos>>(listarVideojuegos,HttpStatus.OK);
		
	}
	@PutMapping(path="videojuegos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuegos> modificarVideojuego(
			@PathVariable("id") int id,
			@RequestBody Videojuegos v){
		System.out.println("Videojuego a modificar dando el id " + v);
		v.setId(id);
		Videojuegos vAux = daovideojuego.updateVideojuego(v);
		if(vAux!=null) {
			return new ResponseEntity<Videojuegos>(HttpStatus.OK);
		}else 
			return new ResponseEntity<Videojuegos>(HttpStatus.NOT_FOUND);
		}
	
	@DeleteMapping(path="videojuegos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuegos> borrarVideojuego(@PathVariable("id") int id){
		System.out.println("Persona a borrar con el id: " + id);
		Videojuegos v = daovideojuego.deleteVideojuego(id);
		if (v != null)
			return new ResponseEntity<Videojuegos>(HttpStatus.OK);
		else 
			return new ResponseEntity<Videojuegos>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
