//commencement de la vueAfficherFrais

package fr.gsb.vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VueAfficherFrais extends JPanel {
	private JScrollPane scroll;
	private JTable table;
	private String[] entete;
	private Object [][] donnees;
	private int i;
	/*public VueAfficherFrais(ArrayList<> liste){
		this.setLayout(new BorderLayout());
		
		//Entête du tableau de contacts
		entete = new String[3]; //new string[nb entête]
		entete[0] = "NumAvion";
		entete[1] = "NomAvion";
		entete[2] = "NbPlace";
		
		i = 0;
		
		//Récupération des contacts présents dans la liste des contacts
		donnees = new Object[liste.size()][3];
		for (Avion unAvion : liste) {
			donnees[i][0] = unAvion.getNumAvion();
			donnees[i][1] = unAvion.getNomAvion();
			donnees[i][2] = unAvion.getNbPlaces();
			i++;
		}
		
		//Mise en place du panneau
		table = new JTable(donnees, entete);
		
		scroll = new JScrollPane(table);
		
        this.add(scroll, BorderLayout.CENTER);
	}*/
}
