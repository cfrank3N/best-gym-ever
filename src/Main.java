
public class Main {
    public static void main(String[] args) {
        SaveData saveData = new SaveData("./src/data.txt", "visit_log.txt");

        Input input = new Input();

        String s = input.getUserInput("Skriv in Personnummer eller Namn på personen du söker:");

        System.out.println(s);

        for (Person p : saveData.getPersons()) {
            saveData.writePersonToFile(p);
        }
    }
}
