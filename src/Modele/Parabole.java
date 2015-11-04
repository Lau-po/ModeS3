package Modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import technique.Obstacle;

public class Parabole extends Observable implements Modele {

  private List<Point> courbe;
  private List<Obstacle> obstacles;
  private double pas = 0.001;
  private boolean colision = false;

  public Parabole() {
    courbe = new ArrayList<>();
    obstacles = new ArrayList<>();
    genObstacles();
  }

  public Parabole(double pas) {
    this();
    this.pas = pas;
  }

  public void go() {
    double y;
    for (float x = 0; x < 970; x += pas) {
      y = (37.0 / 20250.0) * (x * x) + (-74.0 / 45.0) * x + 470;
      courbe.add(new Point((int) x, (int) y));
      setChanged();
      notifyObservers();
    }
  }

  private void genObstacles() {
    Random random = new Random();
    int nb = random.nextInt(5) + 5;
    int x;
    int y;
    for (int i = 0; i < nb; i++) {
      x = random.nextInt(400) + 450;
      y = random.nextInt(450);
      obstacles.add(new Obstacle(x, y));
    }
  }

  public List<Point> getCourbe() {
    return courbe;
  }

  public List<Obstacle> getObstacles() {
    return obstacles;
  }

  public void reset() {
    courbe = new ArrayList<>();
    obstacles = new ArrayList<>();
    genObstacles();
  }
}
