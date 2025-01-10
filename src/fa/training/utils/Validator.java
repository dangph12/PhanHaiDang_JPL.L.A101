package fa.training.utils;

public class Validator {
    public boolean isValidYear(int year) {
        if (year < 1900) {
            return false;
        }
        return true;
    }
