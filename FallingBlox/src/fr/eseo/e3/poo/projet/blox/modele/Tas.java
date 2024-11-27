package fr.eseo.e3.poo.projet.blox.modele;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Tas {
	private Puits puits;
	private int nbElements;
	private int nbLignes;
	private List<Element> elements;
	
	public Tas(Puits puits) {
		this.puits = new Puits();
		this.elements = new ArrayList<Element>();
	}
	
	public Tas(Puits puits, int nbElements) {
		this.puits = new Puits();
		this.elements = new ArrayList<Element>();
		Random rand = new Random();
		nbLignes = nbElements / puits.getLargeur() +1;
		this.construireTas(nbElements, nbLignes, rand);
	}
	
	public Tas(Puits puits, int nbElements, int nbLignes) {
		this.puits = new Puits();
		this.elements = new ArrayList<Element>();
		Random rand = new Random();
		this.construireTas(nbElements, nbLignes, rand);
	}
	
	public Tas(Puits puits, int nbElements, int nbLignes, Random rand) {
		this.puits = new Puits();
		this.elements = new ArrayList<Element>();
		this.construireTas(nbElements, nbLignes, rand);
	}
	

	public Puits getPuits() {
		return puits;
	}

	public List<Element> getElements() {
		return elements;
	}
	
	/*
	 * ANTI-PLAGIAT : La deuxième partie de la méthode
	 * construireTas est inspiré du travail de Maldini DIFFO
	 */
	private void construireTas(int nbElements, int nbLignes, Random rand) {
		if(nbElements !=0 && nbElements>=puits.getLargeur()*nbLignes) {
			throw new IllegalArgumentException("Number of elemnts doesn't fit");
		}
		int nbElemPlaces = 0;
		if(nbElements != 0) {
			while(nbElemPlaces<nbElements) {
				int ordon = puits.getProfondeur() - rand.nextInt(nbLignes)+1;
				int absci = rand.nextInt(puits.getLargeur());
				if(!elementExists(absci,ordon)) {
					int indiceCouleur = rand.nextInt(7);
					elements.add(new Element(absci,ordon,Couleur.values()[indiceCouleur]));
					nbElemPlaces++;
				}
			}
		}
	}
	
	public boolean elementExists(int a, int b) {
		for(Element element : elements) {
			if(element!=null) {
				if(element.getCoordonnees().getAbscisse()==a && element.getCoordonnees().getOrdonnee()==b) {
					return true;
				}
			}
		}
		return false;
	}
}
