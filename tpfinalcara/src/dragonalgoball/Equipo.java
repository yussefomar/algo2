package dragonalgoball;

import java.util.HashMap;

import excepciones.ExcepcionPersonajeExistente;
import excepciones.ExcepcionPersonajeInexistente;
import modelo.personajes.Personaje;


public class Equipo{

	private HashMap<String,Personaje> personajes;
	
	public Equipo(){
		 personajes = new HashMap<String,Personaje>();
	}
	
	public void agregarPersonaje(Personaje unPersonaje){
		if (this.existePersonaje(unPersonaje.obtenerNombre())){
			throw new ExcepcionPersonajeExistente();
		}
		personajes.put(unPersonaje.obtenerNombre(), unPersonaje);
	}
	
	public Personaje obtenerPersonaje(String unNombre){
		if (!this.existePersonaje(unNombre)){
			throw new ExcepcionPersonajeInexistente();
		}
		return personajes.get(unNombre);
	}
	
	public boolean existePersonaje(String unPersonaje){
		return personajes.containsKey(unPersonaje);
	}
	
	public void aumentarKiAIntegrantes(int aumento){
		for (Personaje unPersonaje : personajes.values()){
			unPersonaje.aumentarKi(aumento);
		}
	}
	
	public boolean estaDerrotado(){
		for ( Personaje unPersonaje : personajes.values()){
			if (!unPersonaje.estaMuerto())
				return false;
		}
		return true;
	}
	
	public int cantidadEsferas(){
		int cantEsferas = 0;
		for ( Personaje unPersonaje : personajes.values()){
			cantEsferas += unPersonaje.cantidadDeEsferas();
		}
		return cantEsferas;
	}
	
	public void cambiarTurno(){
		for (Personaje unPersonaje : personajes.values()){
			unPersonaje.cumplirTurno();
		}
	}
}
