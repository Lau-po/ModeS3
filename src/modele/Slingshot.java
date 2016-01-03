package modele;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import controller.Controller;

@SuppressWarnings("serial")
public class Slingshot extends Point {
	/** Couleur du point d'envoi */
	private Color c = Color.darkGray;
	/** Taille du point */
	private int width;
	private int height;
	/** Position du Point d'envoi */
	private double[] position = new double[] { 130.0, 320.0 };
	/** Position de l'oiseau avant envoi */
	private double[] mousePosition = new double[] { 130.0, 320.0 };
	/** Validation du lancement de l'oiseau */
	private boolean launch = false;
	/** Validation de la zone de lancement*/
	private boolean inCube = false;
	/* Validation de l'appui */
	private boolean isPressed = false;	
	private ObservableModele modele;

	/**
	 * Ecoute des clicks
	 */
	private MouseAdapter clickListener = new MouseAdapter() {

		@Override
		public void mouseReleased(MouseEvent e) {
			if (!isLaunched()) {
				isPressed = false;
				if (inCube) {
					setLaunchValue(true);					
					System.out.println("Launched\n vector : "+getVector()[0]+","+getVector()[1] + "\n Position : "+position[0]+","+position[1]);
				}
				System.out.println("Released");
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (!isLaunched()) {
				isPressed = true;
				System.out.println("Pressed");
			}
			System.out.println(e.getX()+","+e.getY());
		}
	};

	/**
	 * Ecoute du mouvement du curseur
	 */
	private MouseMotionListener moveListener = new MouseMotionListener() {

		@Override
		public void mouseMoved(MouseEvent e) {}

		@Override
		public void mouseDragged(MouseEvent e) {
			if (!isLaunched()) {
				if (isPressed) {
					if (e.getX() <= 130/* && e.getY() > 320)*/) {
						setPosition(((double) e.getX()), ((double) e.getY()));
						inCube = true;
					} else {
						inCube = false;
					}
					System.out.println("Value Changed");
				}
				mousePosition[0] = e.getX();
				mousePosition[1] = e.getY();
				//System.out.println(position[0] + "," + position[1]);
			}
		}

	};

	/**
	 * Default Constructor
	 */
	public Slingshot() {
		super(130, 150);
		this.width = 10;
		this.height = 200;
		this.modele = modele;
	}

	/**
	 * @param x
	 * @param y
	 * @param size
	 */
	public Slingshot(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	/**
	 * @return MouseAdapter of slingshot
	 */
	public MouseAdapter getCliker() {
		return clickListener;
	}

	/**
	 * @return Motion Listener of slingshot
	 */
	public MouseMotionListener getMove() {
		return moveListener;
	}

	/**
	 * Retourne la couleur du point
	 * 
	 * @return couleur du point
	 */
	public Color getC() {
		return c;
	}

	/**
	 * Donne la couleur au point de départ
	 * 
	 * @param c
	 */
	private void setC(Color c) {
		this.c = c;
	}

	/**
	 * Retourne la taille du point
	 * 
	 * @return la taille du point
	 */
	public int[] getSize() {
		return new int[]{width,height};
	}

	/**
	 * Donne la taille au point de départ
	 * 
	 * @param size
	 */
	private void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * Retourne la position [x;y] du point
	 * 
	 * @return position du point [x;y]
	 */
	public double[] getPosition() {
		return position;
	}

	/**
	 * Donne la position [x;y] au point de départ
	 * 
	 * @param position
	 *            [x;y]
	 */
	private void setPosition(double x, double y) {
		this.position[0] = x;
		this.position[1] = y;
	}

	/**
	 * Retourne la position [x;y] du curseur
	 * 
	 * @return int[x;y]
	 */
	public double[] getMousePosition() {
		return mousePosition;
	}

	/**
	 * Donne une value [x;y] au curseur
	 * 
	 * @param mousePosition
	 */
	@SuppressWarnings("unused")
	private void setMousePosition(double[] mousePosition) {
		this.mousePosition = mousePosition;
	}

	/**
	 * @return si le click a été effectué, ou pas
	 */
	public boolean isLaunched() {
		return launch;
	}

	/**
	 * @return si le curseur est la le cube, ou pas
	 */
	public boolean isInCube() {
		return inCube;
	}
	
	/**
	 * Donne la valeur à lauch
	 * 
	 * @param launch
	 */
	public void setLaunchValue(boolean launch) {
		this.launch = launch;
	}

	/**
	 * recupere le vecteur de force du slingshot
	 * @return une force [x;y]
	 */
	public double[] getVector() {
		double[] vector = new double[] { 0.0, 0.0 };
		vector[0] = this.getX() - position[0]+3;
		vector[1] = -(this.getY()+184 - position[1]);
		return vector;
	}
	
	/**
	 * Revalide le Slingshot
	 */
	public void reloadSlingshot(){
		inCube = false;
		launch = false;
		position = new double[] { 130.0, 320.0 };
		mousePosition = new double[] { 130.0, 320.0 };
	}
}
