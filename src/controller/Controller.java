/**
 * Classe controleur. Fait le lien entre la vue et les modeles.
 * @author Groupe N5
 */

package controller;

import java.awt.Point;
import java.util.List;
import java.util.Observer;

import modele.Modele;
import modele.Obstacle;


public class Controller {

	/** Modele lie au controleur */
	private Modele modele;
	/** Observeur lie au controleur */
	@SuppressWarnings("unused")
	private Observer observer;
	/** Liste des points de la courbe */
	private List<Point> courbe;
	/** Liste des obstacles */
	private List<Obstacle> obstacles;

	/**
	 * Calcul s'il y a une collision entre la courbe et les obstacles du modele.
	 * Stop la simulation si besoin.
	 */
	public void collision() {
		this.courbe = modele.getCourbe();
		this.obstacles = modele.getObstacles();
		Obstacle o;
		for (Point point : courbe) {
			if (point.getX() > 400) {
				for (int i = 0; i < obstacles.size(); i++) {
					o = obstacles.get(i);
					if (!o.isTouched()) {
						if (point.getX()-20/2 < o.getX() + (o.getSize()/2) && point.getX()+20/2 > o.getX() - (o.getSize())/ 2) {
							if (point.getY()-20/2 < o.getY() + (o.getSize()/ 2) && point.getY()+20/2 > o.getY() - (o.getSize()/ 2)) {
								System.out.println("collision");
								o.setTouched(true);
								modele.setCollision(true);
							}
						}
					}
				}
			}
		}

	}

	/**
	 * Definit le modele.
	 * @param modele que le controller doit controler.
	 */
	public void setModele(Modele modele) {
		this.modele = modele;
	}

	/**
	 * Definit l'observateur.
	 * @param observer du modele.
	 */
	public void setObserver(Observer observer) {
		this.observer = observer;
	}
}