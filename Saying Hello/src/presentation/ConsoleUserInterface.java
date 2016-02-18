package presentation;

import application.*;
import domain.*;
import java.util.Scanner;

public final class ConsoleUserInterface implements UserInterface {

    public ConsoleUserInterface() {
        scan = new Scanner(System.in);
    }

    @Override
    public String getUserName() {
        System.out.print("What is your name? ");
        final String userName = scan.nextLine();
        return userName;
    }

    @Override
    public void displayGreeting(UserGreeting greeting) {
        System.out.println(greeting.getGreeting());
    }

    private final Scanner scan;
}
