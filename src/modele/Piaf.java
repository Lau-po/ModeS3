/**
 * Classe qui gère l'oiseau et son comportement
 * 
 * @author Groupe N5
 */

package modele;

import java.awt.Color;
import java.awt.Point;

@SuppressWarnings("serial")
public class Piaf extends Point {
  /** Bec lié à l'oiseau */
  private Bec bec;
  /** Si l'oiseau est touché ou non */
  private boolean touched;
  /** La couleur de l'oiseau */
  private Color c = Color.red;

  /**
   * Constructeur de base
   * 
   * @param x coordonnee verticale de l'oiseau
   * @param y coordonnee horizontale de l'oiseau
   * @param pointe_bec de l'oiseau
   */
  public Piaf(int x, int y, Point pointe_bec) {
    super(x, y);
    this.bec = new Bec(this, pointe_bec);
    this.touched = false;
  }

  /**
   * Fonction qui gère le mouvement de l'oiseau
   * 
   * @param x coordonnee verticale de l'oiseau
   * @param y coordonnee horizontale de l'oiseau
   * @param pointe_bec de l'oiseau
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
   * @param touched ou non
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
}
