package repositories;

import crypto.CryptoService;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class DemoDataCredentialRepository implements ICredentialRepository {

    private final Map<String, byte[]> credentials;

    private final CryptoService crypto;

    public DemoDataCredentialRepository() {
        crypto = new CryptoService(112);
        credentials = new HashMap<>();

        try {
            crypto.init();
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }

        addCredential("John", "Wick");
        addCredential("Alan", "Wake");
        addCredential("Super", "Mario");
    }

    @Override
    public void addCredential(String username, String password) {
        try {
            credentials.put(username, crypto.encrypt(password));
        } catch (BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean credentialValid(String username, String password) {
        byte[] encryptedPassphrase = credentials.get(username);

        String decryptedPhrase = "";
        try {
            decryptedPhrase = new String(crypto.decrypt(encryptedPassphrase));
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return credentials.containsKey(username) && decryptedPhrase.equals(password);
    }
}
