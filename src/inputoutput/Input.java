package inputoutput;

import exceptions.BestGymException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Input {

    public static String getUserInput(String message, Scanner scanner) throws BestGymException {
        while (true) {
            try {

                String toReturn;

                System.out.println(message);
                toReturn = scanner.nextLine().trim();
                if (toReturn.isEmpty()) {
                    System.err.println("Input can't be empty. Try again");
                } else {
                    return toReturn;
                }
            } catch (NoSuchElementException e) {
                System.err.println("Input can't be empty. Try again");

            } catch (Exception e) {
                throw new BestGymException("Unexpected error occurred", e);
            }
        }
    }
}
