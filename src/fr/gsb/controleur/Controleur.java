package fr.gsb.controleur;

import fr.gsb.vue.*;
import fr.gsb.objet.*;

public class Controleur {

	public static void main(String[] args) {
		Gsb gsb = new Gsb();
		VueMessage vueMsg = new VueMessage();
		new Vue(gsb, vueMsg);
		
	}

}
