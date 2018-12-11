package fr.gsb.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import fr.gsb.controleur.action.ActionModifierFicheFrais;
import fr.gsb.modele.Modele;
import fr.gsb.modele.ModeleBDD;
import fr.gsb.objet.Gsb;

@SuppressWarnings("serial")
public class VueModifierFicheFrais extends JPanel {
	
	private JLabel jlMois;
	private JComboBox<String> jcbMois;
	
	private JLabel jlVisiteur;
	private JComboBox<String> jcbVisiteur;
	
	private JTextField jtfForfaisEtape;
	private JTextField jtfFraisKilométrique;
	private JTextField jtfNuitéeHôtel;
	private JTextField jtfRepasRestaurant;
	private JComboBox<String> jcbEtat;
	
	

	public VueModifierFicheFrais(Gsb gsb, Vue vue, VueMessage vueMsg) {
		this.setLayout(new GridBagLayout());
		
		this.jlMois = new JLabel("Mois : ");
		
		ArrayList<String> list = ModeleBDD.getLesMois();
		String[] tab = Modele.toTab(list, "AAAAMM");
		this.jcbMois = new JComboBox<String>(tab);
		
		this.jlVisiteur = new JLabel("Visiteurs : ");
		this.jcbVisiteur = new JComboBox<String>();
		this.jcbVisiteur.setEnabled(false);
		
		JPanel panelTable = new JPanel();
		JPanel panelCell1 = new JPanel();
		JPanel panelCell2 = new JPanel();
		JPanel panelCell3 = new JPanel();
		JPanel panelCell4 = new JPanel();
		JPanel panelCell5 = new JPanel();
		
		panelCell1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		panelCell2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		panelCell3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		panelCell4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		panelCell5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		
		this.jtfForfaisEtape = new JTextField();
		this.jtfForfaisEtape.setPreferredSize(new Dimension(100, 20));
		
		this.jtfFraisKilométrique = new JTextField();
		this.jtfFraisKilométrique.setPreferredSize(new Dimension(100, 20));
		
		this.jtfNuitéeHôtel = new JTextField();
		this.jtfNuitéeHôtel.setPreferredSize(new Dimension(100, 20));
		
		this.jtfRepasRestaurant = new JTextField();
		this.jtfRepasRestaurant.setPreferredSize(new Dimension(100, 20));
		
		this.jcbEtat = new JComboBox<String>();
		this.jcbEtat.setPreferredSize(new Dimension(100, 20));
		
		panelCell1.add(this.jtfForfaisEtape);
		panelCell2.add(this.jtfFraisKilométrique);
		panelCell3.add(this.jtfNuitéeHôtel);
		panelCell4.add(this.jtfRepasRestaurant);
		panelCell5.add(this.jcbEtat);
		
		panelTable.add(panelCell1);
		panelTable.add(panelCell2);
		panelTable.add(panelCell3);
		panelTable.add(panelCell4);
		panelTable.add(panelCell5);
		
		this.jcbMois.addActionListener(new ActionModifierFicheFrais(gsb, vue, vueMsg, "Mois", this.jcbMois, this.jcbVisiteur));
		this.jcbVisiteur.addActionListener(null);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(5, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 0;
		this.add(this.jlMois, c);
		c.gridx++;
		this.add(this.jcbMois, c);
		c.gridx++;
		this.add(this.jlVisiteur, c);
		c.gridx++;
		this.add(this.jcbVisiteur, c);
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 4;
		this.add(panelTable, c);
	}
}
