package fr.gsb.vue;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

import fr.gsb.controleur.action.*;
import fr.gsb.objet.*;

@SuppressWarnings("serial")
public class VueConnexion extends JPanel {
	
	private JLabel jlIdentifiant;
	private JTextField jtfIdentifiant;
	private JLabel jlMdp;
	private JPasswordField jtfMdp;
	private JButton jbConnexion;
	
	private Vue vue;
	private VueMessage vueMsg;
	private Gsb gsb;

	public VueConnexion(Gsb gsb, Vue vue, VueMessage vueMsg) {
		vueMsg.reset();
		this.gsb = gsb;
		this.vue = vue;
		this.vueMsg = vueMsg;
		
		
		this.jlIdentifiant = new JLabel("Identifiant :");
		this.jtfIdentifiant = new JTextField();
		this.jtfIdentifiant.setPreferredSize(new Dimension(150, 20));
		
		
		this.jlMdp = new JLabel("Mot de passe :");
		this.jtfMdp = new JPasswordField();
		this.jtfMdp.setPreferredSize(new Dimension(150, 20));
		
		
		this.jbConnexion = new JButton("Connexion");
		this.jbConnexion.setMnemonic(KeyEvent.VK_ENTER);
		
		ActionConnexion actionConnexion = new ActionConnexion(this.gsb, this.vue, this.vueMsg, this.jtfIdentifiant, this.jtfMdp);
		//this.jtfIdentifiant.addKeyListener(actionConnexion);
		//this.jtfMdp.addKeyListener(actionConnexion);
		this.jbConnexion.addActionListener(actionConnexion);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(3, 3, 3, 3);
		this.add(jlIdentifiant, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jtfIdentifiant, c);
		c.gridx = 0;
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jlMdp, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jtfMdp, c);
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 2;
		this.add(vueMsg, c);
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jbConnexion, c);
	}
}
