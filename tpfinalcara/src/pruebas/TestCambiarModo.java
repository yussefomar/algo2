package pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import excepciones.ExcepcionAbsorcionesInsuficientes;
import excepciones.ExcepcionKiInsuficiente;
import modelo.personajes.enemigos.Cell;
import modelo.personajes.enemigos.Freezer;
import modelo.personajes.enemigos.MajinBoo;
import modelo.personajes.guerrerosZ.Goku;



public class TestCambiarModo {
	
	@Test 
	public void test01cambiarModosGoku(){
		Goku personaje = new Goku();
		personaje.aumentarKi(100);
		personaje.cambiarModo("KaioKen");
		assertEquals("KaioKen", personaje.obtenerModoActual().obtenerNombre());
		personaje.aumentarKi(50);
		personaje.cambiarModo("SuperSayajin");
		assertEquals("SuperSayajin", personaje.obtenerModoActual().obtenerNombre());
	}

	@Test (expected = ExcepcionKiInsuficiente.class)
	public void test02cambiarModoGokuSuperSayajinFalla(){
		Goku personaje = new Goku();
		personaje.aumentarKi(40);
		personaje.cambiarModo("SuperSayajin");
	}
	
	@Test
	public void test03cambiarModosBoo(){
		MajinBoo personaje = new MajinBoo();
		personaje.aumentarKi(70);
		personaje.cambiarModo("BooMalo");
		assertEquals("BooMalo", personaje.obtenerModoActual().obtenerNombre());
		personaje.cambiarModo("BooOriginal");
		assertEquals("BooOriginal", personaje.obtenerModoActual().obtenerNombre());
	}
	
	@Test (expected = ExcepcionKiInsuficiente.class)
	public void test04cambiarModoBooMaloFalla(){
		MajinBoo personaje=new MajinBoo();
		personaje.aumentarKi(10);
		personaje.cambiarModo("BooMalo");
	}
	
	@Test (expected = ExcepcionKiInsuficiente.class)
	public void test05cambiarModoBooOriginalFalla(){
		MajinBoo personaje=new MajinBoo();
		personaje.aumentarKi(20);
		personaje.cambiarModo("BooOriginal");	
	}
	
	@Test
	public void test06cambiarModoFreezer(){
		Freezer personaje=new Freezer();
		personaje.aumentarKi(200);
		personaje.cambiarModo("SegundaForma");
		assertEquals("SegundaForma", personaje.obtenerModoActual().obtenerNombre());
		personaje.cambiarModo("Definitivo");
		assertEquals("Definitivo", personaje.obtenerModoActual().obtenerNombre());
	}
	
	@Test (expected = ExcepcionKiInsuficiente.class)
	public void test07cambiarModoFreezerSegundaFormaFalla(){
		Freezer personaje=new Freezer();
		personaje.aumentarKi(10);
		personaje.cambiarModo("SegundaForma");
	}
	
	@Test (expected = ExcepcionKiInsuficiente.class)
	public void test08cambiarModoFreezerDefinitivoFalla(){
		Freezer personaje=new Freezer();
		personaje.aumentarKi(20);
		personaje.cambiarModo("Definitivo");
	}
	
	@Test 
	public void test09cambiarModosCell(){
		Cell personaje = new Cell();
		Goku enemigo = new Goku();
		personaje.aumentarKi(40);
		personaje.atacarAPersonajeConAtaqueEspecial(enemigo);
		personaje.atacarAPersonajeConAtaqueEspecial(enemigo);
		personaje.atacarAPersonajeConAtaqueEspecial(enemigo);
		personaje.atacarAPersonajeConAtaqueEspecial(enemigo);
		personaje.cambiarModo("SemiPerfecto");
		assertEquals("SemiPerfecto", personaje.obtenerModoActual().obtenerNombre());
		personaje.atacarAPersonajeConAtaqueEspecial(enemigo);
		personaje.atacarAPersonajeConAtaqueEspecial(enemigo);
		personaje.atacarAPersonajeConAtaqueEspecial(enemigo);
		personaje.atacarAPersonajeConAtaqueEspecial(enemigo);
		personaje.cambiarModo("Perfecto");
		assertEquals("Perfecto", personaje.obtenerModoActual().obtenerNombre());
	}
	
	@Test(expected = ExcepcionAbsorcionesInsuficientes.class)
	public void test10cambiarModosSemiPerfectoCellFallaAbsorciones(){
		Cell personaje=new Cell();
		Goku enemigo=new Goku();
		personaje.aumentarKi(15);
		personaje.atacarAPersonajeConAtaqueEspecial(enemigo);
		personaje.atacarAPersonajeConAtaqueEspecial(enemigo);
		personaje.atacarAPersonajeConAtaqueEspecial(enemigo);
		personaje.cambiarModo("SemiPerfecto");
	}
	
}