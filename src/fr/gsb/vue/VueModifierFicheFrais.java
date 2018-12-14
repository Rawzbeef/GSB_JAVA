package fr.gsb.vue;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.gsb.controleur.action.ActionModifierFicheFrais;
import fr.gsb.modele.Modele;
import fr.gsb.modele.ModeleBDD;
import fr.gsb.objet.FicheFrais;
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
	private JButton jbValider;
	private VueValiderHorsForfait vueValiderHorsForfait;
	
	
	

	public VueModifierFicheFrais(Gsb gsb, Vue vue, VueMessage vueMsg) {
		this.setLayout(new BorderLayout());
		
		this.jlMois = new JLabel("Mois : ");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		ArrayList<String> list = ModeleBDD.getLesMois();
		String[] tab = Modele.toTab(list);
		this.jcbMois = new JComboBox<String>(tab);
		
		this.jlVisiteur = new JLabel("Visiteurs : ");
		this.jcbVisiteur = new JComboBox<String>();
		this.jcbVisiteur.setEnabled(false);
		
		this.jtfForfaisEtape = new JTextField();
		this.jtfForfaisEtape.setPreferredSize(new Dimension(100, 20));
		
		this.jtfFraisKilométrique = new JTextField();
		this.jtfFraisKilométrique.setPreferredSize(new Dimension(100, 20));
		
		this.jtfNuitéeHôtel = new JTextField();
		this.jtfNuitéeHôtel.setPreferredSize(new Dimension(100, 20));
		
		this.jtfRepasRestaurant = new JTextField();
		this.jtfRepasRestaurant.setPreferredSize(new Dimension(100, 20));
		
		String[] tab2 = {"CL", "RB", "VA"};
		this.jcbEtat = new JComboBox<String>(tab2);
		this.jcbEtat.setPreferredSize(new Dimension(100, 20));
		this.jcbEtat.setEnabled(false);
		
		this.jbValider = new JButton("Valider");
		
		this.jcbMois.addActionListener(new ActionModifierFicheFrais(gsb, vue, this, vueMsg, "Mois", this.jcbMois, this.jcbVisiteur));
		this.jcbVisiteur.addActionListener(new ActionModifierFicheFrais(gsb, vue, this, vueMsg, "Visiteur", this.jcbMois, this.jcbVisiteur));
		this.jbValider.addActionListener(new ActionModifierFicheFrais(gsb, vue, this, vueMsg, "Valider", this.jcbMois, this.jcbVisiteur));
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(5, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 0;
		panel.add(this.jlMois, c);
		c.gridx++;
		panel.add(this.jcbMois, c);
		c.gridx++;
		panel.add(this.jlVisiteur, c);
		c.gridx++;
		c.gridwidth = 2;
		panel.add(this.jcbVisiteur, c);
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 1;
		panel.add(this.jtfForfaisEtape, c);
		c.gridx++;
		panel.add(this.jtfFraisKilométrique, c);
		c.gridx++;
		panel.add(this.jtfNuitéeHôtel, c);
		c.gridx++;
		panel.add(this.jtfRepasRestaurant, c);
		c.gridx++;
		panel.add(this.jcbEtat, c);
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 5;
		panel.add(this.jbValider);
		
		this.vueValiderHorsForfait = new VueValiderHorsForfait(vue, vueMsg);
		this.add(panel, BorderLayout.NORTH);
		this.add(this.vueValiderHorsForfait, BorderLayout.CENTER);
		
		
	}
	
	public VueValiderHorsForfait getVueValiderHorsForfait() {
		return this.vueValiderHorsForfait;
	}

	public void afficheFrais() {
		ArrayList<String> lignesfrais = ModeleBDD.getLigneFrais(Modele.concatPremierMot(this.jcbVisiteur.getSelectedItem().toString()), Modele.dateFrancaisVersNormal(this.jcbMois.getSelectedItem().toString()));
		
		ArrayList<FicheFrais> ficheFrais = ModeleBDD.getLesFicheFrais(Modele.concatPremierMot(this.jcbVisiteur.getSelectedItem().toString()), Modele.dateFrancaisVersNormal(this.jcbMois.getSelectedItem().toString()));
		
		this.jtfForfaisEtape.setText(lignesfrais.get(0));
		this.jtfFraisKilométrique.setText(lignesfrais.get(1));
		this.jtfNuitéeHôtel.setText(lignesfrais.get(2));
		this.jtfRepasRestaurant.setText(lignesfrais.get(3));
		this.jcbEtat.setEnabled(true);
		this.jcbEtat.setSelectedItem(ficheFrais.get(0).getEtat());
	}

	public int getETP() {
		return Integer.parseInt(this.jtfForfaisEtape.getText());
	}
	
	public int getKM() {
		return Integer.parseInt(this.jtfFraisKilométrique.getText());
	}
	
	public int getNUI() {
		return Integer.parseInt(this.jtfNuitéeHôtel.getText());
	}
	
	public int getREP() {
		return Integer.parseInt(this.jtfRepasRestaurant.getText());
	}
	
	public String getEtat() {
		return this.jcbEtat.getSelectedItem().toString();
	}
}
