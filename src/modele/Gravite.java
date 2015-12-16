package modele;

import java.awt.Point;
import java.util.ArrayList;

import sun.net.www.content.audio.x_aiff;


public class Gravite extends ObservableModele {

  /** Constate gravitationnel */
  private double g = 9.81;
  /** pas de la simulation */
  private double dt = 0.01;
  /** vecteur position */
  private double[] position = new double[] {250.0, 250.0};
  /** vecteur vitesse */
  private double[] vitesse = new double[] {0.0, 0.0};
  private double k = 0.001;
  private double poidsOiseau = 50.0;
  private double poidsObstacle = 150.0;

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
    while (/* !collision && */position[1] >= 0) {
      acceleration();
      deplacement();
      try {
        Thread.sleep(2);
      } catch (Exception e) {
      }
      courbe.add(new Point((int) position[0], inverse((int) position[1])));
      if (collision) {
        collision = false;
        double[] vg =
            new double[] {
                (poidsOiseau * vitesse[0] + poidsObstacle * -5) / (poidsObstacle + poidsOiseau),
                (poidsOiseau * vitesse[1] + poidsObstacle * 0) / (poidsObstacle + poidsOiseau)};
        vitesse = new double[] {2 * vg[0] - vitesse[0], 2 * vg[1] - vitesse[1]};
      }
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
    vitesse = new double[] {75.0, 100.0};
    genObstacles();
    collision = false;
  }

  /**
   * Calcul la vitesse de proche en proche
   */
  private void acceleration() {
    double dx = vitesse[0];
    double dz = vitesse[1];
    dz = dz + dt * (-g) - k * vitesse[1];
    dx = dx - k * vitesse[0];
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
    System.out.println("dx : " + dx + " dz : " + dz);
    position[0] = x;
    position[1] = z;
  }

  private int inverse(int y) {
    return -y + 470;
  }


}
