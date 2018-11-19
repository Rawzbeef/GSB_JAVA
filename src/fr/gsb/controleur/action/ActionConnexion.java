package fr.gsb.controleur.action;

import java.awt.event.*;

import javax.swing.*;

import fr.gsb.vue.*;
import fr.gsb.objet.*;
import fr.gsb.modele.*;

public class ActionConnexion implements ActionListener, KeyListener {
	
	private Vue vue;
	private VueMessage vueMsg;
	
	private JTextField jtfIdentifiant;
	private JTextField jtfMdp;
	private Gsb gsb;

	
	public ActionConnexion(Gsb gsb, Vue vue, VueMessage vueMsg, JTextField jtfIdentifiant, JTextField jtfMdp) {
		this.gsb = gsb;
		this.vue = vue;
		this.vueMsg = vueMsg;
		this.jtfIdentifiant = jtfIdentifiant;
		this.jtfMdp = jtfMdp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vueMsg.reset();
		String mdp = Modele.cryptageMd5(jtfMdp.getText());
		if(ModeleBDD.connexionComptable(jtfIdentifiant.getText(), mdp)) {
			vue.getContentPane().removeAll();
			//vue.setJMenuBar(new VueMenu(aero, vue, vueInfo));
			vue.getContentPane().add(new JPanel()).revalidate();
			System.out.println("connecté");
		}
		else {
			vueMsg.addLabelErreur("Les identifiants sont incorrects.");
			vue.getContentPane().revalidate();
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER) {
			vueMsg.reset();
			String mdp = Modele.cryptageMd5(jtfMdp.getText());
			if(ModeleBDD.connexionComptable(jtfIdentifiant.getText(), mdp)) {
				vue.getContentPane().removeAll();
				//vue.setJMenuBar(new VueMenu(aero, vue, vueInfo));
				vue.getContentPane().add(new JPanel()).revalidate();
			}
			else {
				vueMsg.addLabelErreur("Les identifiants sont incorrects.");
				vue.getContentPane().revalidate();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}