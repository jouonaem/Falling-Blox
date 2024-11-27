package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

public class OTetrominoTest {

	@Test
	public void testConstructeur() {
		//Instanciation de OTetromino
		Puits puis = new Puits();
		OTetromino o = new OTetromino(new Coordonnees(3,1),Couleur.JAUNE);
		o.setPuits(puis);
		
		//Tests du contructeur
		assertNotNull(o.getPuits(),"Le puits n'a pas été créé il est null");
		assertEquals(o.getElements()[0].getCoordonnees(),new Coordonnees(3,1),"Les coordonnées sont (3, 1)");
		assertEquals(o.getElements()[0].getCouleur(),Couleur.JAUNE,"La couleur est JAUNE");
	}
	
	@Test
	public void testToString() {
		//Instanciation de OTeromino
		OTetromino o = new OTetromino(new Coordonnees(3,1),Couleur.VERT);
		String s = "OTetromino :\n\t(3, 1) - VERT\n\t(3, 0) - VERT\n\t(4, 0) - VERT\n\t(4, 1) - VERT\n";
		
		//Tests de la méthode toString()
		assertEquals(o.getElements()[0].getCoordonnees(),new Coordonnees(3,1),"Les coordonnées sont (3, 1)");
		assertEquals(o.getElements()[1].getCoordonnees(),new Coordonnees(3,0),"Les coordonnées sont (3, 0)");
		assertEquals(o.getElements()[2].getCoordonnees(),new Coordonnees(4,0),"Les coordonnées sont (4, 0)");
		assertEquals(o.getElements()[3].getCoordonnees(),new Coordonnees(4,1),"Les coordonnées sont (4, 1)");
		assertEquals(o.toString(),s);
	}
	
	@Test
	public void testDeplacerDe() {
		//Instanciation de OTetromino
		Puits puits = new Puits();
		OTetromino o = new OTetromino(new Coordonnees(3,1),Couleur.BLEU);
		o.setPuits(puits);
		
		//Déplacements
		o.deplacerDe(0,0);
		
		//Tests de déplacement
		assertNotNull(o.getPuits(),"Le puits n'a pas été créé il est null");
		assertEquals(o.getElements()[0].getCoordonnees(), new Coordonnees(3,1), "Les coordonnées sont inchangées");
		assertEquals(o.getElements()[1].getCoordonnees(), new Coordonnees(3,0), "Les coordonnées sont inchangées");
		assertEquals(o.getElements()[2].getCoordonnees(), new Coordonnees(4,0), "Les coordonnées sont inchangées");
		assertEquals(o.getElements()[3].getCoordonnees(), new Coordonnees(4,1), "Les coordonnées sont inchangées");
	}
	
	@Test
	public void testTourner() {
		//Insantiation d'un OTetromino
		Puits puits = new Puits();
		OTetromino o = new OTetromino(new Coordonnees(3,1),Couleur.VERT);
		OTetromino o1 = new OTetromino(new Coordonnees(2,1),Couleur.VERT);
		o.setPuits(puits);
		o.tourner(false);
		o1.setPuits(puits);
		o1.tourner(true);
		
		//Tests de la méthode
		assertEquals(o.getElements()[1].getCoordonnees(),new Coordonnees(3,1),"Un OTetromino ne tourne pas!");
		assertEquals(o1.getElements()[1].getCoordonnees(),new Coordonnees(2,1),"Un OTetromino ne tourne pas!");
	}
}
