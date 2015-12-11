/**
 * Classe qui gère les obstacles et leurs comportements
 * 
 * @author Groupe N5
 */

package modele;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

@SuppressWarnings("serial")
public class Obstacle extends Point {

	/** Obstacle touché ou non */
	private boolean touched;
	/** Couleur des obstacles */
	private Color c = Color.red;
	/** Taille des obstacles */
	private int size;
	/** indique si l'obstacle est de type mouvant */
	boolean bougeant;

	/**
	 * Constructeur de base
	 * 
	 * @param x
	 *            coordonnee x de l'obstacle
	 * @param y
	 *            coordonnee y de l'obstacle
	 */
	public Obstacle(int x, int y, int size) {
		super(x, y);
		this.touched = false;
		this.size = size;
		this.bougeant = new Random().nextBoolean();
	}

	/**
	 * Bouge l'obstacle
	 */
	public void move() {
		if (bougeant) {
			int new_x = this.x;
			int new_y = this.y;

			// TODO switch pr direction sur var a crée
			new_x--;
			new_y--;

			super.move(new_x, new_y);
		}
	}

	/**
	 * Fonction qui détermine si un obstacle est touché
	 * 
	 * @return si l'obstacle est touché ou non
	 */
	public boolean isTouched() {
		return touched;
	}

	/**
	 * Fonction qui indique qu'un obstacle est touché
	 * 
	 * @param touched
	 */
	public void setTouched(boolean touched) {
		this.touched = touched;
		if (touched) {
			c = Color.YELLOW;
		} else {
			c = Color.red;
		}
	}

	/**
	 * @see modele.Modele
	 */
	@Override
	public double getX() {
		return super.getX();
	}

	/**
	 * @see modele.Modele
	 */
	@Override
	public double getY() {
		return super.getY();
	}

	/**
	 * Fonction qui obtient la couleur des obstacles
	 * 
	 * @return la couleur de l'obstacle
	 */
	public Color getC() {
		return c;
	}

	/**
	 * Fonction qui obtient la taille des obstacles
	 * 
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Fonction qui vérifie si l'obstacle peut bouger
	 * 
	 * @return si l'osbtacle peut bouger, ou pas
	 */
	public boolean isBougeant() {
		return bougeant;
	}

	/**
	 * Rend l'obstacle mobile, ou pas
	 * 
	 * @param bougeant
	 */
	public void setBougeant(boolean bougeant) {
		this.bougeant = bougeant;
	}

	/**
	 * Donne une couleur c à l'obstacle
	 * 
	 * @param c
	 */
	public void setC(Color c) {
		this.c = c;
	}

	/**
	 * Donne la taile size à l'obstacle
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}
}
