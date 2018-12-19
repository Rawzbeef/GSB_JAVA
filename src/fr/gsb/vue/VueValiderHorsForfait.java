package fr.gsb.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.table.*;

import fr.gsb.controleur.action.ActionModifierEtatHF;

@SuppressWarnings("serial")
public class VueValiderHorsForfait extends JPanel {
	
	// Attributs privés de la classe
	private JLabel jlTitre;
	private JTable tableau;
	private JScrollPane scroll;
	private JPanel panel;
	private JPanel panelGrid;
	private JButton jbModifier;

	
	// Constructeur de la vue
	public VueValiderHorsForfait(Vue vue, VueModifierFicheFrais vueM, VueMessage vueMsg) {
		
		this.jlTitre = new JLabel("Descriptif des éléments hors forfait");
		this.add(jlTitre);
		
		Dimension taille = new Dimension(300, 20);
		
		// Creation du tableau
		Object data[][] = new Object[0][5];

		String[] title = {"Num", "Date", "Libellé", "Montant", "Situation"};
		this.tableau = new JTable(data, title);
		// Taille par défaut
		this.tableau.setPreferredScrollableViewportSize(new Dimension(600, 0));
		
		DefaultTableModel tableModel = new DefaultTableModel(data, title) { // Création d'un nouveau modèle pour éditer la méthode
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		this.tableau.setModel(tableModel);
		centrerTable(this.tableau);
		// Pour empêcher de pouvoir déplacer les colonnes
		this.tableau.getTableHeader().setReorderingAllowed(false);
		// Pour empêcher de pouvoir modifier la taille des colonnes
		this.tableau.getTableHeader().setResizingAllowed(false);
		this.scroll = new JScrollPane(this.tableau);
		this.add(this.scroll);
		
		// Panel pour afficher le nombre de frais hors forfait
		panel = new JPanel();
		panelGrid = new JPanel();
		panelGrid.setLayout(new GridLayout(2,1));
		
		// Bouton pour modifier la situation des fiches hors forfait
		this.jbModifier = new JButton("Modifer la situation");
		this.jbModifier.setPreferredSize(taille);
		panel.add(jbModifier);
		
		panelGrid.add(panel);
		panelGrid.add(vueMsg);
		
		this.add(panelGrid);
		
		this.jbModifier.addActionListener(new ActionModifierEtatHF(vue, vueM, vueMsg, this.tableau));
		
		
	}
	
	public JTable getTableau() {
		return this.tableau;
	}
	
	// Méthode pour centrer les chaines de caractères dans le tableau
	private void centrerTable(JTable table) {     
		DefaultTableCellRenderer custom = new DefaultTableCellRenderer();
		custom.setHorizontalAlignment(JLabel.CENTER);
		for (int i=0 ; i<table.getColumnCount() ; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(custom);
		}
	}
	
}
