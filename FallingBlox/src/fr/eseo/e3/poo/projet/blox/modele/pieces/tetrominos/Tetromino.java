package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public abstract class Tetromino implements Piece {
	private Element[] elements;
	private Puits puits;
	
	//Constructeur de Tetromino
	public Tetromino(Coordonnees coordonnees, Couleur couleur) {
		this.elements = new Element[4];
		this.setElements(coordonnees, couleur);
		this.puits = null;
	}

	//Accesseur et Mutateur de Elements
	public Element[] getElements() {
		return elements;
	}

	protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);
	
	public void deplacerDe(int deltaX, int deltaY) {
		if ((deltaX< -1 || deltaX>1) || (deltaY < 0 ||deltaY >1))
			throw new IllegalArgumentException("Déplacement invalide");
		
		for(Element elements:getElements()) {
			elements.deplacerDe(deltaX, deltaY);
		}
		
			
	}
	
	public void tourner(boolean sensHoraire) {
		 Coordonnees ref = elements[0].getCoordonnees(); 
		   
		    for (Element element : elements) {
		        if (element != elements[0]) { 
		            int relAbscisse = element.getCoordonnees().getAbscisse() - ref.getAbscisse(); 
		            int relOrdonnee = element.getCoordonnees().getOrdonnee() - ref.getOrdonnee();
		            
		            if (sensHoraire) {
		                // Rotation dans le sens horaire
		            	int newX = ref.getAbscisse() - relOrdonnee;
		                int newY = ref.getOrdonnee() + relAbscisse;
		                element.setCoordonnees(new Coordonnees(newX, newY));
		            } else {
		                // Rotation dans le sens anti-horaire
		            	int newX = ref.getAbscisse() + relOrdonnee;
			            int newY = ref.getOrdonnee() - relAbscisse;
		                element.setCoordonnees(new Coordonnees(newX, newY));
		            }
		        }
		    }
	}

	//Mutateur de Position
	public void setPosition(int abscisse, int ordonnee) {
		this.setElements(new Coordonnees(abscisse,ordonnee), this.getElements()[0].getCouleur());
	}
	
	public Puits getPuits() {
		return puits;
	}

	public void setPuits(Puits puits) {
		//if(puits!=null)
		this.puits = puits;
	}
	

	//Méthodes de la classe
	public String toString() {
		String s = super.getClass().getSimpleName() + " :\n";
		for(Element e : elements) {
			s+="\t"+ e +"\n";             //e.toString();
		}
		return s;
	}
}
