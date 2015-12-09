package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import modele.Piaf;

import org.junit.Before;
import org.junit.Test;

public class PiafTest {
	Piaf p;
	
	@Before
	public void setUp(){
		p = new Piaf(20,10,new Point(15,15));		
	}
	
	@Test
	public void testGetX(){
		assertEquals(20.00, p.getX(),0);
	}
	
	@Test
	public void testGetY(){
		assertEquals(10.00, p.getY(),0);
	}
	
	@Test
	public void testMove() {
		p.move(15, 20, new Point(20,20));
		if(p.getX() != 15.00){
			fail("X différent de la valeur attendue");
		}
		if(p.getY() != 20.00){
			fail("Y différent de la valeur attendue");
		}
	}
	
	@Test
	public void testTouched(){
		if(p.isTouched()){
			fail("Le piaf ne devrai pas être touché");			
		}
		p.setTouched(true);
		if(!p.isTouched()){
			fail("Le piaf devrai être touché");			
		}
	}
	

	@Test
	public void testGetBec(){
		assertTrue(!p.getBec().equals(new Point(20,20)));
	}
}
