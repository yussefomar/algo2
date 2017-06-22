package dragonalgoball;

import java.util.Iterator;

public class Turno {
	
	private Jugador jugadorActual;
	private Jugador jugadorEnEspera;
	
	public Turno(Iterator<Jugador> jugadores){
		jugadorActual = jugadores.next();
		jugadorEnEspera = jugadores.next();
	}
	
	public Jugador obtenerJugadorActual(){
		return jugadorActual;
	}
	
	public Jugador obtenerJugadorEnEspera(){
		return jugadorEnEspera;
	}
	
	public void aumentarKi(){
		jugadorActual.obtenerEquipo().aumentarKiAIntegrantes(5);
	}
	
	public void cambiarJugadores(){
		Jugador auxiliar = this.jugadorActual;
		this.jugadorActual = this.jugadorEnEspera;
		this.jugadorEnEspera = auxiliar;
		this.aumentarKi();
	}
	public boolean hayGanador(){
		return jugadorEnEspera.obtenerEquipo().estaDerrotado() || jugadorActual.obtenerEquipo().cantidadEsferas() == 7;
	}
	
	public void terminarTurno(){
		jugadorActual.resetearJugador();
		this.cambiarJugadores();
	}
	

}
