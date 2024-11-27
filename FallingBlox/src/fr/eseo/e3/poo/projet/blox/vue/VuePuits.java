package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuits extends JPanel implements PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_PAR_DEFAUT = 25;
	private Puits puits;
	private int taille;
	private VuePiece vuePiece;
	private PieceDeplacement pieceDep;
	private PieceRotation pieceRot;

	// Constructeur de VuePuits
	public VuePuits(Puits puits) {
		this(puits, TAILLE_PAR_DEFAUT);
	}

	public VuePuits(Puits puits, int taille) {
		pieceDep = new PieceDeplacement(this);
		pieceRot = new PieceRotation(this);
		this.setPuits(puits);
		this.setTaille(taille);
		this.setPreferredSize(new Dimension(puits.getLargeur() * taille, puits.getProfondeur() * taille));
		setBackground(Color.WHITE);
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
		setPreferredSize(new Dimension(puits.getLargeur() * taille, puits.getProfondeur() * taille));
	}

	public Puits getPuits() {
		return puits;
	}

	public void setPuits(Puits puits) {
		if (this.puits != null) {
			this.puits.removePropertyChangeListener(this);
		}
		if (pieceDep != null) {
			this.removeMouseMotionListener(pieceDep);
			this.removeMouseListener(pieceDep);
			this.removeMouseWheelListener(pieceDep);
			
			
			this.removeMouseListener(pieceRot);
			
			
		}
		this.puits = puits;
		this.puits.addPropertyChangeListener(this);
		// this.pieceDep = new PieceDeplacement(this);
		this.pieceDep.setPuits(getPuits());
		this.pieceRot.setPuits(getPuits());
		// motionListeners.add(pieceDep);
		this.addMouseListener(pieceDep);
		this.addMouseListener(pieceRot);
		this.addMouseMotionListener(pieceDep);
		this.addMouseWheelListener(pieceDep);
		setPreferredSize(new Dimension(puits.getLargeur() * taille, puits.getProfondeur() * taille));
	}

	public VuePiece getVuePiece() {
		return vuePiece;
	}

	private void setVuePiece(VuePiece vuePiece) {
		this.vuePiece = vuePiece;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g.create();

		g2D.setColor(Color.LIGHT_GRAY);
		for (int row = 0; row < this.puits.getLargeur(); row++) {
			for (int col = 0; col < this.puits.getProfondeur(); col++) {
				g2D.drawRect(row * taille, col * taille, taille, taille);
			}
		}
		if (vuePiece != null) {
			vuePiece.afficherPiece(g2D);
		}
		g2D.dispose();

	}

	public void propertyChange(PropertyChangeEvent event) {
		System.out.println("1");
		if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
			System.out.println("2");
			setVuePiece(new VuePiece((Piece) event.getNewValue(), this.taille));
		}
		repaint();
	}
}
