//commencement de la vueAfficherFrais
package fr.gsb.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
/*
import utiliser:
-import javax.swing.JComboBox;
-import javax.swing.JPanel;
-import javax.swing.JScrollPane;
-import javax.swing.JTable;
 */
@SuppressWarnings("serial")

public class VueAfficherFrais extends JPanel implements ItemListener{
	//JComboBox
	private JComboBox listeVisiteur;
	private JComboBox listeMois;
	//JPanel
	private JPanel JPNorth;
	private JPanel JPdown;
	
	// mettre private ArrayList<Visiteur> LesVisiteurs
	
	public VueAfficherFrais(){
		this.setLayout(new BorderLayout());
		JPNorth = new JPanel();
		
		//listeVisiteur
		listeVisiteur = new JComboBox();
		String[] tab = {"Option 1", "Option 2", "Option 3", "…"};
		listeVisiteur = new JComboBox(tab);
		
		ItemListener itemListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {
		        System.out.println("Item: " + itemEvent.getItem());
		      }
		    };
		    listeVisiteur.addItemListener(itemListener);
		    listeVisiteur.setPreferredSize(new Dimension(100,20));
			JPNorth.add(this.listeVisiteur);
		
		//listMois
		listeMois = new JComboBox();
		String[] tab2 = {"Option 1", "Option 2", "Option 3", "…"};
		listeMois = new JComboBox(tab);
		listeMois.setPreferredSize(new Dimension(100,20));
		JPNorth.add(this.listeMois);
		
		
		//ajout dans le PanelPrinciapl
		this.add(JPNorth, BorderLayout.NORTH);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
