package Modele;

import java.awt.Point;
import java.util.List;

import technique.Obstacle;

public interface Modele {

  public void go();
  
  public List<Point> getCourbe();
  
  public List<Obstacle> getObstacles();
  
  public void reset();
}
