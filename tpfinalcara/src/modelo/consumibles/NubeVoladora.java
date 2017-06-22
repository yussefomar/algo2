package modelo.consumibles;

import excepciones.ExcepcionPoderDeConsumibleAgotado;

public class NubeVoladora implements Consumible{
	
	private int turnosRestantes;
	
	public NubeVoladora(){
		turnosRestantes = 2;
	}
	
	@Override
	public void disminuirTurno(){
		turnosRestantes--;
	}
	
	@Override
	public boolean sePuedeUtilizar(){
		return turnosRestantes > 0;
	}
	
	@Override
	public int obtenerNuevaVelocidad(int velocidad){
		if (!this.sePuedeUtilizar())
			throw new ExcepcionPoderDeConsumibleAgotado("No dispone de mas turnos para utilizar la nube");
		return velocidad * 2;
	}

	@Override
	public double obtenerNuevoDanio(double danio) {
		return danio;
	}

	@Override
	public double obtenerNuevaVida(double vida) {
		return vida;
	}

	@Override
	public int sumarEsfera() {
		return 0;
	}
	
}