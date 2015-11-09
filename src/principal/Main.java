/**
 * Classe principale qui gère le lancement du jeu
 * 
 * @author Groupe N5
 */

package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import vue.Frame;

import modele.Bezier;
import modele.ObservableModele;
import modele.Parabole;

import controller.Controller;

public class Main {

  /**
   * Fonction main
   * 
   * @param args
   */
  public static void main(String[] args) {
    ObservableModele m = new Bezier(0.002);
    // ObservableModele m = new Parabole(1);
    final Frame f = new Frame(m, new Controller());
    f.startSimulation();

    ActionListener al = new ActionListener() {
      int cpt = 1;

      @Override
      public void actionPerformed(ActionEvent arg0) {
        if (cpt < 10) {
          f.restartSimulation();
          cpt++;
        } else {
          System.exit(0);
        }
      }
    };
    Timer t = new Timer(1000, al);
    t.start();
  }
}
