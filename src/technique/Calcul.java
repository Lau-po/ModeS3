package technique;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Calcul {
  
  private int l;
  private int h;
  
  /** Debug **/
  static boolean debug = true;

  public Calcul(int l, int h) {
    this.l = l;
    this.h = h;
  }
  
  /**
   * 
   * @param list_pdc = liste de points de contrôles
   * @param t = instant d'un temps donné
   * @return point de la courbe à instant 't'
   */
  public Point creerCourbe(List<Point> list_pdc, float t) {
    ArrayList<Point> list_pv = new ArrayList<Point>();
    if (list_pdc.size() - 1 == 0) {
      return list_pdc.get(0);
    }
    for (int i = 0; i < list_pdc.size() - 1; i++) {
      int x = (int) ((1 - t) * list_pdc.get(i).getX() + t * list_pdc.get(i + 1).getX());
      int y = (int) ((1 - t) * list_pdc.get(i).getY() + t * list_pdc.get(i + 1).getY());
      list_pv.add(new Point(x, y));
    }
    return creerCourbe(list_pv, t);
  }

  /**
   * Fonction qui place les points de contrôles d'une courbe de Bézier
   */
  public List<Point> createPointCtrl() {
    List<Point> list_pdc = new ArrayList<Point>();
    Random r = new Random();
    list_pdc.add(new Point(10, this.l - 10));
    list_pdc.add(new Point((r.nextInt(20)+50), r.nextInt(20)+120));
    list_pdc.add(new Point((r.nextInt(50)+this.l+this.l/2), r.nextInt(50)+this.h/2));
    // TODO

    return list_pdc;


  }
}
