package Modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import technique.Obstacle;

public abstract class ObservableModele extends Observable implements Modele {

  /** la liste des points formant la courbe */
  protected List<Point> courbe;
  /** la liste des obstacles du jeu */
  protected List<Obstacle> obstacles;
  /** vrai si la courbe est entree en collision avec un obstacle */
  protected boolean collision;

  /**
   * Construit un modele observable
   */
  public ObservableModele() {
    courbe = new ArrayList<Point>();
    obstacles = new ArrayList<Obstacle>();
  }

  /**
   * @see Modele
   */
  @Override
  abstract public void go();

  /**
   * @see Modele
   */
  @Override
  public List<Point> getCourbe() {
    return courbe;
  }

  /**
   * @see Modele
   */
  @Override
  public List<Obstacle> getObstacles() {
    return obstacles;
  }

  /**
   * @see Modele
   */
  @Override
  abstract public void reset();

  /**
   * @see Modele
   */
  @Override
  public void setCollision(boolean b) {
    this.collision = b;
  }

}
