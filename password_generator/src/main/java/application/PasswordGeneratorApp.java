package application;

import org.apache.commons.lang3.StringUtils;
import services.IPasswordGeneratorService;
import services.IPrinterService;
import services.PasswordGeneratorService;
import services.PrinterService;
import utils.ClipboardUtils;

import java.util.List;
import java.util.Scanner;

public class PasswordGeneratorApp {

    public static void main(String[] args) {
        IPasswordGeneratorService generatorService = new PasswordGeneratorService();
        IPrinterService printerService = new PrinterService();
        Scanner scanner = new Scanner(System.in);

        System.out.print(printerService.askForMinimumLength());
        int minimumPasswordLength = Integer.parseInt(scanner.next());

        System.out.print(printerService.askForAmountOfSpecialCharacters());
        int amountOfSpecialCharacters = Integer.parseInt(scanner.next());

        System.out.print(printerService.askForAmountOfNumbers());
        int amountOfNumberCharacters = Integer.parseInt(scanner.next());

        System.out.print("How many different passwords do you want? ");
        int amountOfDifferentPasswords = Integer.parseInt(scanner.next());

        generatorService.setDesiredPasswordLength(minimumPasswordLength);
        generatorService.setDesiredAmountOfSpecialCharacters(amountOfSpecialCharacters);
        generatorService.setDesiredAmountOfNumberCharacters(amountOfNumberCharacters);

        if (amountOfDifferentPasswords > 1) {
            StringBuilder passwords = new StringBuilder();
            System.out.println("Start password generation...");
            generatedAmountOfDifferentPasswords(generatorService, amountOfDifferentPasswords, passwords);
            printDifferentPasswords(minimumPasswordLength, passwords);
        } else if (amountOfDifferentPasswords == 1){
            String generatedPassword = generatorService.generatePassword();
            System.out.println(PrinterService.SUCCESS_MESSAGE);

            System.out.println("Copy password to clipboard..");
            ClipboardUtils.copyToClipBoard(generatedPassword);
            System.out.println("Password copied to clipboard");
        }
    }

    private static void printDifferentPasswords(int minimumPasswordLength, StringBuilder passwords) {
        System.out.println("These are your passwords:");
        System.out.println(StringUtils.repeat("-", minimumPasswordLength));
        System.out.println(passwords.toString());
        System.out.println(StringUtils.repeat("-", minimumPasswordLength));
    }

    private static void generatedAmountOfDifferentPasswords(IPasswordGeneratorService generatorService, int amountOfDifferentPasswords, StringBuilder passwords) {
        List<String> generatedPasswords = generatorService.generatePasswords(amountOfDifferentPasswords);
        for (int i = 0; i < generatedPasswords.size(); i++) {
            String password = generatedPasswords.get(i);
            if (i+1 < amountOfDifferentPasswords) {
                passwords.append(password).append("\n");
            } else {
                passwords.append(password);
            }
        }
    }
}