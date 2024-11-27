package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

public class ITetrominoTest {

	@Test
	void testConstructeur() {
		//Instanciation de ITetromino
		ITetromino itetro = new ITetromino(new Coordonnees(1,3),Couleur.ORANGE);
		Puits puits = new Puits();
		itetro.setPuits(puits);
		
		//Tests du Constructeur
		assertNotNull(itetro.getPuits(),"Le puits n'a pas été créé il est null");
		assertEquals(itetro.getElements()[0].getCoordonnees(),new Coordonnees(1,3),"Les coordonnées sont (1, 3)");
		assertEquals(itetro.getElements()[0].getCouleur(),Couleur.ORANGE,"La couleur est Orange");
	}
	
	@Test
	void testDeplacerDe() {
		//Instanciation de ITetromino
		ITetromino itetro = new ITetromino(new Coordonnees(1,3),Couleur.VIOLET);
		Puits puits = new Puits();
		itetro.setPuits(puits);
		
		//Déplacements
		itetro.deplacerDe(0, 0);
		
		//Tests de la méthode
		assertNotNull(itetro.getPuits(),"Le puits n'a pas été créé il est null");
		assertEquals(itetro.getElements()[0].getCoordonnees(), new Coordonnees(1,3), "Les coordonnées sont inchangées");
		assertEquals(itetro.getElements()[1].getCoordonnees(), new Coordonnees(1,2), "Les coordonnées sont inchangées");
		assertEquals(itetro.getElements()[2].getCoordonnees(), new Coordonnees(1,1), "Les coordonnées sont inchangées");
		assertEquals(itetro.getElements()[3].getCoordonnees(), new Coordonnees(1,4), "Les coordonnées sont inchangées");
	}
	
	@Test
	public void testTourner() {
		//Insantiation d'un OTetromino
		Puits puits = new Puits();
		ITetromino itetro = new ITetromino(new Coordonnees(1,3),Couleur.VERT);
		ITetromino itetro1 = new ITetromino(new Coordonnees(2,1),Couleur.VERT);
		itetro.setPuits(puits);
		itetro1.setPuits(puits);
		
		itetro.tourner(false);
		itetro1.tourner(true);
		
		//Tests de la méthode
		assertEquals(itetro.getElements()[1].getCoordonnees(),new Coordonnees(2,3),"Le ITetromino n'est pas correctement tourné");
		assertEquals(itetro1.getElements()[1].getCoordonnees(),new Coordonnees(1,1),"Le ITetromino n'est pas correctement tourné");
	}
}
