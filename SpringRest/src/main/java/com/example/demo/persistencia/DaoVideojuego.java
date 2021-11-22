package com.example.demo.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entidad.Videojuegos;
@Component
public class DaoVideojuego {
	public List <Videojuegos> listaVideojuegos ;
	int contador = 0;
	public DaoVideojuego() {
	System.out.println("Creando la lista de vidojuegos");
	listaVideojuegos = new ArrayList<Videojuegos>();
	//creamos la variable contador para ir asginando un id diferente a cada objeto videojuego
	
	
	//estamos creando os videojuegos en memoria en el contexto de spring
	Videojuegos videojuego1 = new Videojuegos(contador++, "Star wars", "Lucasart", 10);
	Videojuegos videojuego2 = new Videojuegos(contador++, "plantas vs zombies", "EA", 6);
	Videojuegos videojuego3 = new Videojuegos(contador++, "Pro Evolution 5", "Konami", 9);
	Videojuegos videojuego4 = new Videojuegos(contador++, "Fifa 21", "EA", 8);
	Videojuegos videojuego5 = new Videojuegos(contador++, "Clash Royale", "Supercell", 7);
	
	//añadimos a la lista que hemos creado los objetos videojuegos
	listaVideojuegos.add(videojuego1);
	listaVideojuegos.add(videojuego2);
	listaVideojuegos.add(videojuego3);
	listaVideojuegos.add(videojuego4);
	listaVideojuegos.add(videojuego5);
	
	}
	
	/**
	 * Este get devuelve un videojuego, ese videojuego es buscado por un id
	 * @param id
	 * @return videojuego
	 */

	public Videojuegos getVideojuego(int id) {
	try {
		return listaVideojuegos.get(id);
	}catch(IndexOutOfBoundsException e ) {
		System.out.println("Id fuera de rango");
		return null;
	}
	
	}
	
	/**
	 * Este metodo devuelve una lista de videojuegos
	 * @return list videojuegos 
	 */
	public List<Videojuegos> list(){
		return listaVideojuegos;
	}
	
	/**
	 * Este metodo añade un nuevo videojuego a la lista, dando un id unico cada vez 
	 * @param v
	 */
	public void newVideojuego(Videojuegos v) {
		v.setId(contador++);
		listaVideojuegos.add(v);
	}
	
	/**
	 * este metodo elimina un videojuego de la lista,borrandolo por un parametro de busca "id"
	 * @param id
	 * @return
	 */
	public Videojuegos deleteVideojuego(int id) {
		try {
			System.out.println("El videojuego se ha borrado correctamente");
			return listaVideojuegos.remove(id);
		}catch(IndexOutOfBoundsException e) {
			System.out.println("El videojueo no se ha encontrado");
			return null;
		}
	}
	
	public Videojuegos updateVideojuego(Videojuegos v) {
		try {
		Videojuegos vAux = listaVideojuegos.get(v.getId());
	
			vAux.setId(v.getId());
			vAux.setNombre(v.getNombre());
			vAux.setCompania(v.getCompania());
			vAux.setNota(v.getNota());
		
		return vAux;
		}catch(IndexOutOfBoundsException e) {
			System.out.println("El videojuego a actualizar no se encuentra");
			return null;
		}
		
	}
	
	
	
	
	
	
}
