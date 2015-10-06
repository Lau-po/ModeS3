package ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AfficherPoint extends JPanel {
	/** Debug **/
	boolean debug = true;	
	
	Point coord;
	public AfficherPoint(Graphics g,Point coord,Color couleur) 
	{
		int taille = 5;
		super.paint(g);
		Color c = g.getColor();
		this.coord=coord;
		g.setColor(couleur);
		g.fillOval(coord.x-(taille/2),coord.y-(taille/2),taille,taille);
		g.setColor(c);
	}
	
	public int getX()
	{
		return this.coord.x;
	}
	
	public int getY()
	{
		return this.coord.y;
	}
}
