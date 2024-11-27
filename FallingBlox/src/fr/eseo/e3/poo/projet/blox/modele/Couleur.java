package fr.eseo.e3.poo.projet.blox.modele;
import java.awt.Color;
public enum Couleur {
	ROUGE(java.awt.Color.RED),
	ORANGE(java.awt.Color.ORANGE),
	BLEU(java.awt.Color.BLUE),
	VERT(java.awt.Color.GREEN),
	JAUNE(java.awt.Color.YELLOW),
	CYAN(java.awt.Color.CYAN),
	VIOLET(java.awt.Color.MAGENTA);
	
	private final Color couleurPourAffichage;
	
	private Couleur(Color couleurPourAffichage) {
		this.couleurPourAffichage = couleurPourAffichage;
	}

	public Color getCouleurPourAffichage() {
		return couleurPourAffichage;
	}
}
