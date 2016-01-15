package resources;

import java.io.IOException;
import java.util.Properties;

/**
 * Classe qui stock les constantes nécessaires au fonctionnement du jeu.
 * 
 * @author Groupe N5
 */

public class Constants {
     
	/** Objet propriété **/
    private static Properties props;
    
    static {
          props = new Properties();
          try {
               props.load(Constants.class.getClassLoader().getResourceAsStream("resources/constant.prop"));
          } catch (IOException e) {
               e.printStackTrace();
          }
     }
     
     /**
      * BEZIER.JAVA PROPERTIES
      **/    
     
     public static final double PAS = Double.parseDouble(props.getProperty("pas"));
     
     /**
      * MAIN.JAVA PROPERTIES
      **/ 
     
     public static final int NBR_SIMULATION = Integer.parseInt(props.getProperty("nbrSimul"));
     
     public static final double PDS_OBSTACLE = Double.parseDouble(props.getProperty("poidsObstacle"));     

     public static final double PDS_OISEAU = Double.parseDouble(props.getProperty("poidsOiseau"));
     
     public static final int TAILLE_PIAF = Integer.parseInt(props.getProperty("tailleOiseau"));
          
     public static final double K = Double.parseDouble(props.getProperty("k"));
     
     public static final double K_OBSTACLE = Double.parseDouble(props.getProperty("kObstacle"));
     

     public static final double GRAVITY_EARTH = Double.parseDouble(props.getProperty("gTerre"));
     public static final double GRAVITY_MOON = Double.parseDouble(props.getProperty("gLune"));
     public static final double GRAVITY_MARS = Double.parseDouble(props.getProperty("gMars"));
     
     /*
      * Fonction main pour la simulation
      * @param args
      
     public static void main(String[] args) {
		System.out.println(PAS + " " + NBR_SIMULATION);
	}*/
}
