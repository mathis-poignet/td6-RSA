package exercice2;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class Codage {
    public static Key DES() throws NoSuchAlgorithmException {
        System.out.println("\nGénération clé ... ");
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56); // 56 = valeur imposée
        Key key = keyGen.generateKey();
        System.out.println("Clé générée : " + new String(key.getEncoded()));
        return key;
    }

    public static byte[] codageRSA(Cipher cipher, PublicKey clePublique, Key key) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        System.out.println("Codage clé DES ... ");
        cipher.init(Cipher.ENCRYPT_MODE, clePublique);
        byte[] cipherText = cipher.doFinal(key.getEncoded());
        System.out.println("Clé DES encodée : " + new String(cipherText));
        return cipherText;
    }

    public static byte[] codageText(Cipher cipher, Key key, byte[] text) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        System.out.println("Codage texte ... ");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher.doFinal(text);
        System.out.println("Texte encodé : " + new String(cipherText));
        return cipherText;
    }
}
