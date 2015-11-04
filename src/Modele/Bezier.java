package Modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

public class Bezier extends Observable {

  private List<Point> courbe;
  private List<Point> ctrl;

  public Bezier() {
    System.out.println("toto");
    createPointCtrl();
    courbe = new ArrayList<>();
  }

  public void go() {
    for (float i = 0; i <= 1; i += 0.01) {
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

  public List<Point> getCourbe() {
    return courbe;
  }
}
