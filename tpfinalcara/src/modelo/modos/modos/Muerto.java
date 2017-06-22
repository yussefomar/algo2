package modelo.modos.modos;

import modelo.modos.Modo;

public class Muerto extends Modo{	
	
	public Muerto(){
			super.poderDePelea = 0;
			super.distanciaDeAtaque = 0;;
			super.velocidad = 0;
			super.costo = 0;
			super.nombre = "Muerto";
	}
	
	public boolean estaMuerto(){
		return true;
	}
}
