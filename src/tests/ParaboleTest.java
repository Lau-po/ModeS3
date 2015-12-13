package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import modele.Parabole;
import modele.Piaf;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test sur la courbe de type parabole
 *
 * @author Groupe N5
 */
public class ParaboleTest {
	Parabole p;

	/**
	 * Mise en place de l'objet test
	 */
	@Before
	public void setUp() {
		p = new Parabole();
	}

	/**
	 * Test les constantes
	 */
	@Test
	public void constantWellSaved() {
		assertEquals(p.getPas(), 0.001, 0);
	}

	/**
	 * Test si le reset fonctionne bien.
	 */
	@Test
	public void testReset() {
		p.go();
		p.reset();
		if (!p.getCourbe().isEmpty()) {
			fail("Reset ne fonctionne pas");
		}
		if (p.getObstacles().isEmpty()) {
			fail("Reset ne fonctionne pas");
		}
	}

	/**
	 * Verifie le parametrage du piaf
	 */
	@Test
	public void testPiaf() {
		p = new Parabole();
		if (!p.getPiaf().equals(new Piaf(0, 0, new Point(0, 0)))) {
			fail("Piaf diffÃ©rents");
		}
	}

	/**
	 * Test de la fonction go de parabole
	 */
	@Test
	public void testGo() {
		p = new Parabole();
		p.go();
		if(p.getObstacles().isEmpty() || p.getCourbe().isEmpty()){
			fail("erreur Ã  l'initialisation");
		}
	}
}
