package modele;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import vue.JeuPanel;
import controller.Controller;

public class Jeu extends JFrame {

  private ObservableModele modele;
  private Controller controller;
  private JeuPanel p;

  public Jeu() {
    super("Modelisation");
  }

  public Jeu(ObservableModele modele, Controller controller) {
    this();
    this.modele = modele;
    this.controller = controller;
    JeuPanel panel = new JeuPanel(modele, controller, new FlowLayout(), true);
    this.p = panel;
    setResizable(false);
    setSize(new Dimension(900, 470));
    panel.setSize(getSize());
    setLocationRelativeTo(null);
    setVisible(true);
    panel.setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(panel);
    controller.setModele(modele);
    controller.setObserver(panel);
    modele.addObserver(panel);
  }

  public void startSimulation() {
    System.out.println("\n\nSimulation demarree");
    modele.go();
  }

  /**
   * Fonction qui réinitialise le modele et redemarre une simulation
   */
  public void restartSimulation() {
    modele.reset();
    p.restart();
    System.out.println("Modele reset");
    startSimulation();
  }
}
