import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

public class SaveData {

    private List <Person> persons = new LinkedList<>();
    private List <String> fileData = new LinkedList<>();
    private final Reader read = new Reader("./src/data.txt");

    public void saveDataFromFile() {
        setFileData(read.readFromFile());
    }

    public void savePersons() throws DateTimeParseException {
        for (int i = 0; i < fileData.size() - 1; i += 2) {
            Person p = new Person();

            String[] socialSecAndName = read.splitString(fileData.get(i), ", ");

            p.setDateOfPayment(read.parseStringToDate(fileData.get(i + 1)));

            p.setName(socialSecAndName[1]);

            p.setSocialSecNumber(socialSecAndName[0]);

            persons.add(p);
        }
    }

    //TODO: Skriv en metod som skriver en person till fil
    //pw.println(String.format("Namn: %s Personnummer: %s Datum för besök: %s", p.getName(), p.getSocialSecNumber(), getTodaysDateString()));

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<String> getFileData() {
        return fileData;
    }

    public void setFileData(List<String> fileData) {
        if (fileData.isEmpty()) {
            System.out.println("List is empty, check the file too see that it's not empty");
        } else {
            this.fileData = fileData;
        }
    }

    public Reader getRead() {
        return read;
    }
}
