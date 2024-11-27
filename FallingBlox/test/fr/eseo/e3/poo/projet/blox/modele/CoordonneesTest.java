package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {

	@Test
	void testConsructeur2() {
		//Instanciation des coordonnées
		Coordonnees c = new Coordonnees(3,4);
		
		//Tests du constructeur
		assertEquals(c.getAbscisse(),3,"La valeur de l'abscisse est 3");
		assertEquals(c.getOrdonnee(),4,"La valeur de l'ordonnée est 4");
	}
	
	@Test
	void testToString() {
		//Instanciation des coordonnées
		Coordonnees c = new Coordonnees(3,4);
		
		//Tests de classe
		assertEquals(c.toString(),"(3, 4)","Les coordonnées sont sensés être (3, 4)");
	}
	
	@Test
	void testEquals() {
		//Instanciation des coordonnées
		Coordonnees c = new Coordonnees(1,2);
		Coordonnees c1 = new Coordonnees(3,4);
		Coordonnees c2 = new Coordonnees(3,4);
		
		//Tests de classe
		assertFalse(c.equals(c1),"Les coordonnées sont égales");
		assertTrue(c1.equals(c2),"Les coordonnées ne sont pas égales");
	}
	
}
