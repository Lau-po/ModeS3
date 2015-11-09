/**
 * Classe qui gère le modèle général
 * 
 * @author Groupe N5
 */

package modele;

import java.awt.Point;
import java.util.List;

public interface Modele {

  /**
   * lance la simulation du modele
   */
  public void go();

  /**
   * Liste des points de la courbe
   * 
   * @return la liste des points de la courbe
   */
  public List<Point> getCourbe();

  /**
   * Fonction pour obtenir l'oiseau
   * 
   * @return le piaf
   */
  public Piaf getPiaf();

  /**
   * Fonction pour obtenir la liste des obstacles
   * 
   * @return la liste des obstacles du jeu
   */
  public List<Obstacle> getObstacles();

  /**
   * réinitialise le modele
   */
  public void reset();

  /**
   * Fonction qui détermine si il y a une collision
   * 
   * @param b la collision
   */
  public void setCollision(boolean b);
}
