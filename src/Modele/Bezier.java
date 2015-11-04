package Modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import technique.Obstacle;

public class Bezier extends Observable implements Modele{

  private List<Point> courbe;
  private List<Point> ctrl;
  private List<Obstacle> obstacles;
  private double pas = 0.001;

  public Bezier() {
    createPointCtrl();
    obstacles = new ArrayList<Obstacle>();
    genObstacles();
    courbe = new ArrayList<>();
  }
  
  public Bezier(double pas) {
    this();
    this.pas = pas;
  }

  public void go() {
    for (float i = 0; i <= 1; i += pas) {
      courbe.add(createCurve(ctrl, i));
      setChanged();
      notifyObservers();
    }
  }

  private void createPointCtrl() {
    ctrl = new ArrayList<Point>();
    Random r = new Random();
    ctrl.add(new Point(10, 490));
    ctrl.add(new Point((r.nextInt(20) + 50), r.nextInt(20) + 120));
    ctrl.add(new Point((r.nextInt(50) + 500 + 500 / 2), r.nextInt(50) + 250));
    // TODO supprimer les numeros magique
  }

  private Point createCurve(List<Point> list_pdc, float t) {
    ArrayList<Point> list_pv = new ArrayList<Point>();
    if (list_pdc.size() - 1 == 0) {
      return list_pdc.get(0);
    }
    for (int i = 0; i < list_pdc.size() - 1; i++) {
      int x = (int) ((1 - t) * list_pdc.get(i).getX() + t * list_pdc.get(i + 1).getX());
      int y = (int) ((1 - t) * list_pdc.get(i).getY() + t * list_pdc.get(i + 1).getY());
      list_pv.add(new Point(x, y));
    }
    return createCurve(list_pv, t);
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
    createPointCtrl();
    obstacles = new ArrayList<Obstacle>();
    genObstacles();
    courbe = new ArrayList<>();
  }
}
