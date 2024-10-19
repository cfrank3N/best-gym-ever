import exceptions.BestGymException;
import inputoutput.Input;

import java.util.Scanner;

import static inputoutput.Input.getUserInput;

public class BestGymEver {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean firstIteration = true;

        String messageFromFile = "Supply a filepath to gather customer data from:";
        String messageToFile = "Supply a filepath where visitors a logged an saved:";
        String messageSearchCustomer = "Write the name or social security number of the person to search for them in the database of customers:";

        String fileToReadFrom = "";
        String fileToWriteTo = "";

        while (true) {
            try {

                if (firstIteration) {
                    fileToReadFrom = Input.getUserInput(messageFromFile, scan);
                    fileToWriteTo = Input.getUserInput(messageToFile, scan);
                }

                SaveData saveData = new SaveData(fileToReadFrom, fileToWriteTo);

                saveData.initDatabase();

                String searchFor = getUserInput(messageSearchCustomer, scan);

                if (searchFor.equalsIgnoreCase("exit")) {
                    scan.close();
                    System.exit(0);
                }
                saveData.searchForMember(searchFor);
                firstIteration = false;
            } catch (BestGymException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
