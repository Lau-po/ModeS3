package ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AfficherPoint extends JPanel {

  private Point coord;

  /**
   * Construit un affichage d'un point
   * 
   * @param g le Graphics d'une fenetre
   * @param coord le point a afficher
   * @param color la couleur du point a afficher
   */
  public AfficherPoint(Graphics g, Point coord, Color color) {
    this(g, coord, color, 5);
  }

  /**
   * Construit un affichage d'un point avec une certaine taille
   * 
   * @param g le Graphics de la fenetre
   * @param coord le point a afficher
   * @param color la couleur du point a afficher
   * @param taille la taille du point a afficher
   */
  public AfficherPoint(Graphics g, Point coord, Color color, int taille) {
    super();
    Color c = g.getColor();
    this.coord = coord;
    g.setColor(color);
    g.fillOval(coord.x - (taille / 2), coord.y - (taille / 2), taille, taille);
    g.setColor(c);
  }

  @Override
  public int getX() {
    return this.coord.x;
  }

  @Override
  public int getY() {
    return this.coord.y;
  }
}
