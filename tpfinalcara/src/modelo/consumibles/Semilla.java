package modelo.consumibles;

public class Semilla implements Consumible {
	
	private static int aumentoDeVida = 100;
	private int turnosRestantes;
	
	public Semilla(){
		turnosRestantes = 1;
	}
	
	@Override
	public boolean sePuedeUtilizar(){
		return turnosRestantes > 0;
	}

	@Override
	public double obtenerNuevaVida(double vida) {
		return vida + aumentoDeVida;
	}
	
	@Override
	public double obtenerNuevoDanio(double danio) {
		return danio;
	}

	@Override
	public int obtenerNuevaVelocidad(int velocidad) {
		return velocidad;
	}

	@Override
	public int sumarEsfera() {
		return 0;
	}
	
	@Override
	public void disminuirTurno() {
		turnosRestantes--;
	}
	
}
