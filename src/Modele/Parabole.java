package Modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import technique.Obstacle;

public class Parabole extends ObservableModele {

  private double pas = 0.001;

  /**
   * Construit une parabole (depend pour l'instant d'une fenetre de 900*470)
   */
  public Parabole() {
    super();
    genObstacles();
  }

  /**
   * Construit une parabole avec un pas de p
   * 
   * @param pas le pas de la parabole
   */
  public Parabole(double pas) {
    this();
    this.pas = pas;
  }

  /**
   * @see Modele
   */
  @Override
  public void go() {
    double y;
    for (float x = 0; x < 970 && !collision; x += pas) {
      y = (37.0 / 20250.0) * (x * x) + (-74.0 / 45.0) * x + 470;
      courbe.add(new Point((int) x, (int) y));
      setChanged();
      notifyObservers();
    }
    if (collision) {
      try {
        Thread.sleep(1500);
      } catch (Exception e) {
        // TODO: handle exception
      } finally {
        collision = false;
      }
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

  /**
   * @see Modele
   */
  @Override
  public void reset() {
    courbe = new ArrayList<>();
    obstacles = new ArrayList<>();
    genObstacles();
  }

}
