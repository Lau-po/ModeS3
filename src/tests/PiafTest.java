package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import modele.Piaf;

import org.junit.Before;
import org.junit.Test;

public class PiafTest {
	Piaf p;
	
	/**
	 * Setting up tests
	 */
	@Before
	public void setUp(){
		p = new Piaf(20,10,new Point(15,15));		
	}
	
	/**
	 * Verifie la réponse de GetX
	 */
	@Test
	public void testGetX(){
		assertEquals(20.00, p.getX(),0);
	}
	
	/**
	 * Vérifie la réponse de getY()
	 */
	@Test
	public void testGetY(){
		assertEquals(10.00, p.getY(),0);
	}
	
	/**
	 * Verifie si la fonction de mouvement fonctionne
	 */
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
	
	/**
	 * Vérifie si la détection de collision fonctionne
	 */
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
	

	/**
	 * Vérifie si le bec est bien retourné
	 */
	@Test
	public void testGetBec(){
		assertTrue(!p.getBec().equals(new Point(20,20)));
	}
}
