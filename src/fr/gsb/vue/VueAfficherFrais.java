//commencement de la vueAfficherFrais
package fr.gsb.vue;

//import
import fr.gsb.controleur.action.ActionVueAfficherFrais;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/*
import utiliser:
-import javax.swing.JComboBox;
-import javax.swing.JPanel;
-import java.awt.BorderLayout;
-import java.awt.Dimension;
-import java.awt.ItemSelectable;
 */
@SuppressWarnings("serial")

public class VueAfficherFrais extends JPanel {
	//JComboBox
	private JComboBox<String> listeVisiteur;
	private JComboBox<String> listeMois;
	private JComboBox<String> listeAnnees;
	
	//label
	private JLabel barre;
	private JLabel NomVisiteur;
	private JLabel PrenomVisiteur;
	
	//JTable1
	private JScrollPane scroll1;
	private JTable tableFicheFrais;
	
	
	//JTable2
	private JScrollPane scroll2;
	private JTable tableFicheHorsForfait;
	
	
	//JPanel
	private JPanel JPNorth;
	private JPanel JPCenter;
	
	//DefaultTableModel ;
	private DefaultTableModel modelFicheFrais;
	private DefaultTableModel modelficheHorsForfait;
	
	
	
	public VueAfficherFrais(){
		this.setLayout(new BorderLayout());
		
		JPNorth = new JPanel();
		JPCenter = new JPanel();
		
		//JLabel
		barre = new JLabel (" / ");
		NomVisiteur=new JLabel ();
		PrenomVisiteur= new JLabel ();
		
		//Partie Jpanel NORTH
		//listAnnees 
		listeAnnees = new JComboBox<String>();
		listeAnnees.setPreferredSize(new Dimension(100,20));
		listeAnnees.setEnabled(false);
		
		
		//listMois 
		String[] tabMois = {"01", "02", "03", "04","05","06","07","08","09","10","11","12"};
		listeMois = new JComboBox<String>(tabMois);
		listeMois.setPreferredSize(new Dimension(100,20));
		
		
		//IdlisteVisiteur
		listeVisiteur = new JComboBox<String>();
		listeVisiteur.setPreferredSize(new Dimension(100,20));
		
		//table 1
		modelFicheFrais =new DefaultTableModel();
		tableFicheFrais= new JTable(modelFicheFrais);
		modelFicheFrais.addColumn("mois");
		modelFicheFrais.addColumn("NbJustificatifs");
		modelFicheFrais.addColumn("MontantValide");
		modelFicheFrais.addColumn("DateModif");
		modelFicheFrais.addColumn("Etat");
		scroll1 = new JScrollPane(tableFicheFrais);
		
		//table2
		modelficheHorsForfait =new DefaultTableModel();
		tableFicheHorsForfait= new JTable(modelficheHorsForfait);
		modelficheHorsForfait.addColumn("mois");
		modelficheHorsForfait.addColumn("libelle");
		modelficheHorsForfait.addColumn("date");
		modelficheHorsForfait.addColumn("montant");
		modelficheHorsForfait.addColumn("etat");
		scroll2 = new JScrollPane(tableFicheHorsForfait);
		
		//ajout dans leJPNorth
		JPNorth.add(this.listeMois);
		JPNorth.add(this.barre);
		JPNorth.add(this.listeAnnees);
		JPNorth.add(this.listeVisiteur);
		
		JPCenter.add(this.scroll1);
		JPCenter.add(this.scroll2);
		
		// ajout action listener
		listeMois.addActionListener(new ActionVueAfficherFrais(listeMois, listeAnnees, listeVisiteur, "Mois", NomVisiteur, PrenomVisiteur, tableFicheFrais, tableFicheHorsForfait));
		listeAnnees.addActionListener(new ActionVueAfficherFrais(listeMois, listeAnnees, listeVisiteur, "Annees", NomVisiteur, PrenomVisiteur, tableFicheFrais, tableFicheHorsForfait));
		listeVisiteur.addActionListener(new ActionVueAfficherFrais(listeMois, listeAnnees, listeVisiteur, "Visiteur", NomVisiteur, PrenomVisiteur, tableFicheFrais, tableFicheHorsForfait));
		
		
		//ajout dans le PanelPrinciapl
		
		this.add(JPNorth, BorderLayout.NORTH);
		this.add(JPCenter, BorderLayout.CENTER);
	}
}

