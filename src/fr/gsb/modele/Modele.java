package fr.gsb.modele;

import java.security.*;
import java.util.ArrayList;

import fr.gsb.objet.FraisHorsForfait;
import fr.gsb.objet.Gsb;
import fr.gsb.objet.Lignefraisforfait;

public class Modele {
	
	private static Gsb gsb;
	
	/**
	 * Crypte un mot de passe et le retourne
	 * 
	 * @param mdp
	 * @return generatedPassword Le mot de passe crypté en MD5
	 */
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
	 * Convertit une ArrayList en tableau, l'indice 0 contient la variable fournie en paramètre
	 * 
	 * @param list : une liste de chaine de caractère
	 * @return un tableau de chaine
	 */
	public static String[] toTab(ArrayList<String> list) {
		String[] tab = new String[list.size()];
		int i = 0;
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
	public static String dateVersFrancais(String aaamm) {
		String date, mois, annee;
		annee = aaamm.substring(0, 4);
		mois = aaamm.substring(4, 6);
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
			str = str.substring(0, i);
		}
		return str;
		}
	/**
	 * Convertit le format date aaaa-mm-jj en jj/mm/aaaa
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
	
	/**
	 * Convertit le format date mm/aaaa en aaaamm
	 * 
	 * @param laDate
	 * @return date
	 */
	public static String dateFrancaisVersNormal(String laDate) {
		String date, mois, annee;
		mois = laDate.substring(0, 2);
		annee = laDate.substring(3, 7);
		date = annee + mois;
		return date;
	}
	
	/**
	 * Calcul le montant valide de la fiche de frais
	 * 
	 * @param tabQuantite
	 * @param tabMontant
	 * @param tabHorsForfait
	 * @return
	 */
	public static double calculMontantValide(ArrayList<Lignefraisforfait> tabQuantite, ArrayList<Double> tabMontant, ArrayList<FraisHorsForfait> tabHorsForfait) {
		double total = 0;
		double montant = 0;
		for (int i = 0; i < tabMontant.size(); i++) {
			montant = tabMontant.get(i) * tabQuantite.get(i).getQuantite();
			total = total + montant;
		}
		for (FraisHorsForfait unMontantHF : tabHorsForfait) {
			total = total + unMontantHF.getMontant();
		}
		return total;
	}
}

