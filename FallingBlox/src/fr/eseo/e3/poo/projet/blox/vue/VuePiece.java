package fr.eseo.e3.poo.projet.blox.vue;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import java.awt.Color;
import java.awt.Graphics2D;
import fr.eseo.e3.poo.projet.blox.modele.Element;
public class VuePiece {
	public static final double MULTIPLIER_TEINTE = 0.3;
	private final int taille;
	private final Piece piece;
	
	public VuePiece(Piece piece, int taille) {
		this.piece = piece;
		this.taille = taille;
	}
	
	public static Color teinte(Color couleur) {
	    int r = couleur.getRed();
	    int g = couleur.getGreen();
	    int b = couleur.getBlue();

	    r = (int) (r + (255 - r) * MULTIPLIER_TEINTE);
	    g = (int) (g + (255 - g) * MULTIPLIER_TEINTE);
	    b = (int) (b + (255 - b) * MULTIPLIER_TEINTE);

	    r = Math.min(255, r);
	    g = Math.min(255, g);
	    b = Math.min(255, b);

	    return new Color(r, g, b);
	}
	
	public void afficherPiece(Graphics2D g2D) {
	    Element[] elements = piece.getElements(); 
	    g2D.setColor(teinte(elements[0].getCouleur().getCouleurPourAffichage()));
	    g2D.fill3DRect(elements[0].getAbscisse()*taille, elements[0].getOrdonnee()*taille, taille, taille, true);
	    Color c = elements[0].getCouleur().getCouleurPourAffichage();
	    
	    g2D.setColor(c);
	    for (int i = 1; i < elements.length; i++) {
	        Element element = elements[i];
		    g2D.fill3DRect(element.getAbscisse()*taille, element.getOrdonnee()*taille, taille, taille, true);
	    }
	}
}
