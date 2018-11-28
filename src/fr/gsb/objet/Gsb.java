package fr.gsb.objet;

import java.util.ArrayList;

import fr.gsb.modele.ModeleBDD;

public class Gsb {
	private ArrayList<String> lesVisiteur;
	public Gsb() {
		this.lesVisiteur=ModeleBDD.initLesVisiteur();
	}
}
