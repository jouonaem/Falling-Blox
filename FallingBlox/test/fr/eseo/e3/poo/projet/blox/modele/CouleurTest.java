package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.awt.Color;
public class CouleurTest {

	@Test
	public void testCouleurPourAffichage() {
	        Couleur couleur = Couleur.ROUGE;
	        Color couleurAffichage = couleur.getCouleurPourAffichage();
	        assertNotNull(couleurAffichage);
	        assertEquals(Color.RED, couleurAffichage);
	    }

}
