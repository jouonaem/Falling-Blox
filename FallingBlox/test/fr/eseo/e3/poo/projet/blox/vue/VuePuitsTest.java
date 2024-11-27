package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import org.junit.jupiter.api.Test;

public class VuePuitsTest {

	@Test
	void testConstructeur1() {
		//Instanciation de VuePuits
		Puits p = new Puits();
		VuePuits v = new VuePuits(p);
		
		//Tests du constructeur
		assertEquals(v.getPuits(),p,"Le puits n'est pas correct");
	}
	
	@Test
	void testConstructeur2() {
		//Instantiation de VuePuits
		Puits p = new Puits();
		VuePuits v = new VuePuits(p,30);
		
		//Tests du constructeur
		assertEquals(v.getPuits(),p,"Le puits n'est pas correct");
		assertEquals(v.getTaille(),30,"La taille en pixels est de 30");
	}

}
