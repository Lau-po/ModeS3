package technique;

import java.awt.Color;
import java.awt.Point;

@SuppressWarnings("serial")
public class Obstacle extends Point {

  private boolean touched;
  private Color c = Color.red;

  /**
   * Construit un obstacle
   * 
   * @param x coordonnee x de l'obstacle
   * @param y coordonnee y de l'obstacle
   */
  public Obstacle(int x, int y) {
    super(x, y);
    this.touched = false;
  }

  /**
   *
   * @return si l'obstacle est touche ou non
   */
  public boolean isTouched() {
    return touched;
  }

  /**
   * 
   * @param touched si l'obstacle est touche ou non
   */
  public void setTouched(boolean touched) {
    this.touched = touched;
    if (touched) {
      c = Color.YELLOW;
    } else {
      c = Color.red;
    }
  }

  /**
   * @see Modele.Modele
   */
  @Override
  public double getX() {
    return super.getX();
  }

  /**
   * @see Modele.Modele
   */
  @Override
  public double getY() {
    return super.getY();
  }

  /**
   * 
   * @return la couleur de l'obstacle
   */
  public Color getC() {
    return c;
  }
}
