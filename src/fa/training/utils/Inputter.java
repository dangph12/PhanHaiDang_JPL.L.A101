package fa.training.utils;

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

}
