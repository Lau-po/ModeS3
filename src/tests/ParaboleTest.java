package tests;

import static org.junit.Assert.*;

import modele.Parabole;

import org.junit.Before;
import org.junit.Test;

public class ParaboleTest {
	Parabole p;

	/**
	 * Setting up tests
	 */
	@Before
	public void setUp() {
		p = new Parabole();
	}
	
	/**
	 * Test les constantes
	 */
	@Test
	public void constantWellSaved(){
		assertEquals(p.getPas(),0.001,0);
	}

}
