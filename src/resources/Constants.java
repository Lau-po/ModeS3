package resources;

import java.io.IOException;
import java.util.Properties;

public class Constants {
     
     private static Properties props;

     static {
          props = new Properties();
          try {
               props.load(Constants.class.getClassLoader().getResourceAsStream("resources/constant.prop"));
          } catch (IOException e) {
               e.printStackTrace();
          }
     }
     
     /*
      * BEZIER.JAVA PROPERTIES
      */    
     
     public static final double PAS = Double.parseDouble(props.getProperty("pas"));
     
     /*
      * MAIN.JAVA PROPERTIES
      */ 
     
     public static final int NBR_SIMULATION = Integer.parseInt(props.getProperty("nbrSimul"));
     
     public static void main(String[] args) {
		System.out.println(PAS + " " + NBR_SIMULATION);
	}
     
}
