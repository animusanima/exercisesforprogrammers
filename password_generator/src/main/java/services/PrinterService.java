package services;

public class PrinterService implements IPrinterService {
    public static final String MINIMUM_LENGTH_QUESTION = "What is the minimum length?";
    public static final String SPECIAL_CHARACTER_QUESTION = "How many special characters?";
    public static final String AMOUNT_OF_NUMBERS_QUESTION = "How many numbers?";

    @Override
    public String askForMinimumLength() {
        return MINIMUM_LENGTH_QUESTION;
    }

    @Override
    public String askForAmountOfSpecialCharacters() {
        return SPECIAL_CHARACTER_QUESTION;
    }

    @Override
    public String askForAmountOfNumbers() {
        return AMOUNT_OF_NUMBERS_QUESTION;
    }
}
