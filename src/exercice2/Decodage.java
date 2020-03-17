package exercice2;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.security.*;

public class Decodage {
    private PrivateKey privateKey;

    public Decodage() {
        this.privateKey = null;
    }

    public PublicKey createRSA() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair keypair = keyGen.genKeyPair();
        PrivateKey clePrivee = keypair.getPrivate();
        this.privateKey = clePrivee;
        PublicKey clePublique = keypair.getPublic();
        return clePublique;
    }

    public byte[] decodeRSA(Cipher cipher, byte[] cipherText) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, this.privateKey);
        byte[] decryptedKey = cipher.doFinal(cipherText);
        return decryptedKey;
    }

    public static void decodePlainText(Cipher cipherText, byte[] textEncrypted, Key decryptKey) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipherText.init(Cipher.DECRYPT_MODE, decryptKey);
        byte[] plainText = cipherText.doFinal(textEncrypted);
        System.out.println(new String(plainText));
    }
}
