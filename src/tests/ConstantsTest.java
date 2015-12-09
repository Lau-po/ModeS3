package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import resources.Constants;

public class ConstantsTest {
	Constants C;
	@Before
	public void setUp(){
		C = new Constants();
	}

	@Test
	public void Contantstest() {
		if(Constants.NBR_SIMULATION != 10){
			fail("NBR_SIMULTAION != in prop file");
		}
		if(Constants.PAS != 0.001){
			fail("PAS != in prop file");
		}
		// Nouvelles constantes à venir fail du test en attendant//
		fail("Not all constants are added yet!");
	}

}
