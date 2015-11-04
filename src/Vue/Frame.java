package Vue;

import ihm.AfficherPoint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.Controller;
import Modele.Bezier;

public class Frame implements Observer {

  private JFrame frame;

  public Frame(Observable model, Controller controller) {
    frame = new JFrame("Modelisation");
    frame.setResizable(false);
    frame.setSize(new Dimension(900, 470));
    frame.setLocationRelativeTo(null);
    frame.setContentPane(new JPanel());
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    model.addObserver(this);
  }

  public void afficherCourbe(List<Point> courbe, Color c) {
    for (Point point : courbe) {
      new AfficherPoint(frame.getGraphics(), point, c);
      // try {
      // Thread.sleep(1);
      // } catch (InterruptedException e) {
      // // TODO changer le thread
      // e.printStackTrace();
      // }
    }
  }

  @Override
  public void update(Observable arg0, Object arg1) {
    System.out.println(arg0);
    System.out.println(arg1);
    System.out.println(((Bezier) arg0).getCourbe());
    afficherCourbe(((Bezier) arg0).getCourbe(), Color.BLUE);

  }

}
