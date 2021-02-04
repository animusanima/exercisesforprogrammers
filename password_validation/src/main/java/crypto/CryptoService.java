package crypto;

import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class CryptoService {
    private KeyGenerator keyGen;
    private final int keySize;
    private Cipher cipher;
    private Key key;

    public CryptoService(int keySize) {
        this.keySize = keySize;
    }

    public void init() throws NoSuchAlgorithmException, NoSuchPaddingException {
        keyGen = KeyGenerator.getInstance("DESede");
        keyGen.init(keySize);
        cipher = Cipher.getInstance("DESede");

        generateKey();
    }

    private void generateKey() {
        this.key = keyGen.generateKey();
    }

    public byte[] encrypt(String phrase) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(phrase.getBytes(StandardCharsets.UTF_8));
    }

    public byte[] decrypt(byte[] phrase) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(phrase);
    }
}