package repositories;

import crypto.CryptoService;
import org.apache.commons.lang3.StringUtils;

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

        addCredential("John", "Wick");
    }

    @Override
    public void addCredential(String username, String password) {
        try {
            validateCredentials(username, password);
            credentials.put(username, crypto.encrypt(password));
        } catch (BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean credentialValid(String username, String password) {
        validateCredentials(username, password);
        return (isUserNameValid(username) && isPasswordValid(username, password));
    }

    private void validateCredentials(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("Username or password need to be provided.");
        }
    }

    private boolean isPasswordValid(String username, String password) {
        return Arrays.equals(credentials.get(username), password.getBytes(StandardCharsets.UTF_8));
    }

    private boolean isUserNameValid(String username) {
        return credentials.containsKey(username);
    }
}
