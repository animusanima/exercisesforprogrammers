import validation.IPasswordValidator;

public class AlwaysTruePasswordValidator implements IPasswordValidator {

    @Override
    public boolean isValid(String username, String password) {
        return true;
    }
}
