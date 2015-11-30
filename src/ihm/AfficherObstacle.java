package ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

@SuppressWarnings("serial")
public class AfficherObstacle extends AfficherPoint {

  /**
   * Construit un affichage d'un Obstacle
   * 
   * @param g le Graphics de la fenetre
   * @param coord le point a afficher
   * @param color la couleur de l'obstacle
   */
  public AfficherObstacle(Graphics g, Point coord, Color color) {
    super(g, coord, color, 15);
  }

}
