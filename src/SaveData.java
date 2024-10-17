import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class SaveData {

    private List <Person> persons = new LinkedList<>();
    private List <String> fileData = new LinkedList<>();
    private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final Reader read;
    private final Writer write;

    public SaveData(String readFrom, String writeTo) {
        this.read = new Reader(readFrom);
        this.write = new Writer(writeTo);

        saveDataFromFile();
        savePersons();
    }

    //Used for tests
    public SaveData(String readFrom, String writeTo, boolean test) {
        this.read = new Reader(readFrom);
        this.write = new Writer(writeTo);
    }

    public void saveDataFromFile() {
        setFileData(read.readFromFile());
    }

    public void savePersons() throws DateTimeParseException {
        for (int i = 0; i < fileData.size() - 1; i += 2) {
            Person p = new Person();

            String[] socialSecAndName = splitString(fileData.get(i), ", ");

            p.setDateOfPayment(parseStringToDate(fileData.get(i + 1)));

            p.setName(socialSecAndName[1]);

            p.setSocialSecNumber(socialSecAndName[0]);

            persons.add(p);
        }
    }

    private String getTodaysDateString() {
        return LocalDate.now().format(DTF);
    }

    public void writePersonToFile(Person p) {
        String toWrite = String.format("%-7s %-18s %-15s %-13s %-18s %-15s", "Namn:",
                p.getName(), "Personnummer:", p.getSocialSecNumber(), "Datum för besök:", getTodaysDateString());

        write.writeToFile(toWrite);
    }

    //TODO: Kanske ändra detta?
    //Kastar vidare PatternSyntaxException om delimitern är felaktig
    public String[] splitString(String s, String delimiter) throws PatternSyntaxException {
        return s.split(delimiter);
    }

    public LocalDate parseStringToDate(String date) throws DateTimeParseException {
        return LocalDate.parse(date);
    }

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
