import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        SaveData saveData = new SaveData("./src/data.txt", "visit_log.txt");

        for (Person p : saveData.getPersons()) {
            saveData.writePersonToFile(p);
        }
        /*
        Comparer c = new Comparer();
        SaveData s = new SaveData();

        try {
            s.saveDataFromFile();
            s.savePersons();
        } catch (DateTimeParseException e) {
            System.out.println("Not a valid date");
            e.printStackTrace();
        }

        for (Person p : s.getPersons()) {
            System.out.println(p);
            System.out.println(c.dateIsLessThanAYearAgo(p.getDateOfPayment()));
        }
        */
    }
}
