package fr.gsb.modele;

import java.security.*;
import java.util.ArrayList;

import fr.gsb.objet.Gsb;

public class Modele {
	
	private static Gsb gsb;
	
	public static String cryptageMd5(String mdp) {
        String passwordToHash = mdp;
        String generatedPassword = null;
        try {
            // Instance pour MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            // Conversion en format hexadécimal
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // Mot de passe crypté généré
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	
	public static Gsb getGsb() {
		gsb = new Gsb();
		return gsb;
	}
	
	public static String[] toTab(ArrayList<String> list) {
		String[] tab = new String[list.size()+1];
		tab[0] = "";
		int i = 1;
		for(String str : list) {
			tab[i] = str;
			i++;
		}
		return tab;
	}
}

