package fr.eseo.e3.poo.projet.blox.modele;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.ArrayList;
import java.beans.PropertyChangeListener;
public class Puits {
	public static final int LARGEUR_PAR_DEFAUT = 5;
	public static final int PROFONDEUR_PAR_DEFAUT = 15;
	public static final String MODIFICATION_PIECE_ACTUELLE = "Modification piece actuelle";
	public static final String MODIFICATION_PIECE_SUIVANTE = "Modification piece suivante";
	private int largeur;
	private int profondeur;
	private Piece pieceActuelle;
	private Piece pieceSuivante;
	private PropertyChangeSupport pcs;
	private Tas tas;
	private List<Element> elements;
	
	//Constructeurs de la classe Puits
	public Puits() {
		this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
	}
	public Puits(int largeur, int profondeur) {
		if((largeur<5 || largeur>15) && (profondeur<15 || profondeur>25)) {
			throw new IllegalArgumentException("The value is out of bounds");
		}
		this.setLargeur(largeur);
		this.setProfondeur(profondeur);
		this.pieceActuelle = null;
		this.pieceSuivante = null;
		this.pcs = new PropertyChangeSupport(this);
		this.elements = new ArrayList<Element>();
	}
	public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {
		if((largeur<5 || largeur>15) && (profondeur<15 || profondeur>25)) {
			throw new IllegalArgumentException("The value is out of bounds");
		}
		this.setLargeur(largeur);
		this.setProfondeur(profondeur);
		this.pieceActuelle = null;
		this.pieceSuivante = null;
		this.pcs = new PropertyChangeSupport(this);
		this.elements = new ArrayList<Element>();
		tas = new Tas(this);
	}
	//Accesseurs et Mutateurs de la largeur, profondeur et des pièces
	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		if(largeur<5 || largeur>15) {
			throw new IllegalArgumentException("The value is out of bounds");
		}
		this.largeur = largeur;
	}

	public int getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(int profondeur) {
		if(profondeur<15 || profondeur>25) {
			throw new IllegalArgumentException("The value is out of bounds");
		}
		this.profondeur = profondeur;
	}
	public Piece getPieceSuivante() {
		return pieceSuivante;
	}
	public Piece getPieceActuelle() {
		return pieceActuelle;
	}
	public void setPieceSuivante(Piece piece) {
		if(this.pieceSuivante!=null) {
			pieceActuelle = pieceSuivante;
			pieceActuelle.setPosition(getLargeur()/2, -4);
			pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE,null,this.pieceActuelle);
		}
		pieceSuivante = piece;
		pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, this.pieceActuelle, this.pieceSuivante);
	}
	
	public Tas getTas() {
		return tas;
	}
	public void setTas(Tas tas) {
		this.tas = tas;
	}
	//Méthode d'affichage textuelle
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
        builder.append("Puits : Dimension ").append(largeur).append(" x ").append(profondeur).append("\n");
        builder.append("Piece Actuelle : ").append(pieceActuelle != null ? pieceActuelle.toString() : "<aucune>\n");
        builder.append("Piece Suivante : ").append(pieceSuivante != null ? pieceSuivante.toString() : "<aucune>\n");

        return builder.toString();
	}
	
	//Autres Méthodes
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
}
