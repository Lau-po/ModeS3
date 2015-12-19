package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import modele.Gravite;
import modele.Modele;
import modele.ObservableModele;
import modele.Obstacle;
import controller.Controller;

@SuppressWarnings("serial")
public class JeuPanel extends JPanel implements Observer {

  private ObservableModele modele;
  private Controller controller;

  public JeuPanel() {
    super();
  }

  public JeuPanel(LayoutManager layout, boolean doubleBuffer) {
    super(layout, doubleBuffer);
  }

  public JeuPanel(ObservableModele modele, Controller controller, LayoutManager layout,
      boolean doubleBuffer) {
    this(layout, doubleBuffer);
    this.modele = modele;
    this.controller = controller;
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
          if (modele instanceof Gravite) {
            ((Gravite) modele).setK(((Gravite) modele).getK() * 10);
            System.out.println("left click");
          }
        }
        if (SwingUtilities.isRightMouseButton(e)) {
          if (modele instanceof Gravite) {
            ((Gravite) modele).setK(((Gravite) modele).getK() / 10);
            System.out.println("right click");
          }
        }
      }
    });
  }

  @Override
  public void update(Observable arg0, Object arg1) {
    controller.collision();
    if (arg0 instanceof Modele) {
      ((Modele) arg0).getPiaf().setTouched(((Modele) arg0).getCollision());
    }
    repaint();
  }


  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    List<Point> courbe = modele.getCourbe();
    for (int i = 0; i < courbe.size(); i++) {
      if (i % 10 == 0) {
        g.setColor(Color.black);
        if (modele instanceof Gravite) {
          g.fillOval(courbe.get(i).x - (5 / 2), ((Gravite) modele).inverse(courbe.get(i).y)
              - (5 / 2), 5, 5);
        }
        g.setColor(Color.white);
      }
    }
    List<Obstacle> obs = modele.getObstacles();
    for (Obstacle obstacle : obs) {
      g.setColor(obstacle.getC());
      if (modele instanceof Gravite) {
        g.fillOval((int) obstacle.getPosition()[0] - (15 / 2),
            ((Gravite) modele).inverse((int) obstacle.getPosition()[1]) - (15 / 2), 15, 15);
      } else {
        g.fillOval((int) obstacle.getPosition()[0] - (15 / 2), (int) obstacle.getPosition()[1]
            - (15 / 2), 15, 15);
      }
      g.setColor(Color.white);
    }
    revalidate();
  }

  public void restart() {
    removeAll();
    revalidate();
    super.paint(getGraphics());
  }
}
