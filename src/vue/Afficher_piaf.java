/**
 * Classe qui génère l'affiche de l'oiseau
 * @author Groupe N5
 */


package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import modele.Piaf;

@SuppressWarnings("serial")
public class Afficher_piaf extends JPanel {
	
	/** Coordonnée de l'oiseau*/
	private Point coord;

	/**
	 * Construit un affichage d'un Obstacle
	 * @param g = le Graphics de la fenetre
	 * @param coord = le point a afficher
	 * @param color = la couleur de l'obstacle
	 */
	public Afficher_piaf(Graphics g, Piaf coord, Color color) {
		super();
		g.setColor(Color.white);
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.black);
		g.fillPolygon(new int[]{coord.x,coord.x,coord.getBec().getPointe().x},new int[]{coord.y+8,coord.y-8,coord.getBec().getPointe().y}, 3);
		Color c = g.getColor();
		this.coord = coord;
		g.setColor(color);
		g.fillOval(coord.x-(20/2),coord.y-(20/2),20,20);
		g.setColor(c);
	}
	
	/**
	 * Fonction qui obtient la coordonnée horizontale de l'oiseau
	 */
	@Override
	public int getX() {
		return this.coord.x;
	}

	/**
	 * Fonction qui obtient la coordoonée verticale de l'oiseau.
	 */
	@Override
	public int getY() {
		return this.coord.y;
	}
}