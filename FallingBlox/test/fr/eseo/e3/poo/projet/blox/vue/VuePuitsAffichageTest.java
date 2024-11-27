package fr.eseo.e3.poo.projet.blox.vue;

//import static org.junit.jupiter.api.Assertions.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import javax.swing.SwingUtilities;
import java.beans.PropertyChangeListener;

public class VuePuitsAffichageTest {

	@Test
	private void testConstructeurPuits() {
		 Puits puits = new Puits();
		    VuePuits vuePuits = new VuePuits(puits);
		    puits.addPropertyChangeListener((PropertyChangeListener) vuePuits);
		    Tetromino piece = UsineDePiece.genererTetromino();
		    VuePiece vuePiece = new VuePiece(piece, 14);
		    //vuePuits.setVuePiece(vuePiece);

		    SwingUtilities.invokeLater(() ->  {
		    	JFrame frame = new JFrame("Puits");
		    	frame.setSize(vuePuits.getPreferredSize());
		    frame.setLocationRelativeTo(null);
		    frame.getContentPane().add(vuePuits);
		    frame.pack();
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);});
	}
	
	@Test
	private void testConstructeurPuitsTaille() {
		    int taille = 50; // Taille spécifiée pour VuePuits
		    Puits puits = new Puits();
		    VuePuits vuePuits = new VuePuits(puits, taille);
		    puits.addPropertyChangeListener((PropertyChangeListener) vuePuits);
		    Tetromino piece = UsineDePiece.genererTetromino();
	        VuePiece vuePiece = new VuePiece(piece, taille);
	        //vuePuits.setVuePiece(vuePiece);
	        
		    SwingUtilities.invokeLater(() ->  {
		    	JFrame frame = new JFrame("Puits et taille");
		    	frame.setSize(vuePuits.getPreferredSize());
		    frame.setLocationRelativeTo(null);
		    frame.getContentPane().add(vuePuits);
		    frame.pack();
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);});
	}
	
	 public static void main (String [] args) {
		VuePuitsAffichageTest t = new VuePuitsAffichageTest();
		t.testConstructeurPuits();
		t.testConstructeurPuitsTaille();
		 }
}
