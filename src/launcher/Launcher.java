package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
		
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student datosEstudiante = new Student(125630,"Lopez Dousdebes","Juan Francisco",
        				"juanfralop00@gmail.com","https://github.com/JuanFLopez","/images/Avatar.png");
        		SimplePresentationScreen presentacion = new SimplePresentationScreen(datosEstudiante);
        		presentacion.setVisible(true);
            }
        });
    }
}