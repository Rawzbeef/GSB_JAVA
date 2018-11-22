package fr.gsb.vue;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fr.gsb.objet.Gsb;

@SuppressWarnings("serial")
public class VueMenu extends JMenuBar {
	
	private JMenu jmComptable;
	private JMenuItem jmiAfficherForfait;

	public VueMenu(Gsb gsb, Vue vue, VueMessage vueMessage) {
		//Comptable
		this.jmComptable = new JMenu("Comptable");
		
		this.jmiAfficherForfait = new JMenuItem("Affichage des forfaits");
		
		this.jmComptable.add(this.jmiAfficherForfait)
		
		this.add(this.jmComptable);
	}

}
