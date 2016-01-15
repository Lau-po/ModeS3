package vue;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import resources.Planets;
import modele.Gravite;
import modele.ObservableModele;
import controller.Controller;

public class StartPanel extends JPanel implements Observer {
	private JFrame frame;
	JLabel head;
	JComboBox<Planets> options;
	JButton validation;
	private ObservableModele modele;
	private Controller controller;

	public StartPanel(ObservableModele modele, Controller controller) {
		// TODO Auto-generated constructor stub
		super(new FlowLayout());
		this.modele = modele;
		this.controller = controller;
		/**Frame*/
		frame = new JFrame("Menu");
		frame.setResizable(false);
		frame.setSize(new Dimension(300, 500));
		this.setSize(frame.getSize());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**Component*/
		head = new JLabel("Choisissez une planète");
		options = new JComboBox<Planets>(Planets.values());
		options.setPreferredSize(new Dimension(this.getWidth(),50));
		validation = new JButton("Démarrer");
		validation.setPreferredSize(new Dimension(this.getWidth(),50));
		/**Add*/
		frame.add(this);		
		this.add(head);
		this.add(options);
		this.add(validation);
		/**Visibility*/
		frame.setVisible(true);
		this.setVisible(frame.isVisible());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		StartPanel p = new StartPanel(new Gravite(), new Controller());
	}

}
