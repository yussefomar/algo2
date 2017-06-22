package dragonalgoball.tablero;

import excepciones.ExcepcionCeldaVacia;
import excepciones.ExcepcionCeldaOcupada;
import modelo.consumibles.Consumible;
import modelo.personajes.Personaje;
import java.util.ArrayList;
import java.util.List;

public class Celda {
	private Personaje personaje;
	private List<Celda> adyacentes;
	private Consumible consumible;
	
	public Celda(){
		adyacentes = new ArrayList<Celda>();
		personaje = null;
		consumible = null;
	}
	public void insertarConsumible(Consumible unConsumible){
		if (!this.esta_vacia()){
			throw new ExcepcionCeldaOcupada();
		}
		consumible = unConsumible;
	}
	
	public void insertarPersonaje(Personaje unPersonaje){
		if (!this.esta_vacia()){
			throw new ExcepcionCeldaOcupada();
		}
		personaje = unPersonaje;	
	}
	
	public void eliminarConsumible(){
		consumible = null;
	}
	
	public void eliminarPersonaje(){
		personaje = null;
	}
	
	public boolean contieneConsumible(){
		return consumible != null;
	}
	
	public Consumible obtenerConsumible(){
		if (this.esta_vacia())
			throw new ExcepcionCeldaVacia("La celda está vacia");
		return consumible;
	}
	
	public Personaje obtenerPersonaje(){
		if (this.esta_vacia())
			throw new ExcepcionCeldaVacia("La celda está vacia");
		return personaje;
	}
	
	public boolean esta_vacia(){
		return (personaje == null && consumible == null);
	}
	
	public void agregarAdyacente(Celda unaCelda){
		if (unaCelda != null){
			adyacentes.add(unaCelda);
		}
	}
	
	public List<Celda> obtenerAdyacentes(){
		return adyacentes;
	}
	
	public int cantidadAdyacentes(){
		return adyacentes.size();
	}
		
}

