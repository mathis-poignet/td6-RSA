package exercice2;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        // Récupération de la chaîne à coder
        Scanner sc  = new Scanner(System.in);
        System.out.println("Entrez une chaîne : ");
        String chaine = sc.nextLine();
        byte[] data = chaine.getBytes();

        // Création des différentes clés
        Cipher cipherRSA = Cipher.getInstance("RSA");
        Cipher cipherDES = Cipher.getInstance("DES");
        Key key = Codage.DES();
        byte[] textEncrypted = Codage.codageText(cipherDES, key, data);

        // Décodage de la clé DES à avec la clé publique RSA
        Decodage decodage = new Decodage();
        PublicKey publicKey = decodage.createRSA();
        byte[] cipherText = Codage.codageRSA(cipherRSA, publicKey, key);
        byte[] decryptKey = decodage.decodeRSA(cipherRSA,cipherText);
        SecretKey originalKey = new SecretKeySpec(decryptKey,"DES");

        // Décodage de la chaîne codé initialement
        Decodage.decodePlainText(cipherDES, textEncrypted, originalKey);
    }
}
