import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Tänk bakvägen, vad behöver hända först?
public class Reader {

    private List <Person> persons = new LinkedList<>();
    private List <String> fileData = new LinkedList<>();

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

    public String[] splitString(String s, String delimiter) {
        return s.split(delimiter);
    }

    public List<String> getFileData() {
        return fileData;
    }

    public void setFileData(List<String> fileData) {
        if (!this.fileData.isEmpty()) {
            this.fileData = fileData;
        } else {
            System.out.println("List is empty, check the file too see that it's not empty");
        }
    }

    public LocalDate parseStringToDate(String date) throws DateTimeParseException {
        return LocalDate.parse(date);
    }
}
