package modelo.personajes.enemigos;



import modelo.modos.modos.BooMalo;
import modelo.modos.modos.BooOriginal;
import modelo.modos.modos.NormalMajinBoo;
import modelo.personajes.Personaje;

public class MajinBoo extends Personaje{
	
	public MajinBoo(){
		super.nombre = "MajinBoo";
		super.ki = 0;
		super.puntosDeVidaInicial = 400;
		super.puntosDeVida = 400;
		super.modoActual = new NormalMajinBoo();
		super.modos.put("BooMalo",new BooMalo());
		super.modos.put("BooOriginal", new BooOriginal());
		super.kiAtaqueEspecial = 30;
	}
	
	@Override
	public void atacarAPersonajeConAtaqueEspecial(Personaje enemigo){
		super.atacarAPersonajeConAtaqueEspecial(enemigo);
		enemigo.convertirseEnChocolate();
	}
}
