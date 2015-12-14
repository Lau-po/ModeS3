package modele;

import java.awt.Point;
import java.util.ArrayList;


public class Gravite extends ObservableModele {

  /** Constate gravitationnel */
  private double g = 9.81;
  /** pas de la simulation */
  private double dt = 0.01;
  /** vecteur position */
  private double[] position = new double[] {250.0, 250.0};
  /** vecteur vitesse */
  private double[] vitesse = new double[] {0.0, 0.0};

  /**
   * Constructeur de base
   */
  public Gravite() {
    super();
    genObstacles();
  }

  /**
   * @see Modele
   */
  @Override
  public void go() {
    while (!collision && position[1] >= 0) {
      acceleration();
      deplacement();
      courbe.add(new Point((int) position[0], (int) position[1]));
      setChanged();
      notifyObservers();
    }
  }

  /**
   * @see Modele
   */
  @Override
  public void reset() {
    courbe = new ArrayList<Point>();
    obstacles = new ArrayList<>();
    position = new double[] {0.0, 0.0};
    vitesse = new double[] {50.0, 75.0};
    genObstacles();
    collision = false;
  }

  /**
   * Calcul la vitesse de proche en proche
   */
  private void acceleration() {
    double dx = vitesse[0];
    double dz = vitesse[1];
    dz = dz + dt * (-g);
    vitesse[0] = dx;
    vitesse[1] = dz;
  }


  /**
   * Calcul la position de proche en proche
   */
  private void deplacement() {
    double x = position[0];
    double z = position[1];
    double dx = vitesse[0];
    double dz = vitesse[1];
    x = x + dx * dt;
    z = z + dz * dt;
    System.out.println("x : " + x + " z : " + z);
    position[0] = x;
    position[1] = z;
  }


}
