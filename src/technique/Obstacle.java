package technique;

import java.awt.Color;
import java.awt.Point;

public class Obstacle extends Point {

  private boolean touched;

  public Obstacle(int x, int y) {
    super(x, y);
    this.touched = false;
  }

  public boolean isTouched() {
    return touched;
  }

  public void setTouched(boolean touched) {
    this.touched = touched;
  }
  
  public double getX() {
    return super.getX();
  }
  
  public double getY() {
    return super.getY();
  }

}
