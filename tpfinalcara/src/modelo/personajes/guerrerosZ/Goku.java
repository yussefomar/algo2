package modelo.personajes.guerrerosZ;

import modelo.modos.modos.KaioKen;
import modelo.modos.modos.NormalGoku;
import modelo.modos.modos.SuperSayajin;
import modelo.personajes.Personaje;


public class Goku extends Personaje{

	public  Goku(){
		super.nombre = "Goku";
		super.ki = 0;
		super.puntosDeVidaInicial = 500;
		super.puntosDeVida = 500;
		super.modoActual = new NormalGoku();
		super.modos.put("KaioKen",new KaioKen());
		super.modos.put("SuperSayajin", new SuperSayajin());
		super.kiAtaqueEspecial = 20;
	}
	
	@Override
	public double obtenerDanioHaciaEnemigo(Personaje enemigo){
		double danio = super.obtenerDanioHaciaEnemigo(enemigo);
		if (super.vidaMenorA(0.3)){
			danio = danio * 1.2;
		}
		return danio;
	}	 
	
	@Override
	public void atacarAPersonajeConAtaqueEspecial(Personaje enemigo){
		super.atacarAPersonajeConAtaqueEspecial(enemigo);
		enemigo.disminuirVida(super.obtenerDanioHaciaEnemigo(enemigo) * 1.50);
	}
}
