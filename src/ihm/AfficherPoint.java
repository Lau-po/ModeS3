package ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AfficherPoint extends JPanel {
  /** Debug **/
  boolean debug = true;

  private Point coord;

  public AfficherPoint(Graphics g, Point coord, Color color) {
    this(g, coord, color, 5);
  }
  
  public AfficherPoint(Graphics g, Point coord, Color color, int taille) {
    super();
    Color c = g.getColor();
    this.coord = coord;
    g.setColor(color);
    g.fillOval(coord.x - (taille / 2), coord.y - (taille / 2), taille, taille);
    //g.setColor(c);
  }

  public int getX() {
    return this.coord.x;
  }

  public int getY() {
    return this.coord.y;
  }
}
