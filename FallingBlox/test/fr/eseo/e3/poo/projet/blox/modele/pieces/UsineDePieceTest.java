package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
public class UsineDePieceTest {

	@Test
	void testSetMode() {
		//Attribution d'un mode de fonctionement
		UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
		//Tests de la méthode
		assertEquals(UsineDePiece.modeParDefaut,UsineDePiece.ALEATOIRE_COMPLET,"La valeur récupérée dans setMode() n'est pas correct");
	}
	
	@Test
	void testGenererTetromino() {
		//Instanciation d'un tetromino pour l'UsineDePiece
		Tetromino t = UsineDePiece.genererTetromino();
		
		//Tests de vérification de renvoi d'un Tetromino non null
		assertNotNull(t,"Le Tetromino généré est null");
	}

}
