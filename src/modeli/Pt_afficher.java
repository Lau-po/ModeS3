package modeli;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Pt_afficher extends JPanel
{
	int taille = 5;
	Point coord;
	public Pt_afficher(Graphics g,Point coord,Color couleur) 
	{
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
