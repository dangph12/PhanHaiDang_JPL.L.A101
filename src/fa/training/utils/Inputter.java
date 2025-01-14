package fa.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Inputter {
    private final static Scanner scanner = new Scanner(System.in);

    /**
     * Input an integer value from terminal
     * @param message Instruction to input
     * @return An valid integer value
     */
    public int inputInteger(String message) {
        boolean isContinue = true;
        int result = 0;
        while (isContinue) {
            try {
                System.out.print(message);
                result = Integer.parseInt(scanner.nextLine());
                isContinue = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return result;
    }

    /**
     * Input a string from terminal
     * @param message Instruction to input
     * @return A non-empty string
     */
    public String inputString(String message) {
        boolean isContinue = true;
        String result = "";
        while (isContinue) {
            try {
                System.out.print(message);
                result = scanner.nextLine();
                if (result.equalsIgnoreCase("")) {
                    throw new Exception();
                }
                isContinue = false;
            } catch (Exception e) {
                System.out.println("Please enter a non-empty string.");
            }
        }
        return result;
    }

    /**
     * Input a date from terminal
     * @param message Instruction to input
     * @param pattern Pattern for date format
     * @return A date in pattern format
     */
    public Date inputDate(String message, String pattern) {
        boolean isContinue = true;
        Date result = new Date();

        while (isContinue) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            // set lenient to false to apply strict date parsing
            dateFormat.setLenient(false);
            try {
                result = dateFormat.parse(this.inputString(message));
                isContinue = false;
            }
            catch (ParseException e) {
                System.out.println("Invalid date format " + pattern);
            }
        }
        return result;
    }
}
