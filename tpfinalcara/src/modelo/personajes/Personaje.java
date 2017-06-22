package modelo.personajes;


import java.util.HashMap;
import java.util.Map;

import modelo.modos.Modo;
import modelo.modos.modos.Chocolate;
import modelo.modos.modos.Muerto;
import modelo.consumibles.Consumible;
import excepciones.ExcepcionMovimientoInvalido;
import excepciones.ExcepccionConsumibleAsignado;
import excepciones.ExcepcionKiInsuficiente;
import excepciones.ExcepcionModoInvalido;
import dragonalgoball.tablero.Celda;
import dragonalgoball.tablero.Tablero;

public abstract class Personaje {
	
	protected Celda celdaActual;
	protected String nombre;
	protected double puntosDeVida;
	protected double puntosDeVidaInicial;
	protected int ki;
	protected Modo modoActual;
	protected Map<String,Modo> modos;
	protected Consumible consumible;
	protected int kiAtaqueEspecial;
	protected int cantEsferas;
	
	public Personaje(){
		modos = new HashMap<String, Modo>();
		consumible = null;
		cantEsferas = 0;
	} 
	
	public void morir(){
		this.modoActual = new Muerto();
	}
	
	public boolean estaMuerto(){
		return modoActual.estaMuerto();
	}
	
	public boolean estaConvertidoEnChcolate(){
		return modoActual.estaConvertidoEnChocolate();
	}
	
	private boolean esUnMovimientoPosible(int distancia, int movPersonaje){
		return movPersonaje >= distancia;
	}
	
	public Celda obtenerCeldaActual(){
		return modoActual.obtenerCeldaActual(celdaActual);
	}
	
	public void establecerCeldaActual(Celda celda){
		celdaActual = celda;
	}
	
	public String  obtenerNombre(){
		return nombre;
	}
	
	public  int obtenerVelocidad(){
		int velocidad = this.modoActual.obtenerVelocidad();
		if (this.tieneConsumible())
			return consumible.obtenerNuevaVelocidad(velocidad);
	    return velocidad;
	}
	
	public  int obtenerDistanciaDeAtaque (){ 
		return modoActual.obtenerDistanciaDeAtaque();
	}
	
	public int obtenerPoderdePelea(){
		return this.modoActual.obtenerPoderDePelea();
	}
	
	public double obtenerPuntosDeVida(){
		return this.puntosDeVida;
	}
	
	public double obtenerDanioHaciaEnemigo(Personaje enemigo){	
		double danio = this.obtenerPoderdePelea();
		if (enemigo.obtenerPoderdePelea() > danio)
			danio = danio * 0.8;
		if (this.tieneConsumible())
			return consumible.obtenerNuevoDanio(danio);
		return danio;
	}
	
	public Modo obtenerModo(String nombremodo){
		if (!modos.containsKey(nombremodo))
			throw new ExcepcionModoInvalido();
		return modos.get(nombremodo);
	}
	
	public Modo obtenerModoActual(){
		return modoActual;
	}
	
	public void cambiarModo(String nombremodo){ 	
		Modo nuevoModo = this.obtenerModo(nombremodo);
		if (!nuevoModo.transformacionPosible(ki))
			throw new ExcepcionKiInsuficiente();
		this.ki -= nuevoModo.obtenerCosto();
		this.modoActual = nuevoModo;
	}

	public void disminuirVida(double danio){
		puntosDeVida = modoActual.disminuirVida(puntosDeVida, danio);
		if (puntosDeVida <= 0) 
			this.morir();
	 }
		
	public void aumentarVida(double aumento){
		puntosDeVida = modoActual.aumentarVida(puntosDeVida, aumento);
	}
	
	public boolean vidaMenorA(double porcentaje){
		return puntosDeVidaInicial * porcentaje > puntosDeVida;
	}
	
	public void aumentarKi(int aumento){
		ki += aumento;
	}
	
	private void atacarAPersonaje(Personaje enemigo){
		enemigo.disminuirVida(this.obtenerDanioHaciaEnemigo(enemigo));
	}
	
	public void atacarA(Personaje enemigo,Tablero tablero){	
		if(!this.esUnMovimientoPosible(tablero.obtenerDistancia(this.obtenerCeldaActual(), enemigo.obtenerCeldaActual()),this.obtenerDistanciaDeAtaque()))
			throw new ExcepcionMovimientoInvalido();
		this.atacarAPersonaje(enemigo);
	}
	
	public void atacarConAtaqueEspecialA(Personaje enemigo, Tablero tablero){
		if(!this.esUnMovimientoPosible(tablero.obtenerDistancia(this.obtenerCeldaActual(), enemigo.obtenerCeldaActual()), this.obtenerDistanciaDeAtaque()))
			throw new ExcepcionMovimientoInvalido();
		this.atacarAPersonajeConAtaqueEspecial(enemigo);
	}
	
	protected void atacarAPersonajeConAtaqueEspecial(Personaje enemigo){
		if (kiAtaqueEspecial > ki){
			throw new ExcepcionKiInsuficiente();
		}
		ki -= kiAtaqueEspecial;
	}
	
	public void moverACelda(Celda celda, Tablero tablero){
		if (!this.esUnMovimientoPosible(tablero.obtenerDistancia(this.obtenerCeldaActual(), celda), this.obtenerVelocidad()))
			throw new ExcepcionMovimientoInvalido();
		if (celda.contieneConsumible()){
			this.agregarConsumible(celda.obtenerConsumible());
			celda.eliminarConsumible();
		}
		celda.insertarPersonaje(this);
		celdaActual.eliminarPersonaje();
		celdaActual = celda;
	}
	
	public void convertirseEnChocolate(){
		Chocolate chocolate = new Chocolate();
		chocolate.establecerModoAnterior(modoActual);
		modoActual = chocolate;
	}
	
	public void cumplirTurno(){
		modoActual.cumplirTurno();// Solo tiene efecto si el jugador esta convertido en Chocolate.
		if (modoActual.obtenerTurnosRestantes() <= 0)
			modoActual = modoActual.obtenerModoAnterior();
		if (this.tieneConsumible()){
			consumible.disminuirTurno();
			if (!consumible.sePuedeUtilizar())
				consumible = null;
		}
	}
	
	private boolean tieneConsumible() {
		return consumible != null;
	}
	
	public int cantidadDeEsferas(){
		return cantEsferas;
	}
	
	public void agregarConsumible(Consumible unConsumible){
		if (this.tieneConsumible())
			throw new ExcepccionConsumibleAsignado();
		puntosDeVida = unConsumible.obtenerNuevaVida(puntosDeVida);
		cantEsferas += unConsumible.sumarEsfera();
		consumible = unConsumible; 
	}
	

	
}