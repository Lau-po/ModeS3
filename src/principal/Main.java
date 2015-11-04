package principal;

import Modele.Bezier;
import Vue.Frame;

public class Main {
  public static void main(String[] args) {
    /** Création des variables **/
    // int hauteur = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    // int largeur = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();

    // int hauteur = 500;
    // int largeur = 500;
    // boolean debug = true;
    //
    // Affichage test = new Affichage(largeur, hauteur);
    // Calcul calcul = new Calcul(largeur, hauteur);
    // List<Point> list_pdc = calcul.createPointCtrl();
    // List<Point> courbe = new ArrayList<Point>();
    // List<Obstacle> obstacles = new ArrayList<Obstacle>();
    //
    // for (float i = 0; i <= 1; i += 0.01) {
    // courbe.add(calcul.creerCourbe(list_pdc, i));
    // }
    // Bezier b = new Bezier();
    // System.out.println(courbe);
    // System.out.println(b.getCourbe());
    // System.out.println(courbe.equals(b.getCourbe()));
    // if (debug) {
    // test.afficheCourbe(b.getCourbe(), Color.black);
    // }
    // test.afficheCourbe(courbe, Color.red);
    Bezier b = new Bezier();
    Frame f = new Frame(b, null);
    b.go();
  }
}
