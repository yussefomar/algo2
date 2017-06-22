package modelo.consumibles;

import excepciones.ExcepcionPoderDeConsumibleAgotado;

public class Esfera implements Consumible {
	
	private int ataquesRestantes;
	
	public Esfera(){
		ataquesRestantes = 2;
	}
	
	@Override
	public boolean sePuedeUtilizar(){
		return ataquesRestantes > 0;
	}
	
	@Override
	public double obtenerNuevoDanio(double danio){
		if (!this.sePuedeUtilizar()) 
			throw new ExcepcionPoderDeConsumibleAgotado("El poder de la esfera está agotado");
		ataquesRestantes--;
		return danio * 0.75;	
	}

	@Override
	public int obtenerNuevaVelocidad(int velocidad) {
		return velocidad;
	}

	@Override
	public double obtenerNuevaVida(double vida) {
		return vida;
	}

	@Override
	public int sumarEsfera() {
		return 1;
	}

	@Override
	public void disminuirTurno() {
		
	}	
}
