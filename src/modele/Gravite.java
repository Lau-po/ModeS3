package modele;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;


public class Gravite extends ObservableModele implements ActionListener {

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
  private Timer t;

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
    t = new Timer(1, this);
    t.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (position[1] >= 0) {
      acceleration();
      deplacement();
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
      done = false;
    } else {
      done = true;
      t.stop();
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
    done = false;
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
    // System.out.println("dx : " + dx + " dz : " + dz);
    // System.out.println("x : " + x + " z : " + z);
    position[0] = x;
    position[1] = z;
  }

  private int inverse(int y) {
    return -y + 470;
  }


}
