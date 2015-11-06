/**
 * Classe qui gère l'affichage des points de la courbe
 * @author Groupe N5
 */

package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AfficherPoint extends JPanel {

	/** Coordonnée du point*/
	private Point coord;

	/**
	 * Constructeur de base
	 * @param g= le Graphics d'une fenetre
	 * @param coord = le point a afficher
	 * @param color = la couleur du point a afficher
	 */
	public AfficherPoint(Graphics g, Point coord, Color color) {
		this(g, coord, color, 5);
	}

	/**
	 * Construit un affichage d'un point avec une certaine taille
	 * @param g = le Graphics de la fenetre
	 * @param coord = le point a afficher
	 * @param color = la couleur du point a afficher
	 * @param taille = la taille du point a afficher
	 */
	public AfficherPoint(Graphics g, Point coord, Color color, int taille) {
		super();
		Color c = g.getColor();
		this.coord = coord;
		g.setColor(color);
		g.fillOval(coord.x - (taille / 2), coord.y - (taille / 2), taille,
				taille);
		g.setColor(c);
	}
	
	/**
	 * Fonction qui obtient la coordonnée horizontale d'un point
	 */
	@Override
	public int getX() {
		return this.coord.x;
	}

	/**
	 * Fonction qui obtient la coordonnée verticale d'un point
	 */
	@Override
	public int getY() {
		return this.coord.y;
	}
}