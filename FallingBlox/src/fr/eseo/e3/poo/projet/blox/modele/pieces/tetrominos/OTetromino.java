package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
public class OTetromino extends Tetromino {
	
	//Constructeur de OTetromino
	public OTetromino(Coordonnees coordonnees, Couleur couleur) {
		super(coordonnees,couleur);
	}

	protected void setElements(Coordonnees coordonnees, Couleur couleur) {
		getElements()[0] = new Element(new Coordonnees(coordonnees.getAbscisse(),coordonnees.getOrdonnee()),couleur);
		getElements()[1] = new Element(new Coordonnees(coordonnees.getAbscisse(),coordonnees.getOrdonnee()-1),couleur);
		getElements()[2] = new Element(new Coordonnees(coordonnees.getAbscisse()+1,coordonnees.getOrdonnee()-1),couleur);
		getElements()[3] = new Element(new Coordonnees(coordonnees.getAbscisse()+1,coordonnees.getOrdonnee()),couleur);
	}
	
	@Override
	public void tourner(boolean sensHoraire) {}
}
