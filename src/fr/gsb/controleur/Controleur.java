package fr.gsb.controleur;

import fr.gsb.vue.*;
import fr.gsb.modele.Modele;
import fr.gsb.objet.*;

public class Controleur {

	public static void main(String[] args) {
		Gsb gsb = Modele.getGsb();
		VueMessage vueMsg = new VueMessage();
		new Vue(gsb, vueMsg);
		
	}

}
