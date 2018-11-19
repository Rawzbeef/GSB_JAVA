package fr.gsb.vue;

import javax.swing.*;

import fr.gsb.objet.*;;

public class Vue extends JFrame{
	
	private VueConnexion panel;
	
	public Vue(Gsb gsb, VueMessage vueMsg) {
	
		this.setTitle("Application GSB");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setResizable(false);	
		
		panel = new VueConnexion(gsb, this, vueMsg);
		
		this.getContentPane().add(panel);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	
	}
}
