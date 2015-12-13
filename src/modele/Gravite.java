package modele;

import java.awt.Point;
import java.util.ArrayList;


public class Gravite extends ObservableModele {

  private double g = 9.81;
  private double dt = 0.01;
  private double[] position = new double[] {0.0, 0.0};
  private double[] vitesse = new double[] {50.0, 50.0};

  public Gravite() {
    super();
    genObstacles();
  }


  @Override
  public void go() {
    for (int i = 0; i < 100000000 && !collision && position[1] >= 0; i++) {
      acceleration();
      deplacement();
      courbe.add(new Point((int) position[0], (int) position[1]));
      setChanged();
      notifyObservers();
    }
  }

  @Override
  public void reset() {
    courbe = new ArrayList<Point>();
    obstacles = new ArrayList<>();
    position = new double[] {0.0, 0.0};
    vitesse = new double[] {50.0, 50.0};
    genObstacles();
  }

  private void acceleration() {
    double dx = vitesse[0];
    double dz = vitesse[1];
    dz = dz + dt * (-g);
    vitesse[0] = dx;
    vitesse[1] = dz;
  }

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
