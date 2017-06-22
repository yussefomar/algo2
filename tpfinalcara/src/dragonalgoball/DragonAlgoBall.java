package dragonalgoball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import dragonalgoball.tablero.Tablero;
import modelo.consumibles.Consumible;
import modelo.consumibles.Esfera;
import modelo.consumibles.NubeVoladora;
import modelo.consumibles.Semilla;
import dragonalgoball.tablero.Celda;

public class DragonAlgoBall {
	
	private HashMap<String, Jugador> jugadores;
	private Tablero tablero;
	private Turno turno;
	
	public DragonAlgoBall(String nombreJugador1, String nombreJugador2){
		jugadores = new HashMap<String, Jugador>();
		jugadores.put(nombreJugador1, new Jugador(nombreJugador1));
		jugadores.put(nombreJugador2, new Jugador(nombreJugador2));
		turno = new Turno(jugadores.values().iterator());
	}
	
	
	public void crearTablero(int filas, int columnas){
		tablero = new Tablero(filas, columnas);
	}
	
	public Equipo crearEquipo(){
		return new Equipo();
	}
	
	public void asignarEquipoAJugador(String jugador, Equipo unEquipo){
		jugadores.get(jugador).asignarEquipo(unEquipo);
	}
	
	public double obtenerVidaDePersonaje(String unPersonaje){
		return turno.obtenerJugadorActual().elegirPersonaje(unPersonaje).obtenerPuntosDeVida();
	}
	
	public void cambiarTurno(){
		turno.cambiarJugadores();
	}
	
	public void colocarPersonaje(String unPersonaje, int fila, int columna){
		tablero.colocarPersonaje(turno.obtenerJugadorActual().elegirPersonaje(unPersonaje), fila, columna);
	}
	
	public String obtenerPersonajeEnCelda(int fila, int columna){
		Celda celda = tablero.obtenerCelda(fila, columna);
		return celda.obtenerPersonaje().obtenerNombre();
	}
	
	public Celda obtenerPosicion(String unPersonaje){
		return turno.obtenerJugadorActual().elegirPersonaje(unPersonaje).obtenerCeldaActual();
	}
	
	public Celda obtenerCelda(int fila, int columna){
		return tablero.obtenerCelda(fila, columna);
	}
	
	public void moverPersonajeA(String unPersonaje, int fila, int columna){
		turno.obtenerJugadorActual().moverA(tablero, tablero.obtenerCelda(fila, columna), unPersonaje);
	}
	
	public void atacarCon(String unPersonaje, int fila, int columna){
		turno.obtenerJugadorActual().atacarA(tablero, tablero.obtenerCelda(fila, columna), unPersonaje);
	}
	
	public void cambiarModoPersonaje(String unPersonaje, String unModo){
		turno.obtenerJugadorActual().elegirPersonaje(unPersonaje).cambiarModo(unModo);
	}
	
	public int obtenerPoderDePeleaPersonaje(String unPersonaje){
		return turno.obtenerJugadorActual().elegirPersonaje(unPersonaje).obtenerPoderdePelea();
	}
	
	public void atacarConAtaqueEspecial(String unPersonaje, int fila, int columna){
		turno.obtenerJugadorActual().atacarAConAtaqueEspecial(tablero, tablero.obtenerCelda(fila, columna), unPersonaje);
	}

	public boolean celdaSeleccionadaVacia(int fila, int columna){
		return tablero.obtenerCelda(fila, columna).esta_vacia(); 
	}
	
	public Consumible generarConsumible(){
		List<Consumible> consumibles = new ArrayList<Consumible>();
		consumibles.add(new Semilla());
		consumibles.add(new NubeVoladora());
		consumibles.add(new Esfera());
		consumibles.add(null);
		Random rnd = new Random();
		rnd.setSeed(System.currentTimeMillis()); //Cambia la semilla del random.
		int indice = (int) (rnd.nextDouble() * (consumibles.size() - 1));
		return consumibles.get(indice);
	}
	
	public void colocarConsumibleEnTablero(Consumible consumible){
		Random rnd = new Random();
		while (true){
			rnd.setSeed(System.currentTimeMillis()); //Cambia la semilla del random.
			int fila = (int) (rnd.nextDouble() * (tablero.cantidadFilas() - 1));
			int columna = (int) (rnd.nextDouble() * (tablero.obtenerFila(fila).cantidadCeldas() - 1));
			Celda celda = tablero.obtenerCelda(fila, columna);
			if (celda.esta_vacia()){
				celda.insertarConsumible(consumible);
				break;
			}
		}
	}
	
}