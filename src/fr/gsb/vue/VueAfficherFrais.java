//commencement de la vueAfficherFrais
package fr.gsb.vue;

import java.awt.BorderLayout;
import javax.swing.*;
/*
import utiliser:
-import javax.swing.JComboBox;
-import javax.swing.JPanel;
-import javax.swing.JScrollPane;
-import javax.swing.JTable;
*/
@SuppressWarnings("serial")

public class VueAfficherFrais extends JPanel {
	private JScrollPane scroll;
	private JTable table;
	private String[] entete;
	private Object [][] donnees;
	private int i;
	private JComboBox listetest;
	public VueAfficherFrais(){
		this.setLayout(new BorderLayout());
	     listetest = new JComboBox();
	     listetest.addItem("super");
	     
		//Ent�te du tableau de contacts
		/*entete = new String[3]; //new string[nb ent�te]
		entete[0] = "NumAvion";
		entete[1] = "NomAvion";
		entete[2] = "NbPlace";
		
		i = 0;
		
		//R�cup�ration des contacts pr�sents dans la liste des contacts
		donnees = new Object[liste.size()][3];
		for () {
			donnees[i][0] =;
			donnees[i][1] = ;
			donnees[i][2] = ;
			i++;
		}*/
		
		//Mise en place du panneau
		/*table = new JTable(donnees, entete);
		
		scroll = new JScrollPane(table);
		
        this.add(scroll, BorderLayout.CENTER);*/
	}
}
