package modelo.modos.modos;

import modelo.modos.Modo;

public class Definitivo extends Modo{
	
	public  Definitivo(){
		
		super.poderDePelea =50;
		super.distanciaDeAtaque = 3;
		super.velocidad = 6;
		super.costo = 50;
		super.nombre = "Definitivo";
	}
}
