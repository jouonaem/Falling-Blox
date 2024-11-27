package fr.eseo.e3.poo.projet.blox.controleur;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class PieceDeplacement extends MouseAdapter implements MouseMotionListener, MouseListener, MouseWheelListener{
	private VuePuits vuePuits;
	private Puits puits;
	private int derniereColonne;
	
	//Constructeur de PieceDeplacement
	public PieceDeplacement(VuePuits vuePuits) {
		//this.vuePuits.addMouseMotionListener(this);
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
		this.derniereColonne = -1;
	}
	
	public void setPuits(Puits puits) {
		this.puits = puits;
	}
	
	public void mouseMoved(MouseEvent event) {
		 if (vuePuits.getPuits().getPieceActuelle() != null) {
		        int colonneActuelle = event.getX()/vuePuits.getTaille();
		        
		        if (this.derniereColonne == -1) {
		            this.derniereColonne = colonneActuelle;
		        } 
		        if(colonneActuelle != this.derniereColonne)
		        	try {
		        		int deplacement = colonneActuelle - this.derniereColonne;
		        		
		        		if(deplacement>0)
		        			this.puits.getPieceActuelle().deplacerDe(1, 0);
		        		else if(deplacement<0) {
		        			this.puits.getPieceActuelle().deplacerDe(-1, 0);
		        		}
		        		this.derniereColonne = colonneActuelle;
				        this.vuePuits.repaint();
		        			
		        	}
		        
		        	catch(Exception ex){	
		        		throw new IllegalArgumentException("La piece est mal déplacée");	
		        	}
		       
		    }
		 this.vuePuits.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void mouseEntered( MouseEvent event ) {
		this.derniereColonne = -1 ;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent event) {
	    if (this.puits != null && puits.getPieceActuelle() != null) {
	        if (event.getWheelRotation() > 0) {
	        	puits.getPieceActuelle().deplacerDe(0,1); 
	            this.vuePuits.repaint();
	        }
	    }
	}
}
