package fr.gsb.controleur.action;

import java.awt.event.*;

import javax.swing.*;

import fr.gsb.vue.*;
import fr.gsb.objet.*;
import fr.gsb.modele.*;

public class ActionMenu implements ActionListener {
	
	private Vue vue;
	private VueMessage vueMsg;
	private Gsb gsb;

	
	public ActionMenu(Gsb gsb, Vue vue, VueMessage vueMsg, JTextField jtfIdentifiant, JTextField jtfMdp) {
		this.gsb = gsb;
		this.vue = vue;
		this.vueMsg = vueMsg;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vueMsg.reset();
		vue.getContentPane().removeAll();
		vue.getContentPane().add(new VueAfficherFrais()).revalidate();
	}
}