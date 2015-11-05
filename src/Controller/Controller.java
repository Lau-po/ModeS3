package Controller;

import java.awt.Point;
import java.util.List;
import java.util.Observer;

import technique.Obstacle;
import Modele.Modele;

public class Controller {

  private Modele modele;
  private Observer observer;
  private List<Point> courbe;
  private List<Obstacle> obstacles;

  public Controller() {

  }

  public void collision() {
    this.courbe = modele.getCourbe();
    this.obstacles = modele.getObstacles();
    Obstacle o;
    for (Point point : courbe) {
      if (point.getX() > 400) {
        for (int i = 0; i < obstacles.size(); i++) {
          o = obstacles.get(i);
          if (!o.isTouched()) {
            if (point.getX() < o.getX() + 15 / 2 && point.getX() > o.getX() - 15 / 2) {
              if (point.getY() < o.getY() + 15 / 2 && point.getY() > o.getY() - 15 / 2) {
                System.out.println("collision");
                o.setTouched(true);
                modele.setCollision(true);
              }
            }
          }
        }
      }
    }

  }

  public void setModele(Modele modele) {
    this.modele = modele;
  }

  public void setObserver(Observer observer) {
    this.observer = observer;
  }
}
