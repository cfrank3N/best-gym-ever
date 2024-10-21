package database;

import exceptions.BestGymException;
import inputoutput.Reader;
import inputoutput.Writer;
import persons.Person;
import utilities.Comparer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class SaveData {

    private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final Reader read;
    private final Writer write;
    private List<Person> persons = new LinkedList<>();
    private List<String> fileData = new LinkedList<>();

    public SaveData(String readFrom, String writeTo) {
        this.read = new Reader(readFrom);
        this.write = new Writer(writeTo);
    }

    public void initDatabase() throws BestGymException {
        saveDataFromFile();
        savePersons();
    }

    public void searchForMember(String personInfo) throws BestGymException {
        boolean foundPerson = false;
        for (Person p : getPersons()) {
            if (p.getName().equalsIgnoreCase(personInfo) || p.getSocialSecNumber().equalsIgnoreCase(personInfo)) {
                foundPerson = true;
                if (Comparer.dateIsLessThanAYearAgo(p.getDateOfPayment())) {
                    System.out.println(p.getName() + " is a current member. They purchased their membership: " + p.getDateOfPayment());
                    writePersonToFile(p);
                    System.out.println("Saved person info in Private trainers file: " + write.getFile());

                } else {
                    System.out.println(p.getName() + " is a former member. They purchased their membership: " + p.getDateOfPayment());
                }
                break;
            }
        }
        if (!foundPerson) {
            System.out.println("This person is not a customer");
        }
    }

    public void saveDataFromFile() throws BestGymException {
        setFileData(read.readFromFile());
    }

    public void savePersons() throws BestGymException {
        try {
            for (int i = 0; i < fileData.size() - 1; i += 2) {
                Person p = new Person();
                String[] socialSecAndName = fileData.get(i).split(", ");
                p.setDateOfPayment(parseStringToDate(fileData.get(i + 1)));
                p.setName(socialSecAndName[1]);
                p.setSocialSecNumber(socialSecAndName[0]);
                persons.add(p);
            }
        } catch (DateTimeParseException e) {
            throw new BestGymException("Illegal format for a date! Check that the file you read from has correct formatting", e);
        } catch (PatternSyntaxException e) {
            throw new BestGymException("Illegal delimiter", e);
        } catch (Exception e) {
            throw new BestGymException("Unexpected Error! Check that the file you read from has correct formatting", e);
        }
    }

    private String getTodaysDateString() {
        return LocalDateTime.now().format(DTF);
    }

    public void writePersonToFile(Person p) throws BestGymException {
        String toWrite = String.format("%-7s %-18s %-16s %-13s %-27s %s", "Namn:",
                p.getName(), "Personnummer:", p.getSocialSecNumber(), "Datum och tid för besök:", getTodaysDateString());

        write.writeToFile(toWrite);
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

    public void setFileData(List<String> fileData) {
        if (fileData.isEmpty()) {
            System.out.println("List is empty, check the file too see that it's not empty");
        } else {
            this.fileData = fileData;
        }
    }
}
