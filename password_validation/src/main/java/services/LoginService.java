package services;

import validation.IPasswordValidator;
import validation.PasswordValidator;

public class LoginService implements ILoginService {
    private final IPasswordValidator validator;

    public LoginService() {
        this(new PasswordValidator());
    }

    public LoginService(IPasswordValidator validator) {
        this.validator = validator;
    }

    @Override
    public boolean login(String username, String password) {
        return validator.isValid(username, password);
    }
}