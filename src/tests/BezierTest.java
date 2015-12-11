package tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import modele.Bezier;

import org.junit.Before;
import org.junit.Test;

public class BezierTest {
	Bezier bezier;

	/**
	 * Setting up tests
	 */
	@Before
	public void setUp() {
		bezier = new Bezier();
	}

	/**
	 * Vérification du remplissage ds valeurs
	 */
	@Test
	public void testGo() {
		bezier.go();
		if (bezier.getCourbe().isEmpty() && bezier.getObstacles().isEmpty()) {
			fail("Liste non renseignées");
		}
	}

	/**
	 * Vérification du reset des valeurs
	 */
	@Test
	public void testReset() {
		bezier = new Bezier();
		bezier.go();
		bezier.reset();

		if (!bezier.getCourbe().isEmpty() && !bezier.getObstacles().isEmpty()) {
			fail("Les listes ne sont pas remise à 0");
		}

	}

}
