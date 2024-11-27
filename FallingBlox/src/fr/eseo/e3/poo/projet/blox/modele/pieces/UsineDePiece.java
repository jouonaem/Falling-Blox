package fr.eseo.e3.poo.projet.blox.modele.pieces;
import java.util.Random;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;

public class UsineDePiece {
	public static final int ALEATOIRE_COMPLET = 1;
	public static final int ALEATOIRE_PIECE = 2;
	public static final int CYCLIC = 0;
	static int modeParDefaut = ALEATOIRE_PIECE;
	private static int cyclique;
	
	//Constructeur par défaut vide
	private UsineDePiece() {}
	
	//Méthodes et mutateurs
	public static void setMode(int mode) {
		UsineDePiece.modeParDefaut = mode;
	}
	/*
	 * ANTI-PLAGIAT : une partie de la méthode genererTetromino
	 * est basé sur le travail de KEITA Daniel
	 */
	public static Tetromino genererTetromino() {
		Tetromino t = null;
		  int type = 0;
		    
		    switch (modeParDefaut) {
		        case CYCLIC:
		            type = cyclique;
		            cyclique = (cyclique + 1) % 2;
		            break;
		        case ALEATOIRE_COMPLET:
		        	Random rand = new Random();
		            type = rand.nextInt(2);
		            break;
		        case ALEATOIRE_PIECE:
		            type = 0;
		            break;
		    }
		    
		    // Création du Tetromino en fonction du type choisi
		    if (type == 0) {
		        t = new OTetromino(new Coordonnees(2,3), Couleur.ROUGE);
		    } else {
		        t = new ITetromino(new Coordonnees(2,3), Couleur.ORANGE);
		    }
		return t;
	}
}
