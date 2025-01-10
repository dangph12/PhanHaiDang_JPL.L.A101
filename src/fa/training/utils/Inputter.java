package fa.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Inputter {
    private final static Scanner scanner = new Scanner(System.in);

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

    public Date inputDate(String message) {
        boolean isContinue = true;
        Date result = new Date();

        while (isContinue) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            // set lenient to false to apply strict date parsing
            dateFormat.setLenient(false);
            try {
                result = dateFormat.parse(this.inputString(message));
                isContinue = false;
            }
            catch (ParseException e) {
                System.out.println("Invalid date format dd-MM-yyyy.");
            }
        }
        return result;
    }
}
