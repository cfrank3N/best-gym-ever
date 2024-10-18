import java.util.Scanner;

public class Input {
    //TODO: Skriv om denna kanske?
    public String getUserInput(String message) {
        String toReturn;
        while (true) {
            try (Scanner userInput = new Scanner(System.in)) {
                System.out.println(message);
                toReturn = userInput.nextLine();
                if (toReturn.equalsIgnoreCase("exit") || toReturn.equalsIgnoreCase("^D")) {
                    System.exit(0);
                }
                return toReturn.trim();
            } catch (Exception e) {
                System.err.println("Faulty input");
                e.printStackTrace();
            }
        }
    }

}
