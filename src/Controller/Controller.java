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
  
  public Controller(Modele modele, Observer observer) {
    this.modele = modele;
    this.observer = observer;
  }
  
  public boolean collision() {
    this.courbe = modele.getCourbe();
    this.obstacles = modele.getObstacles();
    // TODO test collision qui bloque la génération et l'affichage
    return false;
  }
  
}
