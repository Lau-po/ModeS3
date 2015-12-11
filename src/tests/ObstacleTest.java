package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import modele.Obstacle;

import org.junit.Before;
import org.junit.Test;

public class ObstacleTest {
	Obstacle O;

	/**
	 * Setting up tests before testing all other one
	 */
	@Before
	public void setUp() {
		O = new Obstacle(50, 55, 10);
	}

	/**
	 * Test size of the Obstacle
	 */
	@Test
	public void testGetSize() {
		assertEquals(10, O.getSize());
	}
	
	/**
	 * Test if GetY is right
	 */
	@Test
	public void testGetY() {
		assertEquals(55, O.getY(),0);
	}
	
	
	/**
	 * Test if GetC is right
	 */
	@Test
	public void testGetC() {
		if(!O.getC().equals(Color.RED)){
			fail("Wrong color");
		}
	}

	/**
	 * Test if GetX is right
	 */
	@Test
	public void testGetX() {
		assertEquals(50, O.getX(),0);
	}
	
	/**
	 * Vérifie la collision avec les l'obstables
	 */
	@Test
	public void testTouched() {
		boolean tmp = O.isTouched();
		O.setTouched(false);
		assertFalse(O.isTouched());
		O.setTouched(tmp);
	}
	
	/**
	 * Vérifie si les Obstacles se déplacent normalement
	 */
	@Test
	public void testMove() {
		O.move(20, 20);
		if(O.getX() != 20 || O.getY() != 20){
			fail("Move don't work");
		}
		O.move(50,55);
	}
}
