/**
 * Classe qui créer une parabole de test
 * 
 * @author Groupe N5
 */

package modele;

import java.awt.Point;
import java.util.ArrayList;

public class Parabole extends ObservableModele {

  /** Nombre de pas de la courbe */
  private double pas = 0.001;

  /**
   * Constructeur de base (depend pour l'instant d'une fenetre de 900*470)
   */
  public Parabole() {
    super();
    genObstacles();
  }

  /**
   * Construit une parabole avec un pas de p
   * 
   * @param pas de la parabole
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
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      y = (37.0 / 20250.0) * (x * x) + (-74.0 / 45.0) * x + 470;
      courbe.add(new Point((int) x, (int) y));
      Point point =
          new Point((int) (courbe.get(courbe.size() - 1).getX() - courbe.get(courbe.size() - 2)
              .getX()) * 10, (int) (courbe.get(courbe.size() - 1).getY() - courbe.get(
              courbe.size() - 2).getY()) * 10);
      Point p2 =
          new Point((int) (courbe.get(courbe.size() - 2).getX() + point.getX()), (int) (courbe.get(
              courbe.size() - 2).getY() + point.getY()));
      oiseau.move((int) courbe.get(courbe.size() - 2).getX(), (int) courbe.get(courbe.size() - 2)
          .getY(), p2);
      setChanged();
      notifyObservers();
    }
    if (collision) {
      try {
        Thread.sleep(1500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        collision = false;
      }
    }
  }

  /**
   * Fonction qui génére les obstacles
   */
  void genObstacles() {
    super.genObstacles();
  }

  /**
   * @see Modele
   */
  @Override
  public void reset() {
    courbe = new ArrayList<>();
    courbe.add(new Point(0, 0));
    obstacles = new ArrayList<>();
    genObstacles();
  }

  /**
   * @see Modele
   */
  @Override
  public Piaf getPiaf() {
    return oiseau;
  }
}
