/**
 * Classe controleur. Fait le lien entre la vue et les modeles.
 * 
 * @author Groupe N5
 */

package controller;

import java.awt.Point;
import java.util.List;
import java.util.Observer;

import modele.Modele;
import modele.Obstacle;

public class Controller {

  /** Modele lie au controleur */
  private Modele modele;
  /** Observeur lie au controleur */
  @SuppressWarnings("unused")
  private Observer observer;
  /** Liste des points de la courbe */
  private List<Point> courbe;
  /** Liste des obstacles */
  private List<Obstacle> obstacles;

  /**
   * Calcul s'il y a une collision entre la courbe et les obstacles du modele. Stop la simulation si
   * besoin.
   */
  public void collision() {
    this.courbe = modele.getCourbe();
    this.obstacles = modele.getObstacles();
    Obstacle o, o2;
    Point point = courbe.get(courbe.size() - 1);
    if (collisionSol(point)) {
      modele.collisionSol();
    }
    for (int i = 0; i < obstacles.size(); i++) {
      o = obstacles.get(i);
      // o.move();
      if (collisionSol(o)) {
        modele.collisionSol(o);
      }
      if (!o.isTouched()) {
        if (collision(point, o)) {
          o.setTouched(true);
          modele.setCollision(true);
          modele.collision(o);
        }
      } else {
        if (collision(point, o)) {
          modele.collision(o);
        }
        for (int j = 0; j < obstacles.size(); j++) {
          if (i != j) {
            o2 = obstacles.get(j);
            if (collision(o, o2)) {
              o2.setTouched(true);
              o.setTouched(true);
              modele.collision(o, o2);
            }
          }
        }
      }
    }

  }

  private boolean collision(Point a, Obstacle b) {
    double r, diffX, diffY, d;
    if (a instanceof Obstacle) {
      r = 15 / 2;
      diffX = ((Obstacle) a).getPosition()[0] - b.getPosition()[0];
      diffY = ((Obstacle) a).getPosition()[1] - b.getPosition()[1];
      d = diffX * diffX + diffY * diffY;
      if (d > (r + 15) * (r + 15)) {
        return false;
      }
      return true;
    }
    r = 20 / 2;
    diffX = a.getX() - b.getPosition()[0];
    diffY = a.getY() - b.getPosition()[1];
    d = diffX * diffX + diffY * diffY;
    if (d > (r + 15) * (r + 15)) {
      return false;
    }
    return true;
  }

  private boolean collisionSol(Point a) {
    if (a.getX() < 100) {
      return false;
    }
    return collision(a, new Obstacle((int) a.getX(), 0, 15));
  }

  /**
   * Definit le modele.
   * 
   * @param modele que le controller doit controller.
   */
  public void setModele(Modele modele) {
    this.modele = modele;
  }

  /**
   * Definit l'observateur.
   * 
   * @param observer du modele.
   */
  public void setObserver(Observer observer) {
    this.observer = observer;
  }
}
