package principal;

import ihm.Affichage;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import technique.Calcul;

public class Main {
	public static void main(String[] args) {
		/** Création des variables **/
		//int hauteur = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		//int largeur  = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		
		int hauteur = 500;
		int largeur = 500;
		boolean debug = true;
		
		Affichage test = new Affichage(largeur,hauteur);
		
		List<Point> list_pdc = Calcul.createPointCtrl(largeur, hauteur);
		List<Point> courbe = new ArrayList<Point>();
		for(float i = 0; i <= 1; i+=0.01) {
			courbe.add(Calcul.creerCourbe(list_pdc, i));
		}
		if(debug) {
			test.afficheCourbe(list_pdc,Color.black);
		}
		test.afficheCourbe(courbe,Color.red);
		
	}
}
