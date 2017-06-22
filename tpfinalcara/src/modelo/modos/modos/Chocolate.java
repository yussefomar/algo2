package modelo.modos.modos;

import excepciones.ExcepcionConvertidoEnChocolate;
import excepciones.ExcepcionTurnosCumplidos;
import modelo.modos.Modo;

public class Chocolate extends Modo {
	
	private int turnos;
	private Modo modoAnterior;
	
	public Chocolate(){
		turnos = 3;
	}
	
	public boolean seCumplieronLosTurnos(){
		return turnos==0;
	}
	
	public void cumplirTurno(){
		if(this.seCumplieronLosTurnos())
			throw new ExcepcionTurnosCumplidos("Ya se han cumplido los turnos en este estado");
		turnos--;
	}
	
	public void establecerModoAnterior(Modo modo){
		modoAnterior = modo;
	}
	
	public Modo obtenerModoAnterior(){
		return modoAnterior;
	}
	
	public boolean estaConvertidoEnChocolate(){
		return true;
	}
	 
	@Override 
	public int obtenerPoderDePelea(){
		return modoAnterior.obtenerPoderDePelea();
	}
	 
	@Override
	public int obtenerDistanciaDeAtaque(){
		throw new ExcepcionConvertidoEnChocolate("oh nooo");
	}
	
	@Override
	public int obtenerVelocidad(){
		throw new ExcepcionConvertidoEnChocolate("oh nooo");
	}

}
