package modelo.modos.modos;

import modelo.modos.Modo;

public class Perfecto extends Modo {
	
	private  int absorcionesPerfecto = 8;
	
	public Perfecto(){
		
		super.poderDePelea = 80;
		super.distanciaDeAtaque = 4;
		super.velocidad = 4;
		super.costo = 0;
		super.nombre = "Perfecto";
	}
	
	public boolean transformacionPosible(int ki, int absorciones){
		if (ki >= costo && absorciones >= absorcionesPerfecto)
			return true;
		return false;
	}
}
	

	
