package modelo.personajes.enemigos;


import modelo.modos.Modo;
import modelo.modos.modos.NormalCell;
import modelo.modos.modos.Perfecto;
import modelo.modos.modos.SemiPerfecto;
import modelo.personajes.Personaje;
import excepciones.ExcepcionAbsorcionesInsuficientes;

public class Cell extends Personaje{
	
	private int absorciones;
	
	public Cell(){
		super.nombre = "Cell";
		super.ki = 0;
		super.puntosDeVidaInicial = 500;
		super.puntosDeVida = 500;
		super.modoActual = new NormalCell();
		super.modos.put("SemiPerfecto", new SemiPerfecto());
		super.modos.put("Perfecto", new Perfecto());
		this.absorciones = 0;
	}
	
	public void atacarAPersonajeConAtaqueEspecial(Personaje enemigo){
		super.atacarAPersonajeConAtaqueEspecial(enemigo);
		double danio = super.obtenerDanioHaciaEnemigo(enemigo);
		enemigo.disminuirVida(danio);
		this.aumentarVida(danio);
		this.absorciones ++;
	}
	
	public int obtenerAbsorciones(){
		return this.absorciones;
	}
	
	@Override	
	public void cambiarModo(String nombremodo){
		Modo nuevoModo = super.obtenerModo(nombremodo);
		if (!nuevoModo.transformacionPosible(ki, absorciones))
			throw new ExcepcionAbsorcionesInsuficientes("Cell no ha absorvido suficientes personajes");
		this.ki -= nuevoModo.obtenerCosto();
		this.modoActual = nuevoModo;
	}
	
}
