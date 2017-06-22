package modelo.modos;

import dragonalgoball.tablero.Celda;

public  abstract class Modo {
	
	protected int poderDePelea;
	protected int distanciaDeAtaque;
	protected int velocidad;
	protected String nombre;
	protected int costo;
	

	public int obtenerPoderDePelea(){
		return this.poderDePelea;
	}
	public int obtenerDistanciaDeAtaque(){
		return this.distanciaDeAtaque;
	}
    public int obtenerVelocidad(){
    	return this.velocidad;
    }
    
    public int obtenerCosto(){
    	return this.costo;
    }
    
    public String obtenerNombre(){
    	return this.nombre;
    }
    
    public double disminuirVida(Double vida, double danio){
    	vida -= danio;
    	return vida;
    }
    
    public double aumentarVida(Double vida, double aumento){
    	vida += aumento;
    	return vida;
    }
    
    public boolean transformacionPosible(int ki){
    	if (costo > ki)
    		return false;
    	return true;
    }
    
    public boolean transformacionPosible(int ki, int absorciones){
    	return true;
    }
    
    public Celda obtenerCeldaActual(Celda celda){
    	return celda;
    }
    
    public boolean estaMuerto(){
    	return false;
    }
    
    public boolean estaConvertidoEnChocolate(){
    	return false;
    }
    
    public void cumplirTurno(){
    	
    }
    
    public int obtenerTurnosRestantes(){
    	return 0;
    }
    
    public Modo obtenerModoAnterior(){
    	return null;
    }
}