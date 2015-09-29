package modeli;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenaitre 
{
	int sc_hauteur = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	int sc_largeur  = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	
	JFrame fen;
	ArrayList<Point> list_pdc;// la liste des points de controle
	boolean netoiller;// permet de detecter si la courbe a etait trace pour netoiller au prochain click
	
	public Fenaitre()
	{
		/*-----------bla-bla-habituel-des-jframe--------------------*/
		fen = new JFrame("courbes");
		fen.setLocation(0, 0);
		fen.setPreferredSize(new Dimension(sc_largeur,sc_hauteur));
		fen.setContentPane(new JPanel());
		fen.getContentPane().setBackground(Color.white);
		fen.pack();
		fen.setVisible(true);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*----------------------------------------------------------*/
		
		/*---------------------init---------------------------------*/
		list_pdc = new ArrayList<Point>();
		netoiller = false;
		/*----------------------------------------------------------*/
		
		fen.addMouseListener(new MouseListener() //le mouse listener
		{
			
			@Override
			public void mouseReleased(MouseEvent e) //quand je lache 
			{
				if(e.getButton() == MouseEvent.BUTTON1)//le btn gauche de la souris
				{
					if(netoiller)
					{
						netoiller=false;
						list_pdc.clear();//netoillage de l'�cran et des point de controles
						fen.getContentPane().repaint();
					}
					else
					{
						list_pdc.add(e.getPoint());
						new Pt_afficher(fen.getGraphics(), e.getPoint(), Color.red);//ajout de point de controles (et affichages)
					}
				}
				else if (e.getButton() == MouseEvent.BUTTON3) //le btn droit de la souris
				{
					if(list_pdc.size()>=2)
					{
						netoiller = true;
						for (float t = 0; t < 1; t=(float) (t+0.01)) // affiche la courbe (en pointillets plus ou moin raprocher en fonction de la vitesse)
						{
							new Pt_afficher(fen.getGraphics(), generer_voyageur(list_pdc,t), Color.blue);
							try 
							{
								Thread.sleep(50);
							}
							catch (InterruptedException e1) 
							{
								e1.printStackTrace();
							}
						}
					}
				}
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
			}

			private Point generer_voyageur(ArrayList<Point> list_pdc,float t) 
			{
				if(list_pdc.size()-1==0)//si il ne reste qu'un pnt c'est celui de la courbe
				{
					return list_pdc.get(0);//donc je le renvoit
				}
				ArrayList<Point> list_pv = new ArrayList<Point>();//declaration de la liste pour les pnt crer
				for (int i = 0; i < list_pdc.size()-1; i++) // a chaque niveau de point crer il y en a 1 de moin
				{
					int x=(int) ((1-t)*list_pdc.get(i).getX() + t*list_pdc.get(i+1).getX());//calcul des coord d'un voyageur
					int y=(int) ((1-t)*list_pdc.get(i).getY() + t*list_pdc.get(i+1).getY());//a l'aide de la formule de bezier
					list_pv.add(new Point(x,y));
				}
				return generer_voyageur(list_pv,t);// on recommance pour les voyageurs d'etages superieur
			}
		});
		
		
	}
	
	public static void main(String[] args) 
	{
		new Fenaitre();
	}
}
