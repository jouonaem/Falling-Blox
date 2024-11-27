package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TasTest {

	@Test
	void testConstructeur2() {
		//Instanciation de Tas
		Puits puits = new Puits();
		Tas t = new Tas(puits,4);
		assertNotNull(t);
		assertEquals(puits,t.getPuits());
		assertEquals(t.getElements().size(),4,"Le nombre d'élements ne correspond pas!");
	}
	
	@Test
	void testConstructeur3() {
		//Instanciation de Tas
		Puits puits = new Puits();
		Tas t = new Tas(puits,4,3);
		assertNotNull(t);
		assertEquals(puits,t.getPuits());
		assertEquals(t.getElements().size(),4,"Le nombre d'élements ne correspond pas!");
		//assertEquals();
	}

}
