package Vue;

import ihm.AfficherObstacle;
import ihm.AfficherPoint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import technique.Obstacle;
import Controller.Controller;
import Modele.Modele;
import Modele.ObservableModele;

public class Frame implements Observer {

  private JFrame frame;
  private ObservableModele modele;
  private Controller controller;

  /**
   * Construit une fenetre pour le jeu avec un modele a observer et son controller
   * 
   * @param model le model a observer
   * @param controller le controller associe
   */
  public Frame(ObservableModele model, Controller controller) {
    frame = new JFrame("Modelisation");
    frame.setResizable(false);
    frame.setSize(new Dimension(900, 470));
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.modele = model;
    this.controller = controller;
    controller.setModele(modele);
    controller.setObserver(this);

    model.addObserver(this);
  }

  /**
   * affiche les %10 points de la courbe dans la fenetre
   * 
   * @param courbe la liste des points a afficher
   * @param c la couleur dans laquelle les afficher
   */
  public void afficherCourbe(List<Point> courbe, Color c) {
    for (int i = 0; i < courbe.size(); i++) {
      if (i % 10 == 0) {
        new AfficherPoint(frame.getGraphics(), courbe.get(i), c);
      }
    }
  }

  /**
   * affiche les obstacles dans la fenetre
   * 
   * @param obs la liste des obstacles a afficher
   */
  public void afficherObstacles(List<Obstacle> obs) {
    for (Obstacle obstacle : obs) {
      new AfficherObstacle(frame.getGraphics(), obstacle, obstacle.getC());
    }
  }

  /**
   * 
   * @param modele le modele observable associe au jeu
   */
  public void setModele(ObservableModele modele) {
    this.modele = modele;
  }

  /**
   * @return JFrame la fenetre du jeu
   */
  public JFrame getFrame() {
    return frame;
  }

  @Override
  public void update(Observable arg0, Object arg1) {
    controller.collision();
    afficherCourbe(((Modele) arg0).getCourbe(), Color.BLUE);
    afficherObstacles(((Modele) arg0).getObstacles());
  }

  /**
   * demarre une simulation
   */
  public void startSimulation() {
    System.out.println("\n\nSimulation demarree");
    modele.go();
  }

  /**
   * reset le modele et redemarre une simulation
   */
  public void restartSimulation() {
    modele.reset();
    System.out.println("Modele reset");
    frame.repaint();
    startSimulation();
  }

}
