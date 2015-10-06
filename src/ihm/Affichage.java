package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Affichage {
	/** Hauteur de la fenêtre **/
	int hauteur;
	/** Largeur de la fenêtre **/
	int largeur;
	JFrame mainWindow;
	/** Liste des points de contrôle **/
	List<Point> list_pdc;
	/** Debug **/
	boolean debug = true;
	
	/**
	 * Constructeur principal 
	 * @param hauteur = hauteur de la fenêtre
	 * @param longueur = longueur de la fenêtre
	 */
	public Affichage(int largeur, int hauteur) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		mainWindow = new JFrame("AngryCode");
		mainWindow.setLocationRelativeTo(null);
		//mainWindow.setPreferredSize(new Dimension(largeur,hauteur));
		mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainWindow.setContentPane(new JPanel());
		mainWindow.getContentPane().setBackground(Color.white);
		mainWindow.pack();
		mainWindow.setVisible(true);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/** Initialisation des variables **/
		list_pdc = new ArrayList<Point>();
	}
	
	public void afficheCourbe(List<Point> courbe) {
		for (Point point : courbe) {
			new AfficherPoint(mainWindow.getGraphics(),point,Color.red);
		}
	}

	public int getSc_hauteur() {
		return hauteur;
	}

	public void setSc_hauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getSc_largeur() {
		return largeur;
	}

	public void setSc_largeur(int largeur) {
		this.largeur = largeur;
	}
}
