package fa.training.utils;

public class Validator {
    public boolean isValidYear(int year) {
        if (year < 1900) {
            return false;
        }
        return true;
    }
    public boolean isValidIsbn(String isbn) {
        String regex = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){0,})?$)[\\d-]+$";
        if (isbn.matches(regex)) {
            return true;
        }
        return false;
    }
}
