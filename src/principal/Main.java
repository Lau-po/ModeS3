package principal;

import java.awt.Color;

import Modele.Bezier;
import Modele.Parabole;
import Vue.Frame;

public class Main {
  public static void main(String[] args) {
    Bezier b = new Bezier(0.01);
    Parabole p = new Parabole(5);
    Frame f = new Frame(p, null);
    p.go();
    b.go();
    while (true) {
      p.reset();
      f.getFrame().repaint();
      p.go();
      try {
       Thread.sleep(1000); 
      } catch (Exception e) {
        // TODO: handle exception
      }
      System.out.println(1);
    }
  }
}
