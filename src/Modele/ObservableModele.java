package Modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import technique.Obstacle;

public abstract class ObservableModele extends Observable implements Modele {

  protected List<Point> courbe;
  protected List<Obstacle> obstacles;
  protected boolean collision;

  public ObservableModele() {
    courbe = new ArrayList<Point>();
    obstacles = new ArrayList<Obstacle>();
  }

  @Override
  abstract public void go();

  @Override
  public List<Point> getCourbe() {
    return courbe;
  }

  @Override
  public List<Obstacle> getObstacles() {
    return obstacles;
  }

  @Override
  abstract public void reset();

  @Override
  public void setCollision(boolean b) {
    this.collision = b;
  }

}
