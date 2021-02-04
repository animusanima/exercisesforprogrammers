package application;

import messages.LoginMessage;
import repositories.DemoDataCredentialRepository;
import services.LoginService;
import validation.IPasswordValidator;
import validation.PasswordValidator;

import java.io.Console;
import java.util.Scanner;

public class PasswordValidationExample {

    public static void main(String[] args) {
        IPasswordValidator validator = new PasswordValidator(new DemoDataCredentialRepository());
        LoginService service = new LoginService(validator);
        Scanner s = new Scanner(System.in);
        Console console = System.console();

        System.out.println(LoginMessage.MESSAGE_USERNAME_PROMPT);
        String username = s.next();
        String password;

        if (console == null) {
            System.out.println(LoginMessage.MESSAGE_PASSWORD_PROMPT);
            password = s.next();
        } else {
            char[] passwordArray = console.readPassword(LoginMessage.MESSAGE_PASSWORD_PROMPT);
            password = new String(passwordArray);
        }
        System.out.println(service.login(username, password) ? LoginMessage.MESSAGE_LOGIN_SUCCESSFUL : LoginMessage.MESSAGE_LOGIN_FAILED);
    }
}
