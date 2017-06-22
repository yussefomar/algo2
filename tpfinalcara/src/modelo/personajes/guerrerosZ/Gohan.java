package modelo.personajes.guerrerosZ;

import modelo.modos.Modo;
import modelo.modos.modos.NormalGohan;
import modelo.modos.modos.SuperSayajinFase1;
import modelo.modos.modos.SuperSayajinFase2;
import modelo.personajes.Personaje;
import dragonalgoball.Equipo;
import excepciones.ExcepcionTransformacionNoPosible;

public class Gohan extends Personaje{
	
	public Gohan(Equipo equipo){
		super.nombre = "Gohan";
		super.ki = 0;
		super.puntosDeVidaInicial = 300;
		super.puntosDeVida = 300;
		super.modoActual= new NormalGohan();
		super.modos.put("SuperSayajinFase1",new SuperSayajinFase1());
		super.modos.put("SuperSayajinFase2", new SuperSayajinFase2(equipo));
		super.kiAtaqueEspecial = 10;
	}
	
	@Override
	public void atacarAPersonajeConAtaqueEspecial(Personaje enemigo){
		super.atacarAPersonajeConAtaqueEspecial(enemigo);
		enemigo.disminuirVida(super.obtenerDanioHaciaEnemigo(enemigo) * 1.25);
	}
	
	@Override	
	public void cambiarModo(String nombremodo){
		Modo nuevoModo = super.obtenerModo(nombremodo);
		if (!nuevoModo.transformacionPosible(ki))
			throw new ExcepcionTransformacionNoPosible();
		this.ki -= nuevoModo.obtenerCosto();
		this.modoActual = nuevoModo;
	}
}
