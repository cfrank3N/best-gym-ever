import exceptions.BestGymException;
import inputoutput.Input;

import static inputoutput.Input.getUserInput;

public class BestGymEver {

    public BestGymEver() {

        SaveData saveData = new SaveData("./src/data.txt", "visit_log.txt");
        String message = "Write the name or social security number of the person to search for them in the database of customers:";

        while (true) {
            try {
                saveData.saveDataFromFile();
                saveData.savePersons();
                String searchFor = getUserInput(message);
                saveData.searchForMember(searchFor);
            } catch (BestGymException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        BestGymEver bge = new BestGymEver();
    }

}
