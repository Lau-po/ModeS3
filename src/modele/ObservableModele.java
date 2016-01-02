/**
 * Classe qui gère l'ObservableModele.
 * 
 * @author Groupe N5
 */

package modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

public abstract class ObservableModele extends Observable implements Modele {

  /** la liste des points formant la courbe */
  protected List<Point> courbe;
  /** la liste des obstacles du jeu */
  protected List<Obstacle> obstacles;
  /** vrai si la courbe est entree en collision avec un obstacle */
  protected boolean collision;
  /** l'oiseau */
  protected Piaf oiseau;
  public boolean done = false;
  /** Slingshot */
  protected Slingshot slingshot;
  
  /**
   * Construit un modele observable
   */
  public ObservableModele() {
	slingshot = new Slingshot();
    courbe = new ArrayList<Point>();
    obstacles = new ArrayList<Obstacle>();
    oiseau = new Piaf(0, 0, new Point(0, 0));
  }

  /**
   * Retourne le Slingshot
   * @return un Slingshot
   */
  public Slingshot getSlingshot() {
	return slingshot;
  }

  /**
   * Donne les valeurs de bases au slingshot
 * @param slingshot
 */
public void setSlingshot(Slingshot slingshot) {
	this.slingshot = slingshot;
  }

/**
   * @see Modele
   */
  @Override
  abstract public void go();

  /**
   * @see Modele
   */
  @Override
  public List<Point> getCourbe() {
    return courbe;
  }

  /**
   * @see Modele
   */
  @Override
  public List<Obstacle> getObstacles() {
    return obstacles;
  }

  /**
   * @see Modele
   */
  @Override
  abstract public void reset();

  /**
   * @see Modele
   */
  @Override
  public void setCollision(boolean b) {
    this.collision = b;
  }

  @Override
  public boolean getCollision() {
    return collision;
  }

  /**
   * Fonction qui génère les obstacles
   */
  void genObstacles() {
    Random random = new Random();
    int nb = random.nextInt(5) + 50;
    int x;
    int y;
    for (int i = 0; i < nb; i++) {
      x = random.nextInt(450) + 350 - 30;
      y = random.nextInt(400) + 30;
      obstacles.add(new Obstacle(x, y, 15));
    }
  }

  /**
   * @see Modele
   */
  @Override
  public Piaf getPiaf() {
    return oiseau;
  }

  @Override
  abstract public void collision(Obstacle o);

  @Override
  abstract public void collision(Obstacle o1, Obstacle o2);

  @Override
  abstract public void collisionSol();

  @Override
  abstract public void collisionSol(Obstacle o);
  
  @Override
  abstract public void launchPad();

}
