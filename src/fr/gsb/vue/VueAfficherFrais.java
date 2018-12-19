//commencement de la vueAfficherFrais
package fr.gsb.vue;

//import
import fr.gsb.controleur.action.ActionVueAfficherFrais;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;

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
	private JComboBox<String> ComboBoxListeVisiteur;
	private JComboBox<String> ComboBoxlisteMois;
	private JComboBox<String> ComboBoxlisteAnnees;
	
	//label
	private JLabel barre;
	private JLabel JFraisforfait;
	private JLabel JFicheFrais;
	private JLabel JFicheHorsForfait;
	
	
	//JButton
	private JButton PDF;
	
	//JTable fraisforfait
	private JScrollPane scrollFraisforfait;
	private JTable tableFraisforfait;
	
	//JTableFicheFrais
	private JScrollPane scrollFicheFrais;
	private JTable tableFicheFrais;
	
	
	//JTableFicheHorsForfait
	private JScrollPane scrollFicheHorsForfait;
	private JTable tableFicheHorsForfait;
	
	
	//JPanel
	private JPanel JPNorth;
	private JPanel JPCenter;
	private JPanel JPCenterNorth;
	private JPanel JPCenterSouth;
	private JPanel JPSouth;
	
	//DefaultTableModel 
	private DefaultTableModel modelFraisforfait;
	private DefaultTableModel modelFicheFrais;
	private DefaultTableModel modelFicheHorsForfait;

	
	
	public VueAfficherFrais(){
		this.setLayout(new BorderLayout());
		
		//JPanel
		JPNorth = new JPanel();
		JPNorth.setLayout(new BoxLayout(JPNorth, BoxLayout.LINE_AXIS));
		JPCenter = new JPanel();
		JPCenterNorth= new JPanel();
		JPCenterSouth = new JPanel();
		JPSouth = new JPanel();
		
		//JButton 
		PDF = new JButton("PDF");
		
		//JLabel
		barre = new JLabel (" / ");
		JFraisforfait = new JLabel ("tableau Frais forfait : ");
		JFicheFrais = new JLabel ("tableau fiche frais : ");
		JFicheHorsForfait = new JLabel ("tableau fiche hors forfait : ");
		//Partie Jpanel NORTH
		//listAnnees 
		ComboBoxlisteAnnees = new JComboBox<String>();
		ComboBoxlisteAnnees.setPreferredSize(new Dimension(100,20));
		ComboBoxlisteAnnees.setEnabled(false);
		
		
		//listMois 
		String[] tabMois = {"01", "02", "03", "04","05","06","07","08","09","10","11","12"};
		ComboBoxlisteMois = new JComboBox<String>(tabMois);
		ComboBoxlisteMois.setPreferredSize(new Dimension(100,20));
		
		
		//IdlisteVisiteur
		ComboBoxListeVisiteur = new JComboBox<String>();
		ComboBoxListeVisiteur.setPreferredSize(new Dimension(100,20));
		
		
		//tableFraisforfait
		modelFraisforfait = new DefaultTableModel();
		tableFraisforfait = new JTable(modelFraisforfait);
		modelFraisforfait.addColumn("libele");
		modelFraisforfait.addColumn("montant");
		scrollFraisforfait = new JScrollPane(tableFraisforfait);
		scrollFraisforfait.setPreferredSize(new Dimension(500,90));//permet de changer la taille de la fenetre
		
		//tableFicheFrais
		modelFicheFrais = new DefaultTableModel();
		tableFicheFrais = new JTable(modelFicheFrais);
		modelFicheFrais.addColumn("NbJustificatifs");
		modelFicheFrais.addColumn("MontantValide");
		modelFicheFrais.addColumn("DateModif");
		modelFicheFrais.addColumn("etat");
		scrollFicheFrais = new JScrollPane(tableFicheFrais);
		scrollFicheFrais.setPreferredSize(new Dimension(500,70));
		
		//tableFicheHorsForfait
		modelFicheHorsForfait = new DefaultTableModel();
		tableFicheHorsForfait = new JTable(modelFicheHorsForfait);
		modelFicheHorsForfait.addColumn("libelle");
		modelFicheHorsForfait.addColumn("date");
		modelFicheHorsForfait.addColumn("montant");
		modelFicheHorsForfait.addColumn("etat");
		scrollFicheHorsForfait = new JScrollPane(tableFicheHorsForfait);
		scrollFicheHorsForfait.setPreferredSize(new Dimension(500,200));
		
		
		
		//ajout dans le JPNorth
		JPNorth.add(this.ComboBoxlisteMois);
		JPNorth.add(this.barre);
		JPNorth.add(this.ComboBoxlisteAnnees);
		JPNorth.add(this.ComboBoxListeVisiteur);
		
		
		//ajout dans le JPCenter
		JPCenter.add(JFraisforfait);
		JPCenter.add(this.scrollFraisforfait);
		
		
		//ajout dans le JPCenterNorth
		JPCenterNorth.add(JFicheFrais);
		JPCenterNorth.add(this.scrollFicheFrais);
		
		
		//ajout dans le JPCenterSouth
		JPCenterSouth.add(JFicheHorsForfait);
		JPCenterSouth.add(this.scrollFicheHorsForfait);
		
		//ajout dans le JPCenter
		JPCenter.add(JPCenterNorth, BorderLayout.NORTH);
		JPCenter.add(JPCenterSouth, BorderLayout.SOUTH);
		
		JPSouth.add(PDF);
		// ajout action listener
		ComboBoxlisteMois.addActionListener(new ActionVueAfficherFrais(ComboBoxlisteMois, ComboBoxlisteAnnees, ComboBoxListeVisiteur, "Mois", tableFraisforfait, tableFicheFrais, tableFicheHorsForfait));
		ComboBoxlisteAnnees.addActionListener(new ActionVueAfficherFrais(ComboBoxlisteMois, ComboBoxlisteAnnees, ComboBoxListeVisiteur, "Annees", tableFraisforfait, tableFicheFrais, tableFicheHorsForfait));
		ComboBoxListeVisiteur.addActionListener(new ActionVueAfficherFrais(ComboBoxlisteMois, ComboBoxlisteAnnees, ComboBoxListeVisiteur, "Visiteur", tableFraisforfait, tableFicheFrais, tableFicheHorsForfait));
		this.PDF.addActionListener(new ActionVueAfficherFrais(ComboBoxlisteMois, ComboBoxlisteAnnees, ComboBoxListeVisiteur, "PDF", tableFraisforfait, tableFicheFrais, tableFicheHorsForfait));
		
		//ajout dans le PanelPrinciapl
		
		this.add(JPNorth, BorderLayout.NORTH);
		this.add(JPCenter, BorderLayout.CENTER);
		this.add(JPSouth, BorderLayout.SOUTH);
	}
}

