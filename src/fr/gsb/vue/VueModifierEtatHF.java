package fr.gsb.vue;

import java.awt.*;

import javax.swing.*;

import fr.gsb.controleur.action.ActionEtatAJour;

public class VueModifierEtatHF extends JFrame {
	
	private JPanel panelGlobal;
	
	private JPanel panel;
	private JLabel jlTitre;
	private JLabel jlNum;
	private JLabel jlDate;
	private JLabel jlLibelle;
	private JLabel jlMontant;
	private JLabel jlEtatActuel;
	
	private JPanel panel2;
	private JLabel jlTitre2;
	private JLabel jlEtat;
	private JComboBox jcbEtat;
	private JButton jbValider;

	public VueModifierEtatHF(VueMessage vueMsg, String num, String date, String lib, String montant, String etat) {
		
		// Paramètre de la fenêtre
		this.setTitle("Modification de l'état de la ligne");
	
		this.setSize(400, 300);
		this.setResizable(false);
		
		// Instanciation des éléments du premier panel
		this.panel = new JPanel();
		this.jlTitre = new JLabel("Information de l'élément hors forfait");
		this.jlNum = new JLabel("N° : " + num);
		this.jlDate = new JLabel("Date : " + date);
		this.jlLibelle = new JLabel("Libellé : " + lib);
		this.jlMontant = new JLabel("Montant : " + montant);
		this.jlEtatActuel = new JLabel("Etat actuel : " + etat);
		
		this.panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(3, 3, 3, 3);
		this.panel.add(jlTitre, c);
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.panel.add(jlNum, c);
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.panel.add(jlDate, c);
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.panel.add(jlLibelle, c);
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.panel.add(jlMontant, c);
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.panel.add(jlEtatActuel, c);
		
		// Instanciation des éléments du deuxieme panel
		this.panel2 = new JPanel();
		this.jlTitre2 = new JLabel("Modification de l'état");
		this.jlEtat = new JLabel("Etat : ");
		String[] listeItems = {"En attente", "Validé", "Refusé"};
		this.jcbEtat = new JComboBox(listeItems);
		this.jbValider = new JButton("Valider");
		
		this.panel2.setLayout(new GridBagLayout());
		GridBagConstraints c2 = new GridBagConstraints();
		
		c2.gridx = 0;
		c2.gridy = 0;
		c2.insets = new Insets(3, 3, 3, 3);
		c2.gridwidth = 2;
		this.panel2.add(jlTitre2, c2);
		c2.gridx = 0;
		c2.gridy++;
		c2.fill = GridBagConstraints.NONE;
		c2.gridwidth = 1;
		this.panel2.add(jlEtat, c2);
		c2.gridx++;
		c2.fill = GridBagConstraints.BOTH;
		this.panel2.add(jcbEtat, c2);
		c2.gridx = 0;
		c2.gridy++;
		c2.fill = GridBagConstraints.NONE;
		c2.gridwidth = 2;
		this.panel2.add(jbValider, c2);
		
		// ActionListener du bouton
		this.jbValider.addActionListener(new ActionEtatAJour(vueMsg, etat, jcbEtat, num));
		
		// Ajout des 2 panels dans le panel global
		this.panelGlobal = new JPanel();
		this.panelGlobal.setLayout(new GridLayout(2,1));
		this.panelGlobal.add(this.panel);
		this.panelGlobal.add(this.panel2);
		
		this.getContentPane().add(panelGlobal);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	

}
