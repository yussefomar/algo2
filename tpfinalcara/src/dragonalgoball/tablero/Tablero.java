package dragonalgoball.tablero;

import java.util.ArrayList;
import java.util.List;

import modelo.personajes.Personaje;

public class Tablero {
	private List<Fila> tabla;
	
	public Tablero(int alto, int ancho){
		tabla = new ArrayList<Fila>();
		for (int i = 0; i < alto; i = i + 1){
			Fila fila = new Fila(ancho);
			tabla.add(fila);
		}
		this.asignarAdyacentes();
	}
	
	private void asignarAdyacentes(){
		for (int i = 0; i < tabla.size(); i = i + 1){
			this.obtenerFila(i).asignarAdyacentes(this.obtenerFila(i - 1), this.obtenerFila(i + 1));
		}
	}
	
	public Fila obtenerFila(int indice){
		if (indice < 0 || indice >= tabla.size()){
			return null;
		}
		return tabla.get(indice);
	}
	
	public int cantidadFilas(){
		return tabla.size();
	}
	
	public int obtenerDistancia(Celda posInicial, Celda posFinal){
		Bfs busqueda = new Bfs();
		return busqueda.obtenerDistancia(posInicial, posFinal);
	}
	
	public void colocarPersonaje(Personaje unPersonaje, int fila, int columna){
		Celda celda = this.obtenerCelda(fila, columna);
		celda.insertarPersonaje(unPersonaje);
		unPersonaje.establecerCeldaActual(celda);
	}
	
	public Celda obtenerCelda(int fila, int columna){
		return this.obtenerFila(fila).obtenerCelda(columna);
	}
	
}


