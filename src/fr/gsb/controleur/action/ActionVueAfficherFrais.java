//a completer
package fr.gsb.controleur.action;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JComboBox;

public class ActionVueAfficherFrais implements ActionListener{
	public ActionVueAfficherFrais(JComboBox<String> listeVisiteur) {
	}
	@Override
	//action performed utiliser par VueAfficherFrais
	public void actionPerformed(ActionEvent event) {
		JComboBox<String> test=(JComboBox<String>)event.getSource();
		System.out.println(test.getSelectedItem());
		
	}

}
