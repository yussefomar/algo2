package modelo.modos.modos;

import dragonalgoball.Equipo;
import excepciones.ExcepcionTransformacionNoPosible;
import modelo.modos.Modo;

public class Protector extends Modo{
	
	private Equipo equipo;
	
	public  Protector(Equipo equipo){
		
		super.poderDePelea = 60;
		super.distanciaDeAtaque = 6;
		super.velocidad = 4;
		super.costo = 0;
		super.nombre = "Protector";
		this.equipo = equipo;
	}
	
	@Override
	public boolean transformacionPosible(int ki){
		if (equipo.obtenerPersonaje("Gohan").vidaMenorA(0.2)){
			return true;
		}else{
			return false;
		}
		 
	}
	
}
