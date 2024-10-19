import exceptions.BestGymException;
import inputoutput.Input;

import java.io.IOException;

import static inputoutput.Input.getUserInput;

public class BestGymEver {
    public static void main(String[] args) {

        while (true) {
            try {
                String message = "Write the name or social security number of the person to search for them in the database of customers:";
                String fileToReadFrom = Input.getUserInput("Supply a filepath to gather customer data from:");
                String fileToWriteTo = Input.getUserInput("Supply a filepath where visitors a logged an saved:");
                String searchFor = getUserInput(message);

                if (searchFor.equalsIgnoreCase("exit")
                        || fileToReadFrom.equalsIgnoreCase("exit")
                        || fileToWriteTo.equalsIgnoreCase("exit")) {
                    System.exit(0);
                }
                SaveData saveData = new SaveData(fileToReadFrom, fileToWriteTo);

                saveData.initDatabase();

                saveData.searchForMember(searchFor);

            } catch (BestGymException e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
