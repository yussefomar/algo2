package modelo.modos.modos;

import dragonalgoball.Equipo;
import modelo.modos.Modo;

public class SuperSayajinFase2 extends Modo {
	
	private Equipo equipo;
	
	public  SuperSayajinFase2(Equipo equipo){
		
		super.poderDePelea = 100;
		super.distanciaDeAtaque = 4;
		super.velocidad = 3;
		super.costo = 30;
		super.nombre = "SuperSayajinFase2";
		this.equipo = equipo;
	}
	
	@Override
	public boolean transformacionPosible(int ki){
		if (equipo.obtenerPersonaje("Goku").vidaMenorA(0.3) && equipo.obtenerPersonaje("Piccolo").vidaMenorA(0.3) && ki >= costo)
			return true;
		return false;
	}
}
