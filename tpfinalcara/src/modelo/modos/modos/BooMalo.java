package modelo.modos.modos;

import modelo.modos.Modo;

public class BooMalo extends Modo {
	public  BooMalo(){
		
		super.poderDePelea = 50;
		super.distanciaDeAtaque = 2;
		super.velocidad = 3;
		super.costo = 20;
		super.nombre = "BooMalo";
	}

}
