package vue;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import modele.Modele;
import modele.ObservableModele;
import controller.Controller;

public class StartPanel extends JPanel implements Observer {
	private JFrame frame;
	JLabel head;
	JComboBox<Planets> options;
	JButton validation;
	ActionListener listener;
	private ObservableModele modele;
	private Controller controller;
	boolean open;

	public StartPanel(ObservableModele modele) {
		// TODO Auto-generated constructor stub
		super(new FlowLayout());
		this.modele = modele;
		/**Frame*/
		frame = new JFrame("Menu");
		frame.setResizable(false);
		frame.setSize(new Dimension(300, 170));
		this.setSize(frame.getSize());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		/**Component*/
		head = new JLabel("Choisissez une planète / un satellite");
		options = new JComboBox<Planets>(Planets.values());
		options.setPreferredSize(new Dimension(this.getWidth(),50));
		validation = new JButton("Démarrer");
		validation.setPreferredSize(new Dimension(this.getWidth(),50));
		createListener();
		validation.addActionListener(listener);
		/**Add*/
		frame.add(this);		
		this.add(head);
		this.add(options);
		this.add(validation);
		/**Visibility*/
		frame.setVisible(true);
		this.setVisible(frame.isVisible());
		open = true;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	private void createListener() {
		// TODO Auto-generated method stub
		listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				update(modele, null);
				frame.dispose();
			}
		};
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(arg0 instanceof Modele){
			//((Gravite) modele).setG(((Planets) options.getSelectedItem()).getGravity()); 
			((Gravite) modele).setChoosed(true);
			((Gravite) modele).setP(((Planets) options.getSelectedItem()));;
			this.setOpen(false);
			modele.hasChanged();
			modele.notifyObservers();
		}
	}

	public static void main(String[] args) {
		StartPanel p = new StartPanel(new Gravite());
		
	}

}
