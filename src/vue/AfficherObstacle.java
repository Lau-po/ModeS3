/**
 * Classe qui gère l'affichage des obstacles
 * @author Groupe N5
 */

package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

@SuppressWarnings("serial")
public class AfficherObstacle extends AfficherPoint {
	
  /**
   * Constructeur de base 
   * @param g = le Graphics de la fenetre
   * @param coord = le point a afficher
   * @param color = la couleur de l'obstacle
   */
  public AfficherObstacle(Graphics g, Point coord, int taille,Color color) {
    super(g, coord, color, taille);
  }
}