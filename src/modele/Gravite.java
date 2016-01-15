package modele;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.util.ArrayList;

import javax.swing.Timer;

import resources.Constants;
import vue.StartPanel;

public class Gravite extends ObservableModele implements ActionListener {

	/** Constate gravitationnel */
	private double g = Constants.GRAVITY_EARTH;
	/** pas de la simulation */
	private double dt = 0.01;
	/** vecteur position */
	private double[] position = new double[] { 130.0, 150.0 };
	private double oldPosition =  0.0;
	private double lastTop = 0.0;
	/** vecteur vitesse */
	private double[] vitesse = new double[] { 0.0, 0.0 };
	private double[] oldVitesse = new double[] { -10.0, -10.0 };
	/** coefficients pour les frottements de l'air pour l'oiseau */
	private double k = Constants.K;
	/** coefficients pour les frottements de l'air pour les obstacles */
	private double kObstacles = Constants.K_OBSTACLE;
	/** poids de l'oiseau */
	private double poidsOiseau = Constants.PDS_OISEAU;
	/** poids des obstacles */
	private double poidsObstacle = Constants.PDS_OBSTACLE;
	private Timer t;
	
	
	/**
	 * Constructeur de base
	 */
	public Gravite() {
		super();
		genObstacles();
	}

	/**
	 * @see Modele
	 */
	@Override
	public void go() {
		g = getP().getGravity();
		oiseau.setLocation(new Point(130,150));
		t = new Timer(1, this);
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//if (isChoosed()) {
			launchPad();
			if (position[1] >= 0 && slingshot.isLaunched()) {
				for (Obstacle obstacle : obstacles) {
					acceleration(obstacle);
					deplacement(obstacle);
				}
				//System.out.println(oiseau.getX() + "  " + oiseau.getY());
				acceleration();
				deplacement();
				courbe.add(new Point((int) position[0], (int) position[1]));
				oiseau.setLocation(position[0], position[1]);
				setChanged();
				notifyObservers();
				checkIfDone();
				// done = false;
			}
		//}
		// else {
		// done = true;
		// t.stop();
		// }
	}

	public void setVitesse(double x, double z) {
		oldVitesse[0] = vitesse[0];
		oldVitesse[1] = vitesse[1];
		vitesse[0] = x;
		vitesse[1] = z;
		
	}

	/**
	 * @see Modele
	 */
	@Override
	public void reset() {
		slingshot.reloadSlingshot();
		courbe = new ArrayList<Point>();
		obstacles = new ArrayList<>();
		position = new double[] { 130.0, 150.0 };
		vitesse = new double[] { 90.0, 100.0 };
		genObstacles();
		collision = false;
		done = false;
		setChoosed(false);
		k = 0.001;
	}

	/**
	 * Calcul la vitesse de proche en proche
	 */
	private void acceleration() {
		double dx = vitesse[0];
		double dz = vitesse[1];
		dz = dz + dt * (-g) - k * vitesse[1];
		dx = dx - k * vitesse[0];
		vitesse[0] = dx;
		vitesse[1] = dz;
	}

	/**
	 * Calcul la position de proche en proche
	 */
	private void deplacement() {
		double x = position[0];
		double z = position[1];
		oldPosition = position[1];
		double dx = vitesse[0];
		double dz = vitesse[1];
		x = x + dx * dt;
		z = z + dz * dt;
		position[0] = x;
		position[1] = z;
		if(oldPosition > position[1]){
			lastTop =oldPosition;
		}
	}

	/**
	 * Calcul la vitesse de proche en proche pour l'obstacle passer en parametre
	 * 
	 * @param obstacle
	 *            l'obstacle qui doit se deplacer
	 */
	private void acceleration(Obstacle obstacle) {
		double dx = obstacle.getVitesse()[0];
		double dz = obstacle.getVitesse()[1];
		if (obstacle.getMoveZ()) {
			dz = dz + dt * (-g);
		}
		if (obstacle.isTouched()) {
			// subit les frottements de l'air
			dz -= kObstacles * obstacle.getVitesse()[1];
			dx -= kObstacles * obstacle.getVitesse()[0];
		}
		obstacle.setVitesse(dx, dz);
	}

	/**
	 * Calcul la position de proche en proche pour l'obstacle passer en
	 * parametre
	 * 
	 * @param obstacle
	 *            l'obstacle qui doit se deplacer
	 */
	private void deplacement(Obstacle obstacle) {
		double x = obstacle.getPosition()[0];
		double z = obstacle.getPosition()[1];
		double dx = obstacle.getVitesse()[0];
		double dz = obstacle.getVitesse()[1];
		if (obstacle.getMoveX()) {
			x = x + dx * dt;
		}
		if (obstacle.getMoveZ()) {
			z = z + dz * dt;
		}
		obstacle.setPosition(x, z);
	}

	/**
	 * inverse l'axe Y
	 * 
	 * @param y
	 * @return
	 */
	public int inverse(int y) {
		return -y + 470;
	}

	/**
	 * @param d
	 */
	public void setK(double d) {
		this.k = d;
	}

	/**
	 * @return
	 */
	public double getK() {
		return k;
	}

	/**
	 * verifie si la simulation doit se terminer c�d si l'oiseau est sur le
	 * sol et ne rebondit plus
	 */
	private void checkIfDone() {
		if (vitesse[0] > -0.05 && vitesse[0] < 0.05 && vitesse[1] > -1 && vitesse[1] < 1) {
				done = true;
				t.stop();
		}
	}


	/**
	 * @see Modele
	 */
	@Override
	public void collision(Obstacle o) {
		double[] vg = new double[] {
				(poidsOiseau * vitesse[0] + poidsObstacle * o.getVitesse()[0])
						/ (poidsObstacle + poidsOiseau),
				(poidsOiseau * vitesse[1] + poidsObstacle * o.getVitesse()[1])
						/ (poidsObstacle + poidsOiseau) };
			setVitesse(2 * vg[0] - vitesse[0], 2 * vg[1] - vitesse[1]);
		o.setVitesse(2 * vg[0] - o.getVitesse()[0], 2 * vg[1]- o.getVitesse()[1]);
	}

	/**
	 * @see Modele
	 */
	@Override
	public void collision(Obstacle o1, Obstacle o2) {
		double[] vg = new double[] {
				(poidsObstacle * o1.getVitesse()[0] + poidsObstacle* o2.getVitesse()[0])/ (poidsObstacle + poidsObstacle),
				(poidsObstacle * o1.getVitesse()[1] + poidsObstacle* o2.getVitesse()[1])/ (poidsObstacle + poidsObstacle)
				};
		o1.setVitesse(2 * vg[0] - o1.getVitesse()[0],2 * vg[1] - o1.getVitesse()[1]);
		o2.setVitesse(2 * vg[0] - o2.getVitesse()[0],2 * vg[1] - o2.getVitesse()[1]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.ObservableModele#collisionSol()
	 */
	@Override
	public void collisionSol() {
		double[] vg = new double[] {
				(poidsOiseau * vitesse[0]) / (Double.MAX_VALUE),
				(poidsOiseau * vitesse[1]) / (Double.MAX_VALUE) };
		if(vitesse[1] > 2*vg[1]){
			vg[1] = vg[1]*1+(vitesse[1]-vg[1]);
		}
		setVitesse((2 * vg[0] + vitesse[0])*0.9, (2 * vg[1] - vitesse[1])*0.7);
		System.out.println(vitesse[0] + " " + vitesse[1]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.ObservableModele#collisionSol(modele.Obstacle)
	 */
	@Override
	public void collisionSol(Obstacle o) {
		double[] vg = new double[] {
				(poidsObstacle * o.getVitesse()[0]) / (Double.MAX_VALUE),
				(poidsObstacle * o.getVitesse()[1]) / (Double.MAX_VALUE) };
		o.setVitesse((2 * vg[0] + o.getVitesse()[0])*0.9, (1.5 * vg[1]	- o.getVitesse()[1])*0.7);
	}

	public void setG(double g) {
		this.g = g;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.ObservableModele#launchPad()
	 */
	@Override
	public void launchPad() {
		double tempX = 0.0;
		double tempY = 0.0;
		if (!slingshot.isLaunched()) {
			vitesse[0] = slingshot.getVector()[0] * 1.3;
			vitesse[1] = slingshot.getVector()[1] * 1.3;
			if (slingshot.getMousePosition()[0] != tempX
					|| slingshot.getMousePosition()[1] != tempY) {
				setChanged();
			}
			hasChanged();
			notifyObservers();
		}
		tempX = slingshot.getMousePosition()[0];
		tempY = slingshot.getMousePosition()[1];
	}

}
