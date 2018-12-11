package fr.gsb.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import fr.gsb.modele.Modele;
import fr.gsb.objet.FraisHorsForfait;
import fr.gsb.controleur.action.ActionModifierEtatHF;

public class VueValiderHorsForfait extends JPanel {
	
	// Attributs privés de la classe
	private ArrayList<FraisHorsForfait> lesFrais;
	private JLabel jlTitre;
	private JTable tableau;
	private JScrollPane scroll;
	private JPanel panel;
	private JPanel panelGrid;
	private JLabel jlNbFrais;
	private JButton jbModifier;

	
	// Constructeur de la vue
	public VueValiderHorsForfait(Vue vue, VueMessage vueMsg, ArrayList<FraisHorsForfait> lesFraisHorsForfait) {
		
		this.lesFrais = lesFraisHorsForfait;
		
		this.jlTitre = new JLabel("Descriptif des éléments hors forfait");
		this.add(jlTitre);
		
		Dimension taille = new Dimension(300, 20);
		
		// Creation du tableau
		Object data[][] = new Object[lesFrais.size()][5];
		int i = 0;
		for (FraisHorsForfait f : lesFrais) {
			data[i][0] = f.getId();
			data[i][1] = Modele.dateAnglaisVersFrancais(f.getDate());
			data[i][2] = f.getLibelle();
			data[i][3] = f.getMontant();
			data[i][4] = f.getLibelleEtat(f.getEtat());
			i++;
		}

		String[] title = {"Num", "Date", "Libellé", "Montant", "Situation"};
		this.tableau = new JTable(data, title);
		// Taille par défaut selon le nombre de lignes
		if (lesFrais.size() < 5) {
			this.tableau.setPreferredScrollableViewportSize(new Dimension(600, 16*i));
		}
		else {
			this.tableau.setPreferredScrollableViewportSize(new Dimension(600, 80));
		}
		
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
		jlNbFrais = new JLabel("Nombre total de frais hors forfait : " + lesFrais.size(), JLabel.CENTER);
		jlNbFrais.setPreferredSize(taille);
		panel.add(jlNbFrais);
		
		// Bouton pour modifier la situation des fiches hors forfait
		this.jbModifier = new JButton("Modifer la situation");
		panel.add(jbModifier);
		
		panelGrid.add(panel);
		panelGrid.add(vueMsg);
		
		this.add(panelGrid);
		
		this.jbModifier.addActionListener(new ActionModifierEtatHF(vue, vueMsg, this.tableau));
		
		
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
