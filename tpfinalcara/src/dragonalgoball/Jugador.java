package dragonalgoball;


import dragonalgoball.tablero.Celda;
import dragonalgoball.tablero.Tablero;
import excepciones.ExcepcionAtacarPersonajeAliado;
import modelo.personajes.Personaje;

public class Jugador {
	
	private String nombre;
	private Equipo equipo;
	private boolean ataqueRealizado;
	private boolean movimientoRealizado;
    		
    public Jugador(String unNombre){
    	nombre = unNombre;
    	ataqueRealizado = false;
    	movimientoRealizado = false;
    }
    
    public Personaje elegirPersonaje(String unPersonaje){
    	return  equipo.obtenerPersonaje(unPersonaje);
    }
    
    public Equipo obtenerEquipo(){
    	return equipo;
    }
    
    public boolean personajePerteneceAlEquipo(String unPersonaje){
    	return equipo.existePersonaje(unPersonaje);
    }
		
    public void evolucionarPersonaje(String nombreDeLaEvolucion, String unPersonaje){
    	this.elegirPersonaje(unPersonaje).cambiarModo(nombreDeLaEvolucion);
    }
    
    public void moverA(Tablero tablero, Celda unaPosicion, String unPersonaje){
    	if(!movimientoRealizado){
    		this.elegirPersonaje(unPersonaje).moverACelda(unaPosicion, tablero); 
    		movimientoRealizado = true;
    	}
    }
    
    public void atacarA(Tablero tablero, Celda unaPosicion, String unPersonaje){
    	if (!ataqueRealizado){
    		this.elegirPersonaje(unPersonaje).atacarA(this.obtenerPersonajeEnemigo(unaPosicion), tablero);
    		ataqueRealizado = true;
    	}
    }
    
    public void atacarAConAtaqueEspecial(Tablero tablero, Celda unaPosicion, String unPersonaje){
    	if (!ataqueRealizado){
    		this.elegirPersonaje(unPersonaje).atacarConAtaqueEspecialA(this.obtenerPersonajeEnemigo(unaPosicion), tablero);
    		ataqueRealizado = true;
    	}
    }
    
    private Personaje obtenerPersonajeEnemigo(Celda unaPosicion){
     	Personaje personaje = unaPosicion.obtenerPersonaje();
    	if (this.personajePerteneceAlEquipo(personaje.obtenerNombre())){
    		throw new ExcepcionAtacarPersonajeAliado();
    	}
    	return personaje;
    }
    
    public void asignarEquipo(Equipo unEquipo){
    	equipo = unEquipo;
    }
    
    public String obtenerNombre(){
    	return nombre;
    }
    
    public void resetearJugador(){
    	ataqueRealizado = false;
    	movimientoRealizado = false;
    	equipo.cambiarTurno();
    }
}
