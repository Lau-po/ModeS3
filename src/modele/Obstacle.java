/**
 * Classe qui gère les obstacles et leurs comportements
 * @author Groupe N5
 */

package modele;

import java.awt.Color;
import java.awt.Point;

@SuppressWarnings("serial")
public class Obstacle extends Point {

	/** Obstacle touché ou non*/
	private boolean touched;
	/** Couleur des obstacles*/
	private Color c = Color.red;
	/** Taille des obstacles*/
	private int size;

	/**
	 * Constructeur de base
	 * @param x coordonnee x de l'obstacle
	 * @param y coordonnee y de l'obstacle
	 */
	public Obstacle(int x, int y,int size) {
		super(x, y);
		this.touched = false;
		this.size = size;
	}

	/**
	 * Fonction qui détermine si un obstacle est touché
	 * @return si l'obstacle est touché ou non
	 */
	public boolean isTouched() {
		return touched;
	}

	/**
	 * Fonction qui indique qu'un obstacle est touché
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
	 * @return la couleur de l'obstacle
	 */
	public Color getC() {
		return c;
	}

	/**
	 * Fonction qui obtient la taille des obstacles
	 * @return size
	 */
	public int getSize() {
		return size;
	}
}
