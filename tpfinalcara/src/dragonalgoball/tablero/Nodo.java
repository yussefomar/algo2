package dragonalgoball.tablero;

public class Nodo {
	
	private Celda celda;
	private int distancia;
	
	public Nodo(Celda unaCelda, int unaDistancia){
		celda = unaCelda;
		distancia = unaDistancia;
	}
	
	public Celda obtenerCelda(){
		return celda;
	}
	
	public int obtenerDistancia(){
		return distancia;
	}

}
