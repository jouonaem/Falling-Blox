package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element {
	private Coordonnees coordonnees;
	private Couleur couleur;
	
	//Constructeurs de la classe Element
	public Element(Coordonnees coordonnees) {
		this(coordonnees, Couleur.ROUGE);
	}
	public Element(int abscisse, int ordonnee) {
		this(new Coordonnees(abscisse,ordonnee));
	}
	public Element(Coordonnees coordonnees, Couleur couleur) {
		this.coordonnees = coordonnees;
		this.couleur = couleur;
	}
	public Element(int abscisse, int ordonnee, Couleur couleur) {
		this(new Coordonnees(abscisse, ordonnee), couleur); 	}
	
	//Accesseurs et Mutateurs de coordonnees et couleur
	public Coordonnees getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}
	public Couleur getCouleur() {
		return couleur;
	}
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	public int getAbscisse() {
		return coordonnees.getAbscisse();
	}
	public void setAbscisse(int abscisse) {
		coordonnees.setAbscisse(abscisse);
	}
	public int getOrdonnee() {
		return coordonnees.getOrdonnee();
	}
	public void setOrdonnee(int ordonnee) {
		coordonnees.setOrdonnee(ordonnee);
	}
	public void deplacerDe(int deltaX, int deltaY){
		setAbscisse(getAbscisse()+deltaX);
		setOrdonnee(getOrdonnee()+deltaY);
	}
	
	//Méthodes de classe
	public String toString() {
		return "("+this.getAbscisse()+", "+this.getOrdonnee()+") - "+this.getCouleur();
	}
	@Override
	public int hashCode() {
		return Objects.hash(coordonnees, couleur);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		return Objects.equals(coordonnees, other.coordonnees) && couleur == other.couleur;
	}
	
}
