import java.util.NoSuchElementException;
import java.util.Scanner;

public class Input {
    //TODO: Skriv om denna kanske?
    public String getUserInput(String message) {

        Scanner userInput = new Scanner(System.in);
        String toReturn;

        System.out.println(message);
        while (true) {
            try {
                toReturn = userInput.nextLine();
                if (toReturn.equalsIgnoreCase("exit")) {
                    userInput.close();
                    System.exit(0);
                }
                return toReturn.trim();
            } catch (NoSuchElementException e) {
                System.err.println("Input cannot be empty/null.");
            } catch (Exception e) {
                System.err.println("Unidentified error occurred");
            }
        }
    }
}
