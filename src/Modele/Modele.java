package Modele;

import java.awt.Point;
import java.util.List;

import technique.Obstacle;

public interface Modele {

  /**
   * lance la simulation du modele
   */
  public void go();

  /**
   * 
   * @return la liste des points de la courbe
   */
  public List<Point> getCourbe();

  /**
   * 
   * @return la liste des obstacles du jeu
   */
  public List<Obstacle> getObstacles();

  /**
   * reset le modele
   */
  public void reset();

  /**
   * 
   * @param b collision ?
   */
  public void setCollision(boolean b);

}
