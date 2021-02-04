package repositories;

public interface ICredentialRepository {
    void addCredential(String username, String password);
    boolean credentialValid(String username, String password);
}