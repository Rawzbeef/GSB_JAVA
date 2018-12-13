//a completer
package fr.gsb.controleur.action;

//import java et javax
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



//import gsb
import fr.gsb.modele.ModeleBDD;
import fr.gsb.objet.FicheFrais;
import fr.gsb.objet.FraisHorsForfait;
import fr.gsb.objet.Visiteur;

public class ActionVueAfficherFrais implements ActionListener{
	//Jtable pour la FicheFrais
	private JTable tableFicheFrais;
	private Object [] donneesFicheFrais;

	//Jtable  pour la FicheHorsForfait
	private JTable tableFicheFraisHorsForfait;
	private Object [] donneesFicheFraisHorsForfait;

	//JScrollPane
	private JScrollPane scrollFicheFrais;
	private JScrollPane scrollFicheFraisHorsForfait;

	//JComboBox
	private JComboBox<String> ComboBoxVisiteur;
	private JComboBox<String> ComboBoxMois;
	private JComboBox<String> ComboBoxAnnees;

	//Les Listes
	private ArrayList<Visiteur> visiteurMois;
	private ArrayList<FicheFrais> lesFicheFrais;
	private ArrayList<FraisHorsForfait> lesFicheFraisHorsForfait;

	// Modele
	private DefaultTableModel unNewModelFicheFrais;
	private DefaultTableModel unNewModelficheHorsForfait;
	
	//autre variable
	private String annees;
	private String mois;
	private String mot;
	private String anneesMois;
	private String idVisiteur;

	public ActionVueAfficherFrais(JComboBox<String> uneComboBoxMois ,JComboBox<String> uneComboBoxAnnees ,JComboBox<String> uneComboBoxVisiteur,String unMot, JLabel unNomVisiteur, JLabel unPrenomVisiteur, JTable uneTable1, JTable uneTable2) {
		this.ComboBoxMois=uneComboBoxMois;
		this.ComboBoxAnnees=uneComboBoxAnnees;
		this.ComboBoxVisiteur=uneComboBoxVisiteur;
		this.mot=unMot;
		this.tableFicheFrais=uneTable1;
		this.tableFicheFraisHorsForfait=uneTable2;
	}

	@Override
	//action performed utiliser par VueAfficherFrais
	public void actionPerformed(ActionEvent event) {
		//switch qui prend en compte l'attribue mot qui est donnée en paramettre
		switch(mot){
		case "Mois":
			String[] tabAnnees = {"2018", "2017", "2016", "2015","2014","2013","2012","2011","2010","2009","2008","2007"};
			ComboBoxAnnees.removeAllItems();
			for(int i=0;i<12;i++){
				ComboBoxAnnees.addItem(tabAnnees[i]);	
			}
			mois=(String)ComboBoxMois.getSelectedItem();
			ComboBoxAnnees.setEnabled(true);
			ComboBoxAnnees.revalidate();

			break;

		case "Annees":
			mois=(String)ComboBoxMois.getSelectedItem();
			annees=(String)ComboBoxAnnees.getSelectedItem();
			anneesMois=annees+mois;

			//creation de la list VisiteurMois et ajoute de variable
			visiteurMois=new ArrayList<>();
			visiteurMois=ModeleBDD.getVisiteursMoisVue(anneesMois);

			//mise a 0 de la listeVisiteur puis ajout du nom et prénom du visiteur
			ComboBoxVisiteur.removeAllItems();
			for(int i=0;i<visiteurMois.size();i++){
				idVisiteur=visiteurMois.get(i).getId();
				ComboBoxVisiteur.addItem(idVisiteur);
			}
			ComboBoxVisiteur.setEnabled(true);
			ComboBoxVisiteur.revalidate();
			break;


		case "Visiteur":
			//enteteFicheFrais
			mois=(String)ComboBoxMois.getSelectedItem();
			annees=(String)ComboBoxAnnees.getSelectedItem();
			anneesMois=annees+mois;
			
			lesFicheFrais=ModeleBDD.getLesFicheFrais((String)ComboBoxVisiteur.getSelectedItem(),anneesMois);
			unNewModelFicheFrais=new DefaultTableModel();
			unNewModelFicheFrais.addColumn("mois");
			unNewModelFicheFrais.addColumn("NbJustificatifs");
			unNewModelFicheFrais.addColumn("MontantValide");
			unNewModelFicheFrais.addColumn("DateModif");
			unNewModelFicheFrais.addColumn("Etat");
			donneesFicheFrais = new Object[5];
			for (FicheFrais unFicheFrais : lesFicheFrais) {
				donneesFicheFrais[0] = unFicheFrais.getMois();
				donneesFicheFrais[1] = unFicheFrais.getNbJustificatifs();
				donneesFicheFrais[2] = unFicheFrais.getDateModif();
				donneesFicheFrais[3] = unFicheFrais.getMontantValide();
				donneesFicheFrais[4] = unFicheFrais.getEtat();
				unNewModelFicheFrais.addRow(donneesFicheFrais);
			}
			tableFicheFrais.setModel(unNewModelFicheFrais);
			
			
			lesFicheFraisHorsForfait=ModeleBDD.getLesFraisHorsForfaits(anneesMois,(String)ComboBoxVisiteur.getSelectedItem());
			unNewModelficheHorsForfait=new DefaultTableModel();
			unNewModelficheHorsForfait=new DefaultTableModel();
			unNewModelficheHorsForfait.addColumn("mois");
			unNewModelficheHorsForfait.addColumn("libelle");
			unNewModelficheHorsForfait.addColumn("date");
			unNewModelficheHorsForfait.addColumn("montant");
			unNewModelficheHorsForfait.addColumn("etat");
			donneesFicheFraisHorsForfait= new Object[5];
			for (FraisHorsForfait unFraisHorsForfait : lesFicheFraisHorsForfait) {
				donneesFicheFraisHorsForfait[0] = unFraisHorsForfait.getMois();
				donneesFicheFraisHorsForfait[1] = unFraisHorsForfait.getLibelle();
				donneesFicheFraisHorsForfait[2] = unFraisHorsForfait.getDate();
				donneesFicheFraisHorsForfait[3] = unFraisHorsForfait.getMontant();
				donneesFicheFraisHorsForfait[4] = unFraisHorsForfait.getEtat();
				unNewModelficheHorsForfait.addRow(donneesFicheFraisHorsForfait);
			}
			tableFicheFraisHorsForfait.setModel(unNewModelficheHorsForfait);



			break;
		}
	}
}
