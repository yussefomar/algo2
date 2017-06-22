package modelo.personajes.guerrerosZ;


import dragonalgoball.Equipo;
import excepciones.ExcepcionKiInsuficiente;
import excepciones.ExcepcionTransformacionNoPosible;
import modelo.modos.Modo;
import modelo.modos.modos.Fortalecido;
import modelo.modos.modos.NormalPiccolo;
import modelo.modos.modos.Protector;
import modelo.personajes.Personaje;


public class Piccolo extends Personaje{
	
	public Piccolo(Equipo equipo){
		super.nombre = "Piccolo";
		super.ki = 0;
		super.puntosDeVidaInicial = 500;
		super.puntosDeVida = 500;
		super.modoActual = new NormalPiccolo();
		super.modos.put("Fortalecido",new Fortalecido());
		super.modos.put("Protector", new Protector(equipo));
		super.kiAtaqueEspecial = 10;
	}

	@Override
	public void atacarAPersonajeConAtaqueEspecial(Personaje enemigo){
		super.atacarAPersonajeConAtaqueEspecial(enemigo);
		enemigo.disminuirVida(super.obtenerDanioHaciaEnemigo(enemigo) * 1.25);
	}
	
	public void cambiarModo(String nombremodo){ 	
		Modo nuevoModo = this.obtenerModo(nombremodo);
		if (!nuevoModo.transformacionPosible(ki))
			throw new ExcepcionTransformacionNoPosible();
		this.ki -= nuevoModo.obtenerCosto();
		this.modoActual = nuevoModo;
	}

}
