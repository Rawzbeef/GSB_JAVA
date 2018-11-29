package fr.gsb.objet;

import java.util.ArrayList;

import fr.gsb.modele.ModeleBDD;

public class Gsb {
	
	private ArrayList<String> lesVisiteurs;
	
	public Gsb() {
		this.lesVisiteurs = ModeleBDD.initLesVisiteurs();
	}
}
