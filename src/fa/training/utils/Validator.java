package fa.training.utils;

public class Validator {

    /**
     * Check if year after 1752
     * @param year an integer value
     * @return true if year after 1752
     */
    public boolean isValidYear(int year) {
        return year > 1752;
    }

    /**
     * Check if valid isbn only contain 10-17 digit and '-' quotes
     * @param isbn a string isbn
     * @return true if isbn only contain 10-17 digit and '-' quotes
     */
    public boolean isValidIsbn(String isbn) {
        String regex = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){0,7})?$)[\\d-]+$";
        return isbn.matches(regex);
    }
}
