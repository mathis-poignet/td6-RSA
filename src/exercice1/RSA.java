package exercice1;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Scanner;

public class RSA {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // Récupération de la chaîne à coder
        Scanner sc  = new Scanner(System.in);
        System.out.println("Entrez une chaîne : ");
        String chaine = sc.nextLine();
        byte[] data = chaine.getBytes();
        // Génération des deux clés
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair keypair = keyGen.genKeyPair();
        PrivateKey clePrivee = keypair.getPrivate();
        PublicKey clePublique = keypair.getPublic();
        // Codage exercice1.RSA
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, clePublique);
        byte[] cipherText = cipher.doFinal(data);
        System.out.println("cipher: " + new String(cipherText));
        // Décodage exercice1.RSA
        cipher.init(Cipher.DECRYPT_MODE, clePrivee);
        byte[] plainText = cipher.doFinal(cipherText);
        System.out.println("plain : " + new String(plainText));
    }
}
