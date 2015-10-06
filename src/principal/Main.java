package principal;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import technique.Calcul;
import ihm.Affichage;

public class Main {
	public static void main(String[] args) {
		/** Création des variables **/
		int hauteur = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int largeur  = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		Affichage test = new Affichage(hauteur,largeur);
		
		List<Point> list_pdc = Calcul.createPointCtrl(largeur, hauteur);
		List<Point> courbe = new ArrayList<Point>();
		for(float i = 0; i <= 1.0; i+=0.1) {
			courbe.add(Calcul.creerCourbe(list_pdc, i));
		}
		test.afficheCourbe(courbe);
		
	}
}
