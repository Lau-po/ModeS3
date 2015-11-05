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

  public void afficherCourbe(List<Point> courbe, Color c) {
    for (Point point : courbe) {
      new AfficherPoint(frame.getGraphics(), point, c);
    }
  }

  public void afficherObstacles(List<Obstacle> obs) {
    for (Obstacle obstacle : obs) {
      new AfficherObstacle(frame.getGraphics(), obstacle, obstacle.getC());
    }
  }

  public void setModele(ObservableModele modele) {
    this.modele = modele;
  }

  public JFrame getFrame() {
    return frame;
  }

  @Override
  public void update(Observable arg0, Object arg1) {
    controller.collision();
    afficherCourbe(((Modele) arg0).getCourbe(), Color.BLUE);
    afficherObstacles(((Modele) arg0).getObstacles());
  }

  public void startSimulation() {
    modele.go();
  }

  public void restartSimulation() {
    modele.reset();
    frame.repaint();
    startSimulation();
  }

}
