package dragonalgoball.tablero;
import java.util.ArrayList;
import java.util.List;


public class Fila{
	private List<Celda> fila;
	
	public Fila(int largo){
		fila = new ArrayList<Celda>();
		for (int i = 0; i < largo; i = i + 1){
			Celda celda = new Celda();
			this.fila.add(celda);	
		}	
	}
	
	public Celda obtenerCelda(int indice){
		if (indice < 0 || indice >= fila.size()){
			return null;
		}
		return fila.get(indice);
	}
	
	public void asignarAdyacentes(Fila filaAnterior, Fila filaSiguiente){
		for(int i = 0; i < fila.size(); i = i + 1){
			this.adyacentesEnFila(i);
			this.adyacentesEnColumnayDiagonal(i, filaAnterior, filaSiguiente);
		}
	}
	
	public void adyacentesEnFila(int indice){
		fila.get(indice).agregarAdyacente(this.obtenerCelda(indice + 1));
		fila.get(indice).agregarAdyacente(this.obtenerCelda(indice - 1));
	}
	
	public void adyacentesEnColumnayDiagonal(int indice, Fila filaAnterior, Fila filaSiguiente){
		if (filaAnterior != null){
			fila.get(indice).agregarAdyacente(filaAnterior.obtenerCelda(indice + 1));
			fila.get(indice).agregarAdyacente(filaAnterior.obtenerCelda(indice));
			fila.get(indice).agregarAdyacente(filaAnterior.obtenerCelda(indice - 1));
		}
		if (filaSiguiente != null){
			fila.get(indice).agregarAdyacente(filaSiguiente.obtenerCelda(indice + 1));
			fila.get(indice).agregarAdyacente(filaSiguiente.obtenerCelda(indice));
			fila.get(indice).agregarAdyacente(filaSiguiente.obtenerCelda(indice - 1));
		}
	}
	
	public int cantidadCeldas(){
		return fila.size();
	}
	
}

	
