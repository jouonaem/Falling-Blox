package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PuitsTest {

	@Test
   void testConstructeurParDefaut() {
		//Instanciation d'un Puits
		Puits puits = new Puits();
		
		//Attribution des largeurs et profondeurs par défaut
		puits.setLargeur(5);
		puits.setProfondeur(15);
		
		//Tests du constructeur
		assertEquals(puits.getLargeur(),5,"La largeur par défaut est de 5");
		assertEquals(puits.getProfondeur(),15,"La profondeur par défaut est de 15");
	}
	
	@Test
	void testConstructeur() {
		//Instanciation d'un Puits
		Puits puits = new Puits(8,17);
		
		//Tests du Constructeur
		assertEquals(puits.getLargeur(),8,"La largeur est de 8");
		assertEquals(puits.getProfondeur(),17,"La profondeur est de 8");
	}
	
	@Test
	void testToString() {
		//Instanciation d'un Puits
		Puits puits = new Puits(8,17);
		
		//Test de la méthode
		String s = "Puits : Dimension 8 x 17\nPiece Actuelle : <aucune>\nPiece Suivante : <aucune>\n";
		assertEquals(puits.toString(),s);
	}
}
