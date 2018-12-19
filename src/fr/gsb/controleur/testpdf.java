package fr.gsb.controleur;

import java.io.IOException;

import fr.gsb.modele.ModeleBDD;
import fr.gsb.vue.VuePDF;

public class testpdf {

	public static void main(String[] args) {
		new VuePDF("201810", "a131", ModeleBDD.getLesFraisHorsForfaits("201810", "a131"), ModeleBDD.getLesFicheFrais("a131", "201810"), ModeleBDD.getLigneFrais("a131", "201810"));
	}

}
