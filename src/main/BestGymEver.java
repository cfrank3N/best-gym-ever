package main;

import database.SaveData;
import exceptions.BestGymException;
import inputoutput.Input;

import static inputoutput.Input.getUserInput;
import static utilities.Messages.*;

public class BestGymEver {

    private boolean firstIteration = true;
    private String fileToReadFrom;
    private String fileToWriteTo;

    public BestGymEver() {

        System.out.println(getWelcomeMessage());
        System.out.println(getShrek());

        while (true) {
            try {

                if (firstIteration) {
                    fileToReadFrom = Input.getUserInput(getMessageFromFile());
                    fileToWriteTo = Input.getUserInput(getMessageToFile());
                }

                SaveData saveData = new SaveData(fileToReadFrom, fileToWriteTo); //Create database
                saveData.initDatabase(); //Initialize Database containing info from the file it's reading from
                String searchFor = getUserInput(getMessageSearchCustomer());

                if (searchFor.equalsIgnoreCase("exit")) {
                    break;
                }
                firstIteration = false;

                saveData.searchForMember(searchFor); //Search for customer, print out message(current, former, not found)

            } catch (BestGymException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        BestGymEver bge = new BestGymEver();

    }
}
