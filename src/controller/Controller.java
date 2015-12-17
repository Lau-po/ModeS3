/**
 * Classe controleur. Fait le lien entre la vue et les modeles.
 * 
 * @author Groupe N5
 */

package controller;

import java.awt.Point;
import java.util.List;
import java.util.Observer;

import modele.Gravite;
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
    Obstacle o;
    Point point = courbe.get(courbe.size() - 1);
    for (int i = 0; i < obstacles.size(); i++) {
      o = obstacles.get(i);
      // o.move();
      if (!o.isTouched()) {
        if (point.getX() - 20 / 2 < o.getX() + (o.getSize() / 2)
            && point.getX() + 20 / 2 > o.getX() - (o.getSize()) / 2) {
          if (point.getY() - 20 / 2 < o.getY() + (o.getSize() / 2)
              && point.getY() + 20 / 2 > o.getY() - (o.getSize() / 2)) {
            System.out.println("collision");
            o.setTouched(true);
            modele.setCollision(true);
            if (modele instanceof Gravite) {
              double poidsOiseau = ((Gravite) modele).getPoidsOiseau();
              double poidsObstacle = ((Gravite) modele).getPoidsObstacle();
              double[] vModele = ((Gravite) modele).getVitesse();
              double[] vObstacle = o.getVitesse();
              double[] vg =
                  new double[] {
                      (poidsOiseau * vModele[0] + poidsObstacle * vObstacle[0])
                          / (poidsObstacle + poidsOiseau),
                      (poidsOiseau * vModele[1] + poidsObstacle * vObstacle[1])
                          / (poidsObstacle + poidsOiseau)};
              ((Gravite) modele).setVitesse(2 * vg[0] - vModele[0], 2 * vg[1] - vModele[1]);
              o.setVitesse(2 * vg[0] - vObstacle[0], 2 * vg[1] - vModele[1]);
            }
          }
        }
      }
    }

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
