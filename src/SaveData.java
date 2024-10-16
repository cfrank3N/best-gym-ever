import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

public class SaveData {

    private final String READ_FROM;
    private final String WRITE_TO;
    private List <Person> persons = new LinkedList<>();
    private List <String> fileData = new LinkedList<>();
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final Reader read = new Reader("./src/data.txt");
    private final Writer write = new Writer("./src/visitor-log.txt");

    public SaveData(String readFrom, String writeTo) {
        this.READ_FROM = readFrom;
        this.WRITE_TO = writeTo;
    }

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

    private static String getTodaysDateString() {
        return LocalDate.now().format(dtf);
    }

    //TODO: Skriv en metod som skriver en person till fil
    public void writePersonToFile(Person p) {
        String toWrite = String.format("Namn: %s Personnummer: %s Datum för besök: %s",
                p.getName(), p.getSocialSecNumber(), getTodaysDateString());

        write.writeToFile(toWrite);
    }
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
