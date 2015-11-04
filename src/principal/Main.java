package principal;

import java.util.Observable;

import Controller.Controller;
import Modele.Modele;
import Modele.Parabole;
import Vue.Frame;

public class Main {
  public static void main(String[] args) {
    // Modele m = new Bezier(0.005);
    Modele m = new Parabole(3);
    Frame f = new Frame((Observable) m, new Controller());
    m.go();
    while (true) {
      m.reset();
      f.repaint();
      m.go();
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        // TODO: handle exception
      }
      System.out.println(1);
    }
  }
}
