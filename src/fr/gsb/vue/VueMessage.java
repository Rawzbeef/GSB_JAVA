package fr.gsb.vue;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VueMessage extends JPanel {

	private String text;
	public static final int RED = 1;

	
	/**
	 * Constructeur de la vue message
	 */
	public VueMessage() {
		this.setText("<html>");
	}

	/**
	 * Ajoute un texte dans un label sur fond rouge pour les erreurs
	 * 
	 * @param La chaine de caractère qui va s'afficher
	 */
	public void addLabelErreur(String string) {
		this.removeAll();
		this.revalidate();
		this.setText(this.getText() + string + "<br>");
		JLabel label = new JLabel(this.getText() + "</html>");
		this.setBackground(new Color(250, 115, 115));
		this.add(label);
	}
	
	/**
	 * Ajoute un texte dans un label sur fond rouge pour les validation ou les messages
	 * 
	 * @param La chaine de caractère qui va s'afficher
	 */
	public void addLabelValider(String string) {
		this.removeAll();
		this.revalidate();
		this.setText(this.getText() + string + "<br>");
		JLabel label = new JLabel(this.getText() + "</html>");
		this.setBackground(new Color(40, 175, 95));
		this.add(label);
	}
	
	/**
	 * Efface la vue et la rend invisible
	 */
	public void reset() {
		this.removeAll();
		this.setText("<html>");
		this.setBackground(new Color(0, 0, 0, 0));
		this.revalidate();
	}

	public String getText() {
		return text;
	}

	private void setText(String text) {
		this.text = text;
	}
}
