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

  /**
   * renvoie si le modele a subit une collision
   * 
   * @return boolean collision
   */
  public boolean getCollision();

  /**
   * le modele fait subir une collision entre l'oiseau et l'obstacle
   * 
   * @param o l'obstacle avec lequel a eu lieu une collision
   */
  public void collision(Obstacle o);

  /**
   * le modele fait subir une collision entre deux obstacles
   * 
   * @param o1 le premier obstacle de la collision
   * @param o2 le deuxieme obstacle de la collision
   */
  public void collision(Obstacle o1, Obstacle o2);

  public void collisionSol();

  public void collisionSol(Obstacle o);
}
