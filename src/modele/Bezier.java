/**
 * Classe qui definit la courbe de Bezier
 * 
 * @author Groupe N5
 */

package modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bezier extends ObservableModele {

	/** Liste des points de contrôle de la courbe */
	private List<Point> ctrl;
	/** Le nombre de points pour la courbe */
	private double pas = 0.001;

	/**
	 * Constructeur de base
	 */
	public Bezier() {
		super();
		createPointCtrl();
		genObstacles();
	}

	/**
	 * Construit une courbe de Bezier avec un pas donne
	 * 
	 * @param pas
	 *            de la courbe
	 */
	public Bezier(double pas) {
		this();
		this.pas = pas;
	}

	/**
	 * @see Modele
	 */
	@Override
	public void go() {
		for (float i = 0; i <= 1 && !collision; i += pas) {
			courbe.add(createCurve(ctrl, i));
			oiseau.move(createCurve(ctrl, i).x, createCurve(ctrl, i).y,
					createCurve(ctrl, (float) (i + (10 * pas))));
			for (Obstacle o : obstacles) 
			{
				o.move();

			}
			setChanged();
			notifyObservers();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (collision) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				collision = false;
			}
		}
	}

	/**
	 * Fonction qui gere la creation des points de contrôle
	 */
	private void createPointCtrl() {
		ctrl = new ArrayList<Point>();
		Random r = new Random();
		ctrl.add(new Point(10, 490));
		ctrl.add(new Point((r.nextInt(20) + 50), r.nextInt(20) + 120));
		ctrl.add(new Point((r.nextInt(20) + 500), r.nextInt(20) + 120));
		ctrl.add(new Point(900, r.nextInt(150) + 150));
	}

	/**
	 * Fonction qui gere la creation de la courbe de Bezier
	 * 
	 * @param list_pdc
	 *            necessaire pour la courbe
	 * @param t
	 *            = le pas
	 * @return un point de la courbe à l'instant t
	 */
	private Point createCurve(List<Point> list_pdc, float t) {
		ArrayList<Point> list_pv = new ArrayList<Point>();
		if (list_pdc.size() - 1 == 0) {
			return list_pdc.get(0);
		}
		for (int i = 0; i < list_pdc.size() - 1; i++) {
			int x = (int) ((1 - t) * list_pdc.get(i).getX() + t
					* list_pdc.get(i + 1).getX());
			int y = (int) ((1 - t) * list_pdc.get(i).getY() + t
					* list_pdc.get(i + 1).getY());
			list_pv.add(new Point(x, y));
		}
		return createCurve(list_pv, t);
	}

	/**
	 * Fonction qui genere les obstacles
	 */
	void genObstacles() {
		super.genObstacles();
	}

	/**
	 * @see Modele
	 */
	@Override
	public void reset() {
		createPointCtrl();
		obstacles = new ArrayList<Obstacle>();
		genObstacles();
		courbe = new ArrayList<>();
	}

}
