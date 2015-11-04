package technique;

import java.awt.Color;
import java.awt.Point;

public class Obstacle extends Point {

  private boolean touched;
  private Color c = Color.red;

  public Obstacle(int x, int y) {
    super(x, y);
    this.touched = false;
  }

  public boolean isTouched() {
    return touched;
  }

  public void setTouched(boolean touched) {
    this.touched = touched;
    if (touched) {
      c = Color.YELLOW;
    } else {
      c = Color.red;
    }
  }

  @Override
  public double getX() {
    return super.getX();
  }

  @Override
  public double getY() {
    return super.getY();
  }

  public Color getC() {
    return c;
  }
}
