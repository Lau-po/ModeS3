package Modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Parabole extends Observable implements Modele {

  private List<Point> courbe;
  private double pas = 0.001;

  public Parabole() {
    courbe = new ArrayList<>();
  }

  public Parabole(double pas) {
    this();
    this.pas = pas;
  }

  public void go() {
    double y;
    for (float x = 0; x < 970; x += pas) {
      y = (37.0 / 20250.0) * (x*x) + (-74.0 / 45.0) * x + 470;
      System.out.println("x = " + x + "\ny = " + y);
      courbe.add(new Point((int) x, (int) y));
      setChanged();
      notifyObservers();
    }
  }

  public List<Point> getCourbe() {
    return courbe;
  }

}
