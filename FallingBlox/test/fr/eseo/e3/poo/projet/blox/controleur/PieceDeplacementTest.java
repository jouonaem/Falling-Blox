package fr.eseo.e3.poo.projet.blox.controleur;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import org.junit.jupiter.api.Test;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PieceDeplacementTest {

	public PieceDeplacementTest() {
		testConstructeurPuits();
		testConstructeurPuitsTaille();
	}
	@Test
	private void testConstructeurPuits() {
		//Instanciation de PieceDeplacement
		Puits puits = new Puits();
		VuePuits vuePuits = new VuePuits(puits,15);
		JFrame frame = new JFrame("Puits");
		vuePuits.setPuits(puits);
		frame.setSize(vuePuits.getPreferredSize());
		frame.setLocationRelativeTo(null);
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		vuePuits.getPuits().getPieceActuelle().setPosition(3, 3);
		vuePuits.repaint();
		frame.add(vuePuits);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	@Test
	private void testConstructeurPuitsTaille() {
		Puits puits = new Puits();
		JFrame frame = new JFrame("Puits et taille");
		VuePuits vuePuits = new VuePuits(puits,17);
		vuePuits.setPuits(puits);
		frame.setSize(vuePuits.getPreferredSize());
		frame.setLocationRelativeTo(null);
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		vuePuits.getPuits().getPieceActuelle().setPosition(3, 3);
		frame.add(vuePuits);
		vuePuits.repaint();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PieceDeplacementTest();
			}
		});
	}

}
