/**
 * Classe de la vue principale.
 */

package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.Bezier;
import modele.Modele;
import modele.ObservableModele;
import modele.Obstacle;
import modele.Piaf;

import controller.Controller;

public class Frame implements Observer {

  /** Fenêtre principale */
  private JFrame frame;
  /** JPanel d'affichage */
  private JPanel panel;
  /** Modèle observable */
  private ObservableModele modele;
  /** Controleur de la vue */
  private Controller controller;
  private int toto = 0;

  /**
   * Constructeur de base
   * 
   * @param model a observer
   * @param controller associe
   */
  public Frame(ObservableModele model, Controller controller) {
    frame = new JFrame("Modelisation");
    panel = new JPanel(new FlowLayout(),true);
    frame.setResizable(false);
    frame.setSize(new Dimension(900, 470));
    panel.setSize(frame.getSize());
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    panel.setVisible(frame.isVisible());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);

    this.modele = model;
    this.controller = controller;
    controller.setModele(modele);
    controller.setObserver(this);

    model.addObserver(this);
  }

  /**
   * Fonction qui affiche les %10 points de la courbe dans la fenetre
   * 
   * @param courbe = la liste des points a afficher
   * @param c = la couleur dans laquelle les afficher
   */
  public void afficherCourbe(List<Point> courbe, Color c) {
    Graphics g = panel.getGraphics();
    for (int i = 0; i < courbe.size(); i++) {
      if (i % 10 == 0) {
        g.fillOval(courbe.get(i).x - (5 / 2), courbe.get(i).y - (5 / 2), 5, 5);

      }
    }
  }

  /**
   * Fonction qui affiche l'oiseau
   * 
   * @param oiseau à afficher
   * @param c = couleur de l'oiseau
   */
  public void afficherPiaf(Piaf oiseau, Color c) {
    new Afficher_piaf(panel.getGraphics(), oiseau, c);
  }

  /**
   * Fonction affiche les obstacles dans la fenetre
   * 
   * @param obs = la liste des obstacles a afficher
   */
  public void afficherObstacles(List<Obstacle> obs) {
    Graphics g = panel.getGraphics();
    for (Obstacle obstacle : obs) {
      // new AfficherObstacle(frame.getGraphics(), obstacle, obstacle.getSize(), obstacle.getC());
      g.setColor(obstacle.getC());
      g.fillOval(obstacle.x - (15 / 2), obstacle.y - (15 / 2), 15, 15);
      g.setColor(Color.white);
    }
  }

  /**
   * Fonction qui définit le modèle de la vue
   * 
   * @param modele observable associe au jeu
   */
  public void setModele(ObservableModele modele) {
    this.modele = modele;
  }

  /**
   * Fonction qui retourne la fenêtre principale
   * 
   * @return JFrame la fenetre du jeu
   */
  public JFrame getFrame() {
    return frame;
  }

  /**
   * Fonction update pour la vue
   */
  @Override
  public void update(Observable arg0, Object arg1) {
    controller.collision();
    ((Modele) arg0).getPiaf().setTouched(((ObservableModele) arg0).getCollision());
    afficherCourbe(((Modele) arg0).getCourbe(), Color.BLUE);
    afficherPiaf(((Modele) arg0).getPiaf(), ((Modele) arg0).getPiaf().getC());
    afficherObstacles(((Modele) arg0).getObstacles());
  }

  /**
   * Fonction qui démarre une simulation
   */
  public void startSimulation() {
    System.out.println("\n\nSimulation demarree");
    modele.go();
  }

  /**
   * Fonction qui réinitialise le modele et redemarre une simulation
   */
  public void restartSimulation() {
    modele.reset();
    System.out.println("Modele reset");
    startSimulation();
  }
}
