package tests;
import modele.*;
import java.awt.Point;
import static org.junit.Assert.*;

import org.junit.Test;

public class BecTest {
 
	/**
	 * Vérifie la réponse de GetPointeX
	 */
	@Test
	public void testGetPointeX() {
		Bec testBec = new Bec(new Point(10,10),new Point(10,15));
		assertEquals(10.00, testBec.getPointe().getX(),00.00);
	}
	
	/**
	 * Vérifie la réponse de GetPointY
	 */
	@Test
	public void testGetPointeY() {
		Bec testBec = new Bec(new Point(10,10),new Point(10,15));
		assertEquals(15.00, testBec.getPointe().getY(),00.00);
	}
	
	/**
	 * Vérifie si SetPointe fonctionne
	 */
	@Test
	public void testSetPointe() {
		Bec testBec = new Bec(new Point(10,10),new Point(10,15));
		testBec.setPointe(new Point(15,20));
		assertEquals(15.00, testBec.getPointe().getX(),00.00);
		assertEquals(20.00, testBec.getPointe().getY(),00.00);
	}

}
