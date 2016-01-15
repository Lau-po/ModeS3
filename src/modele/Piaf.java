/**
 * Classe qui gère l'oiseau et son comportement
 * 
 * @author Groupe N5
 */

package modele;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import resources.Constants;

@SuppressWarnings("serial")
public class Piaf extends Point {
	/** Bec lié à l'oiseau */
	private Bec bec;
	/** Si l'oiseau est touché ou non */
	private boolean touched;
	/** La couleur de l'oiseau */
	private Color c = Color.red;
	private double oldPX;
	private double oldPY;
	private int size = Constants.TAILLE_PIAF;
	private BufferedImage image;
	AffineTransformOp op;

	public int size() {
		return size;
	}

	/**
	 * Constructeur de base
	 * 
	 * @param x
	 *            coordonnee verticale de l'oiseau
	 * @param y
	 *            coordonnee horizontale de l'oiseau
	 * @param pointe_bec
	 *            de l'oiseau
	 */
	public Piaf(int x, int y, Point pointe_bec) {
		super(x, y);
		this.bec = new Bec(this, pointe_bec);
		this.touched = false;
		try {
			image = ImageIO.read(new File("src/resources/piaf.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Piaf(int x, int y) {
		super(x, y);
	}
	
	public void setPosition(double x, double y){
		oldPX = this.getX();
		oldPY = this.getY();
		super.setLocation(x, y);
	}
	
	

	public double getOldPX() {
		return oldPX;
	}

	public void setOldPX(double oldPX) {
		this.oldPX = oldPX;
	}

	public double getOldPY() {
		return oldPY;
	}

	public void setOldPY(double oldPY) {
		this.oldPY = oldPY;
	}

	/**
	 * Fonction qui gère le mouvement de l'oiseau
	 * 
	 * @param x
	 *            coordonnee verticale de l'oiseau
	 * @param y
	 *            coordonnee horizontale de l'oiseau
	 * @param pointe_bec
	 *            de l'oiseau
	 */
	public void move(int x, int y, Point pointe_bec) {
		super.move(x, y);
		bec.setPointe(pointe_bec);
	}

	/**
	 * Fonction qui détermine si l'oiseau est touché
	 * 
	 * @return si l'oiseau est touche ou non
	 */
	public boolean isTouched() {
		return touched;
	}

	/**
	 * Fonction qui indique si l'oiseau est touché
	 * 
	 * @param touched
	 *            ou non
	 */
	public void setTouched(boolean touched) {
		this.touched = touched;
		if (touched) {
			c = Color.YELLOW;
		} else {
			c = Color.green;
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
	 * Fonction pour obtenir la couleur de l'oiseau
	 * 
	 * @return la couleur de l'oiseau
	 */
	public Color getC() {
		return c;
	}

	/**
	 * 
	 * @return le Bec
	 */
	public Bec getBec() {
		return bec;
	}

	/**
	 * Vérifie la l'equalité du piaf
	 * @param piaf
	 * @return si le piaf est identique, ou pas
	 */
	public boolean equals(Piaf piaf) {
		if (this.getBec().equals(piaf.getBec())) {
			if ((this.isTouched() && piaf.isTouched())
					|| (!this.isTouched() && !piaf.isTouched())) {
				if (this.getC().equals(piaf.getC())) {
					if (this.getLocation().equals(piaf.getLocation())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public BufferedImage getImage(){
		return image;
	}
}
