package fr.gsb.controleur.action;

import java.awt.event.*;

import javax.swing.*;

import fr.gsb.modele.ModeleBDD;
import fr.gsb.vue.*;

public class ActionEtatAJour implements ActionListener {
	
	private VueMessage vueMsg;
	private String etat;
	private JComboBox jcbEtat;
	private int num;
	
	public ActionEtatAJour(VueMessage vueMsg, String etat, JComboBox listeEtat, String num) {
		this.vueMsg = vueMsg;
		this.etat = etat;
		this.jcbEtat = listeEtat;
		this.num = Integer.parseInt(num);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.vueMsg.reset();
		this.vueMsg.addLabelValider("Situation modifiée : " + this.etat + " >>>>>>>>>>>>>>> " + (String)this.jcbEtat.getSelectedItem());
		String numEtat = String.valueOf(this.jcbEtat.getSelectedIndex());
		ModeleBDD.metAJourEtatHorsForfait(this.num, numEtat);
	}
	
	
}
