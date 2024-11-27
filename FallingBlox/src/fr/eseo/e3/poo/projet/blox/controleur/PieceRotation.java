package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotation extends MouseAdapter{
	private Puits puits;
	private VuePuits vuePuits; 
	
	public PieceRotation(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
	}
	
	public void setPuits(Puits puits) {
		this.puits = puits;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		 if (e.getButton() == MouseEvent.BUTTON1) {
	            vuePuits.getPuits().getPieceActuelle().tourner(false);
	        } else if (e.getButton() == MouseEvent.BUTTON3) {
	            vuePuits.getPuits().getPieceActuelle().tourner(true);
	        }
	}
	
}
