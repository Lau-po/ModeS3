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
  private double pas = resources.Constants.PAS;

  /**
   * Retourne le nombre de pas
   * @return double
   */
  public double getPas() {
	return pas;
  }

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
      y = (37.0 / 20250.0) * (x * x) + (-74.0 / 45.0) * x + 470;
      courbe.add(new Point((int) x, (int) y));
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
