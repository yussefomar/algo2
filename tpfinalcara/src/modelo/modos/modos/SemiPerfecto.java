package modelo.modos.modos;

import modelo.modos.Modo;

public class SemiPerfecto extends Modo {
	
	private int absorcionesSemiPerfecto = 4;
	
	public SemiPerfecto(){
		
		super.poderDePelea = 40;
		super.distanciaDeAtaque = 4;
		super.velocidad = 3; 
		super.costo = 0;
		super.nombre = "SemiPerfecto";
	}
	
	public boolean transformacionPosible(int ki, int absorciones){
		if (ki >= costo && absorciones >= absorcionesSemiPerfecto)
			return true;
		return false;
	}
}