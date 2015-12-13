package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import resources.Constants;

/**
 * Classe de test sur les constantes
 * 
 * @author Groupe N5
 */
public class ConstantsTest {
	Constants C;
	
	/**
	 * Mise en place du test
	 */
	@Before
	public void setUp(){
		C = new Constants();
	}

	/**
	 * Test sur le fichier prop
	 */
	@Test
	public void Contantstest() {
		if(Constants.NBR_SIMULATION != 10){
			fail("NBR_SIMULTAION != in prop file");
		}
		if(Constants.PAS != 0.001){
			fail("PAS != in prop file");
		}
		// Nouvelles constantes Ã  venir fail du test en attendant//
		fail("Not all constants are added yet!");
	}

}
