package tests;

import static org.junit.Assert.*;

import modele.Bezier;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test relatif à la courbe de bezier
 * @author Inconnu
 *
 */
public class BezierTest {
	Bezier bezier;

	/**
	 * Mise en place du test
	 */
	@Before
	public void setUp() {
		bezier = new Bezier();
	}

	/**
	 * Verification du remplissage ds valeurs
	 */
	@Test
	public void testGo() {
		bezier.go();
		if (bezier.getCourbe().isEmpty() && bezier.getObstacles().isEmpty()) {
			fail("Liste non renseignÃ©es");
		}
	}

	/**
	 * Verification du reset des valeurs
	 */
	@Test
	public void testReset() {
		bezier = new Bezier();
		bezier.go();
		bezier.reset();

		if (!bezier.getCourbe().isEmpty() && !bezier.getObstacles().isEmpty()) {
			fail("Les listes ne sont pas remise Ã  0");
		}
	}
}
