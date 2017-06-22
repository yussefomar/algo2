package modelo.consumibles;

public interface Consumible {

	public abstract boolean sePuedeUtilizar();
	
	public abstract double obtenerNuevoDanio(double danio);
	
	public abstract int obtenerNuevaVelocidad(int velocidad);
	
	public abstract double obtenerNuevaVida(double vida);
	
	public abstract int sumarEsfera();
	
	public abstract void disminuirTurno();
	
}
