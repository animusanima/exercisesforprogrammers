package validation;

import repositories.CredentialRepository;
import repositories.ICredentialRepository;

public class PasswordValidator implements IPasswordValidator {

    private final ICredentialRepository repository;

    public PasswordValidator() {
        this(new CredentialRepository());
    }

    public PasswordValidator(ICredentialRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValid(String username, String password) {
        return repository.credentialValid(username, password);
    }
}
