package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import modele.Piaf;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test relatif à l'oiseau (ici Piaf)
 * 
 * @author Groupe N5
 */
public class PiafTest {
	Piaf p;
	
	/**
	 * Mise en place de l'objet test
	 */
	@Before
	public void setUp(){
		p = new Piaf(20,10,new Point(15,15));		
	}
	
	/**
	 * Verifie la reponse de GetX
	 */
	@Test
	public void testGetX(){
		assertEquals(20.00, p.getX(),0);
	}
	
	/**
	 * Verifie la reponse de getY()
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
			fail("X diffÃ©rent de la valeur attendue");
		}
		if(p.getY() != 20.00){
			fail("Y diffÃ©rent de la valeur attendue");
		}
	}
	
	/**
	 * Verifie si la detection de collision fonctionne
	 */
	@Test
	public void testTouched(){
		if(p.isTouched()){
			fail("Le piaf ne devrai pas Ãªtre touchÃ©");			
		}
		p.setTouched(true);
		if(!p.isTouched()){
			fail("Le piaf devrai Ãªtre touchÃ©");			
		}
	}
	

	/**
	 * Verifie si le bec est bien retourne
	 */
	@Test
	public void testGetBec(){
		assertTrue(!p.getBec().equals(new Point(20,20)));
	}
}
