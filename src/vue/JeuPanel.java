package vue;

import controller.Controller;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import modele.Gravite;
import modele.Modele;
import modele.ObservableModele;
import modele.Obstacle;

@SuppressWarnings("serial")
public class JeuPanel extends JPanel implements Observer {

	private ObservableModele modele;
	private Controller controller;
	private Image background, slingshot, cloud, piaf;

	public JeuPanel() {
		super();
	}

	public JeuPanel(LayoutManager layout, boolean doubleBuffer) {
		super(layout, doubleBuffer);
	}

	public JeuPanel(final ObservableModele modele, Controller controller,
			LayoutManager layout, boolean doubleBuffer) {
		this(layout, doubleBuffer);
		this.modele = modele;
		this.controller = controller;
		try {
			background = ImageIO.read(new File("src/resources/"
					+ modele.getP().name() + ".jpg"));
			slingshot = ImageIO.read(new File("src/resources/slingshot.png"));
			/* cloud = ImageIO.read(new File("pictures/cloud.gif")); */
			piaf = ImageIO.read(new File("src/resources/piaf.png"));
		} catch (IOException ex) {
			Logger.getLogger(JeuPanel.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		addMouseListener(((Gravite) modele).getSlingshot().getCliker());
		addMouseMotionListener(((Gravite) modele).getSlingshot().getMove());
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
			((Modele) arg0).getPiaf()
					.setTouched(((Modele) arg0).getCollision());
		}
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		g.setColor(modele.getSlingshot().getC());
		if (modele instanceof Gravite && !((Gravite) modele).getSlingshot().isLaunched()) {
			if (modele instanceof Gravite) {
				g.setColor(new Color(76,43,00));
				g.drawLine((int) modele.getSlingshot().getMousePosition()[0],(int) modele.getSlingshot().getMousePosition()[1],	(int) modele.getSlingshot().getLocation().getX()+10,((Gravite) modele).inverse((int) modele.getSlingshot().getLocation().getY()));
				g.drawLine((int) modele.getSlingshot().getMousePosition()[0],(int) modele.getSlingshot().getMousePosition()[1],	(int) modele.getSlingshot().getLocation().getX()-10,((Gravite) modele).inverse((int) modele.getSlingshot()	.getLocation().getY()));
			}
			if (modele instanceof Gravite && ((Gravite) modele).getSlingshot().isInCube()) {
				g.setColor(Color.green);
			} else {
				g.setColor(Color.red);
			}
			if (modele instanceof Gravite) {
				g.fillOval((int) modele.getSlingshot().getMousePosition()[0] - modele.getPiaf().size()/2,(int) modele.getSlingshot().getMousePosition()[1] - modele.getPiaf().size()/2,modele.getPiaf().size(), modele.getPiaf().size());
			}
		}
		g.drawImage(slingshot, 85, 300, 80, 150, this);
		List<Point> courbe = modele.getCourbe();
		for (int i = 0; i < courbe.size(); i++) {
			if (i % 10 == 0) {
				g.setColor(Color.black);
				if (modele instanceof Gravite) {					
					// if( i == courbe.size()-1){ 
						 g.fillOval(courbe.get(i).x - (5 / 2),((Gravite) modele).inverse(courbe.get(i).y)- (5 / 2), 5, 5);
					 //}
					 /*}else if( i % 80 == 0){					 
						 g.fillOval(courbe.get(i).x - (5 / 2),((Gravite) modele).inverse(courbe.get(i).y)- (5 / 2), 5, 5);
					 }*/
				}
				g.setColor(Color.white);
			}
		
		}
		if (modele instanceof Gravite) {
			if(((Gravite) modele).getSlingshot().isLaunched()){
				g.setColor(modele.getPiaf().getC());
				g.fillOval((int) (modele.getPiaf().getX() - (modele.getPiaf().size() / 2)),((Gravite) modele).inverse((int)modele.getPiaf().getY())- (modele.getPiaf().size() / 2), modele.getPiaf().size(), modele.getPiaf().size());
			}
		}
		List<Obstacle> obs = modele.getObstacles();
		for (Obstacle obstacle : obs) {
			g.setColor(obstacle.getC());
			if (modele instanceof Gravite) {
				g.fillOval(
						(int) obstacle.getPosition()[0] - (15 / 2),
						((Gravite) modele).inverse((int) obstacle.getPosition()[1])
								- (15 / 2), 15, 15);
			} else {
				g.fillOval((int) obstacle.getPosition()[0] - (15 / 2),
						(int) obstacle.getPosition()[1] - (15 / 2), 15, 15);
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
