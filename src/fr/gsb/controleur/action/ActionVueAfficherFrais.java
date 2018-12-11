//a completer
package fr.gsb.controleur.action;

//import
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;

import fr.gsb.modele.ModeleBDD;
import fr.gsb.objet.Visiteur;

public class ActionVueAfficherFrais implements ActionListener{
	private JTable tableFicheFrais;
	private JComboBox<String> listeVisiteur;
	private JComboBox<String> listeMois;
	private JComboBox<String> listeAnnees;
	private String annees;
	private String mois;
	private String mot;
	private String MoisAnnees;
	private String NomPrenom;
	private ArrayList<Visiteur> VisiteurMois;
	
	public ActionVueAfficherFrais(JComboBox<String> unelisteMois ,JComboBox<String> unelisteAnnees ,JComboBox<String> unelisteVisiteur,String unMot) {
		this.listeMois=unelisteMois;
		this.listeAnnees=unelisteAnnees;
		this.listeVisiteur=unelisteVisiteur;
		this.mot=unMot;
		VisiteurMois=new ArrayList<Visiteur>();
	}

	@Override
	//action performed utiliser par VueAfficherFrais
	public void actionPerformed(ActionEvent event) {
		//switch qui prend en compte l'attribue mot qui est donnée en paramettre
		switch(mot){
		case "Mois":
			String[] tabAnnees = {"2018", "2017", "2016", "2015","2014","2013","2012","2011","2010","2009","2008","2007"};
			listeAnnees.removeAllItems();
			for(int i=0;i<12;i++){
				listeAnnees.addItem(tabAnnees[i]);	
			}
			mois=(String)listeMois.getSelectedItem();
			listeAnnees.setEnabled(true);
			listeAnnees.revalidate();
			
			break;

		case "Annees":
			mois=(String)listeMois.getSelectedItem();
			annees=(String)listeAnnees.getSelectedItem();
			MoisAnnees=annees+mois;
			
			//creation de la list VisiteurMois et ajoute de variable
			VisiteurMois=new ArrayList<>();
			VisiteurMois=ModeleBDD.getVisiteursMoisVue(MoisAnnees);
			
			//mise a 0 de la listeVisiteur puis ajout du nom et prénom du visiteur
			listeVisiteur.removeAllItems();
			for(int i=0;i<VisiteurMois.size();i++){
				NomPrenom=VisiteurMois.get(i).getNom()+" "+VisiteurMois.get(i).getPrenom();
				listeVisiteur.addItem(NomPrenom);
			}
			
			listeVisiteur.setEnabled(true);
			listeVisiteur.revalidate();
			break;


		case "Visiteur":
			
			break;
		}
	}
}
