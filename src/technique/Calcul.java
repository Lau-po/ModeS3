package technique;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Calcul {
	/** Debug **/
	static boolean debug = true;
	/**
	 * 
	 * @param list_pdc = liste de points de contrôles
	 * @param t = instant d'un temps donné
	 * @return point de la courbe à instant 't'
	 */
	public static Point creerCourbe(List<Point> list_pdc, float t) {
		ArrayList<Point> list_pv = new ArrayList<Point>();
		if(list_pdc.size() -1 == 0) {
			return list_pdc.get(0);
		}
		for(int i = 0; i < list_pdc.size()-1; i++) {
			int x=(int) ((1-t)*list_pdc.get(i).getX() + t*list_pdc.get(i+1).getX());
			int y=(int) ((1-t)*list_pdc.get(i).getY() + t*list_pdc.get(i+1).getY());
			list_pv.add(new Point(x,y));
		}
		return creerCourbe(list_pv,t);
	}
	
	/**
	 * Fonction qui place les points de contrôles d'une courbe de Bézier
	 */
	public static List<Point> createPointCtrl(int largeur, int hauteur) {
		List<Point> list_pdc = new ArrayList<Point>();
		Random r = new Random(); 
		list_pdc.add(new Point(10,largeur-10));
		list_pdc.add(new Point((r.nextInt(largeur)),r.nextInt(hauteur)));
		list_pdc.add(new Point((r.nextInt(largeur)),r.nextInt(hauteur)));
		//TODO

		return list_pdc;
		
		
	}
}
