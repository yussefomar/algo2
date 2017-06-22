package modelo.personajes.enemigos;


import modelo.modos.modos.Definitivo;
import modelo.modos.modos.NormalFreezer;
import modelo.modos.modos.SegundaForma;
import modelo.personajes.Personaje;


public class Freezer extends Personaje{
	
	public Freezer(){
		super.nombre = "Freezer";
		super.ki = 0;
		super.puntosDeVidaInicial = 400;
		super.puntosDeVida = 400;
		super.modoActual = new NormalFreezer();
		super.modos.put("SegundaForma",new SegundaForma());
		super.modos.put("Definitivo", new Definitivo());
		super.kiAtaqueEspecial = 20;
	}
	
	@Override
	public void atacarAPersonajeConAtaqueEspecial(Personaje enemigo){
		super.atacarAPersonajeConAtaqueEspecial(enemigo);
		enemigo.disminuirVida(super.obtenerDanioHaciaEnemigo(enemigo) * 1.50);
	}
}
