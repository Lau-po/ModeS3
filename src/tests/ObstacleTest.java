package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import modele.Obstacle;

import org.junit.Before;
import org.junit.Test;

public class ObstacleTest {
	Obstacle O;

	@Before
	public void setUp() {
		O = new Obstacle(50, 55, 10);
	}

	@Test
	public void testGetSize() {
		assertEquals(10, O.getSize());
	}
	
	@Test
	public void testGetY() {
		assertEquals(55, O.getY(),0);
	}
	
	@Test
	public void testGetC() {
		if(!O.getC().equals(Color.RED)){
			fail("Wrong color");
		}
	}

	@Test
	public void testGetX() {
		assertEquals(50, O.getX(),0);
	}
	
	@Test
	public void testTouched() {
		O.setTouched(false);
		assertFalse(O.isTouched());
	}
	
	
	@Test
	public void testMove() {
		O.move(20, 20);
		if(O.getX() != 20 || O.getY() != 20){
			fail("Move don't work");
		}
	}
}
