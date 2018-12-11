package fr.gsb.modele;

import java.security.*;
import java.util.ArrayList;

import fr.gsb.objet.Gsb;

public class Modele {
	
	private static Gsb gsb;
	
	/**
	 * Crypte un mot de passe et le retourne
	 * 
	 * @param mdp
	 * @return generatedPassword Le mot de passe crypt� en MD5
	 */
	public static String cryptageMd5(String mdp) {
        String passwordToHash = mdp;
        String generatedPassword = null;
        try {
            // Instance pour MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            // Conversion en format hexad�cimal
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // Mot de passe crypt� g�n�r�
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	
	/**
	 * Instancie l'objet GSB initial
	 * 
	 * @return gsb
	 */
	public static Gsb getGsb() {
		gsb = new Gsb();
		return gsb;
	}
	
	/**
	 * Convertit une ArrayList en tableau, l'indice 0 contient la variable fournie en param�tre
	 * 
	 * @param list : une liste de chaine de caract�re
	 * @return un tableau de chaine
	 */
	public static String[] toTab(ArrayList<String> list, String chaine) {
		String[] tab = new String[list.size()+1];
		tab[0] = chaine;
		int i = 1;
		for(String str : list) {
			tab[i] = str;
			i++;
		}
		return tab;
	}
	
	/**
	 * Convertit le format date aaaamm en mm/aaaa
	 * 
	 * @param laDate
	 * @return date
	 */
	public static String dateVersFrancais(String laDate) {
		String date, mois, annee;
		annee = laDate.substring(0, 4);
		mois = laDate.substring(4, 6);
		date = mois + "/" + annee;
		return date;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String concatPremierMot(String str) {
		int i = 0;
		while(i < str.length() && str.charAt(i) != ' ') {
			i++;
		}
		if(i < str.length() && str.charAt(i) == ' ') {
			str = str.substring(0, i-1);
		}
		return str;
		}
	/**
	 * Convertit le format date aaaa-mm-jj en jj-mm/aaaa
	 * 
	 * @param laDate
	 * @return date
	 */
	public static String dateAnglaisVersFrancais(String laDate) {
		String date, mois, annee, jour;
		annee = laDate.substring(0, 4);
		mois = laDate.substring(5, 7);
		jour = laDate.substring(8, 10);
		date = jour + "/" + mois + "/" + annee;
		return date;
	}
}

