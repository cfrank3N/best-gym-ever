import java.util.Scanner;

public class Input {
    //TODO: Skriv om denna kanske?
    public String getUserInput(String message) {
        String toReturn = "";
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println(message);
            if (userInput.hasNextLine()) {
                toReturn = userInput.nextLine();
                if (toReturn.equalsIgnoreCase("exit")) {
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            System.err.println("Faulty input");
            e.printStackTrace();
        }
        return toReturn.trim();
    }

}
