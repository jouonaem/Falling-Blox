package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ElementTest {

	@Test
	public void testConstructeur1() {
		//Instanciation de Element
		Element e = new Element(new Coordonnees(1,2));
		
		//Tests du constructeur à un paramètre
		assertEquals(e.getCouleur(),Couleur.ROUGE,"La couleur par défaut est ROUGE");
		assertEquals(e.getCoordonnees(),new Coordonnees(1,2),"Les coordonnees données sont (1, 2)");
	}
	
	@Test
	public void testConstructeur2() {
		//Instanciation de Element
		Element e = new Element(3,4);
		
		//Test du constructeur à 2 paramètres
		assertEquals(e.getAbscisse(),3,"L'abscisse donné est 3");
		assertEquals(e.getOrdonnee(),4,"L'ordonnee donné est 4");
		assertEquals(e.getCouleur(),Couleur.ROUGE,"La couleur par défaut est ROUGE");
	}
	
	@Test
	public void testConstructeur3() {
		//Instanciation de Element
		Element e = new Element(new Coordonnees(2,3),Couleur.CYAN);
		
		//Tests du constructeur de couleurs et coordonnées
		assertEquals(e.getCoordonnees(),new Coordonnees(2,3),"Les coordonnées données sont (2, 3)");
		assertEquals(e.getCouleur(),Couleur.CYAN,"La couleur donnée est le CYAN");
	}
	
	@Test
	public void testConstructeur4() {
		//Instanciation de Element
		Element e = new Element(1,2,Couleur.BLEU);
		
		//Tests du constructeur à 3 paramètres
		assertEquals(e.getAbscisse(),1,"L'abscisse donné est 1");
		assertEquals(e.getOrdonnee(),2,"L'ordonnee donné est 2");
		assertEquals(e.getCouleur(),Couleur.BLEU,"La couleur par défaut est BLEU");
	}
	
	@Test
	public void testToString() {
		//Instanciation des Elements
		Element e = new Element(new Coordonnees(1,2));
		Element e1 = new Element(3,4);
		Element e2 = new Element(new Coordonnees(2,3),Couleur.CYAN);
		Element e3 = new Element(1,2,Couleur.BLEU);
		
		//Attribution des abscisses et ordonnées de e et e2
		e.setAbscisse(1);
		e.setOrdonnee(2);
		e2.setAbscisse(2);
		e2.setOrdonnee(3);
		
		//Tests de classe 
		assertEquals(e.toString(),"(1, 2) - ROUGE","Le résultat attendu est (1, 2) - ROUGE");
		assertEquals(e1.toString(),"(3, 4) - ROUGE","Le résultat attendu est (3, 4) - ROUGE");
		assertEquals(e2.toString(),"(2, 3) - CYAN","Le résultat attendu est (2, 3) - CYAN");
		assertEquals(e3.toString(),"(1, 2) - BLEU","Le résultat attendu est (1, 2) - BLEU");
	}
	
	@Test
	public void testDeplacerDe() {
		//Instanciation des Elements
		Element e = new Element(new Coordonnees(3,3));
		Element e1 = new Element(new Coordonnees(3,3));
		
		//Valeurs de déplacement sur l'axe des abscisses
		e.deplacerDe(-2, 0);
		e1.deplacerDe(2, 0);
		
		//valeurs de déplacement sur l'axe des ordonnées
		e.deplacerDe(0, -2);
		e1.deplacerDe(0, 2);
		
		//Tests de la méthode
		assertEquals(e.getAbscisse(),1,"L'abscisse de déplacement à gauche est de 1");
		assertEquals(e1.getAbscisse(),5,"L'abscisse de déplacement à droite est de 5");
		assertEquals(e.getOrdonnee(),1,"L'ordonnée du déplacement vers le haut est de 1");
		assertEquals(e1.getOrdonnee(),5,"L'ordonnée du déplacement vers le bas est de 5");
	}

}
