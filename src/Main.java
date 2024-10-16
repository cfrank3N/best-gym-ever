
public class Main {
    public static void main(String[] args) {
        SaveData saveData = new SaveData("./src/data.txt", "visit_log.txt");

        for (Person p : saveData.getPersons()) {
            saveData.writePersonToFile(p);
        }

    }
}
