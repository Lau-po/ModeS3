package principal;

import Controller.Controller;
import Modele.ObservableModele;
import Modele.Parabole;
import Vue.Frame;

public class Main {
  public static void main(String[] args) {
    // ObservableModele m = new Bezier(0.005);
    ObservableModele m = new Parabole(3);
    Frame f = new Frame(m, new Controller());
    f.startSimulation();
    while (true) {
      f.restartSimulation();
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        // TODO: handle exception
      }
      System.out.println(1);
    }
  }
}
