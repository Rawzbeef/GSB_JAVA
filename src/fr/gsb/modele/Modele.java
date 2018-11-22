package fr.gsb.modele;

import java.security.*;

public class Modele {
	
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
}

