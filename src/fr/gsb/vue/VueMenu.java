package fr.gsb.vue;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fr.gsb.controleur.action.ActionMenu;
import fr.gsb.objet.Gsb;

@SuppressWarnings("serial")
public class VueMenu extends JMenuBar {
	
	private JMenu jmComptable;
	private JMenuItem jmiAfficherFrais;
	private JMenuItem jmiModifierFrais;

	public VueMenu(Gsb gsb, Vue vue, VueMessage vueMessage) {
		//Comptable
		this.jmComptable = new JMenu("Comptable");
		
		this.jmiAfficherFrais = new JMenuItem("Affichage des frais");
		this.jmiAfficherFrais.addActionListener(new ActionMenu(gsb, vue, vueMessage, "AfficherFrais"));
		
		this.jmiModifierFrais = new JMenuItem("Affichage des frais");
		this.jmiModifierFrais.addActionListener(new ActionMenu(gsb, vue, vueMessage, "ModifierFrais"));
		
		this.jmComptable.add(this.jmiAfficherFrais);
		this.jmComptable.add(this.jmiModifierFrais);
		
		this.add(this.jmComptable);
	}

}
