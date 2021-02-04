package repositories;

import crypto.CryptoService;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CredentialRepository implements ICredentialRepository {
    private final Map<String, byte[]> credentials;
    private final CryptoService crypto;

    public CredentialRepository() {
        crypto = new CryptoService(112);
        credentials = new HashMap<>();

        try {
            crypto.init();
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
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
        byte[] decryptedPassphrase = credentials.get(username);
        return credentials.containsKey(username) && Arrays.equals(decryptedPassphrase, password.getBytes(StandardCharsets.UTF_8));
    }
}
