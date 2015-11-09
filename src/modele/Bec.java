/**
 * Classe qui definit le bec.
 * 
 * @author Groupe N5
 */

package modele;

import java.awt.Point;

public class Bec {
  /** Objet oiseau qui disposera du bec */
  Point oiseau, pointe;

  /**
   * Constructeur de base
   * 
   * @param oiseau = Centre de l'oiseau
   * @param pointe = Bout du bec
   */
  public Bec(Point oiseau, Point pointe) {
    this.oiseau = oiseau;
    this.pointe = pointe;
  }

  /**
   * Obtient le bout du bec
   * 
   * @return pointe
   */
  public Point getPointe() {
    return pointe;
  }

  /**
   * Definit le bout du bec
   * 
   * @param pointe
   */
  public void setPointe(Point pointe) {
    this.pointe = pointe;
  }
}
