package fa.training.utils;

public class Validator {
    public boolean isValidYear(int year) {
        return year > 1752;
    }
    public boolean isValidIsbn(String isbn) {
        String regex = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){0,})?$)[\\d-]+$";
        if (isbn.matches(regex)) {
            return true;
        }
        return false;
    }
}
