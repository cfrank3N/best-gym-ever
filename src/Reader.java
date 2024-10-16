import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

//Tänk bakvägen, vad behöver hända först?
public class Reader {

    public List <String> readFromFile(String fileName) {
        //String att returnera
        List<String> s = new LinkedList<>();
        //Try with resources
        try (Scanner scan = new Scanner(new File(fileName))) {
            while (scan.hasNextLine()) {
                s.add(scan.nextLine().trim());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file, supply a new filepath");
        } catch (Exception e) {
            System.out.println("Unexpected Error");
        }
        return s;
    }

    //Kastar vidare PatternSyntaxException om delimitern är felaktig
    public String[] splitString(String s, String delimiter) throws PatternSyntaxException {
        return s.split(delimiter);
    }
    /*
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
*/
    public LocalDate parseStringToDate(String date) throws DateTimeParseException {
        return LocalDate.parse(date);
    }
/*
    public List<Person> getPersons() {
        return persons;
    }

    public void addPersons(Person person) {
        this.persons.add(person);
    }
    */

}
