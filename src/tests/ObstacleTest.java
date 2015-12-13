package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import modele.Obstacle;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test sur les obstacles
 *
 * @author Groupe N5
 */
public class ObstacleTest {
	Obstacle O;

	/**
	 * Mise en place de l'objet testé
	 */
	@Before
	public void setUp() {
		O = new Obstacle(50, 55, 10);
	}

	/**
	 * Test du getter Size
	 */
	@Test
	public void testSize() {
		O.setSize(15);
		assertEquals(15, O.getSize());
	}
	
	/**
	 * Test du getter Y
	 */
	@Test
	public void testGetY() {
		assertEquals(55, O.getY(),0);
	}
	

	/**
	 * Test du getter X
	 */
	@Test
	public void testGetX() {
		assertEquals(50, O.getX(),0);
	}
	
	/**
	 * Verifie la collision avec les l'obstables
	 */
	@Test
	public void testTouched() {
		boolean tmp = O.isTouched();
		O.setTouched(false);
		assertFalse(O.isTouched());
		O.setTouched(tmp);
	}
	
	/**
	 * Verifie si les Obstacles se deplacent normalement
	 */
	@Test
	public void testMove() {
		O.move(20, 20);
		if(O.getX() != 20 || O.getY() != 20){
			fail("Move don't work");
		}
		O.move(50,55);
	}
	
	/**
	 * Test le parametrage de la couleur
	 */
	@Test
	public void testColor(){
		O.setC(Color.BLUE);
		if(!O.getC().equals(Color.BLUE)){
			fail("Wrong color");
		}
	}
	
	/**
	 * Test le parametrage de la mobilite de l'obstacle
	 */
	@Test
	public void testMobilite(){
		O.setBougeant(true);
		assertTrue(O.isBougeant());
	}
}
