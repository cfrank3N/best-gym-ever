import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Tänk bakvägen, vad behöver hända först?
public class Reader {


    public List <String> readFromFile(String fileName) {
        //String att returnera
        List<String> s = new LinkedList<>();
        //Try with resources
        try (Scanner scan = new Scanner(new File(fileName))) {
            while (scan.hasNextLine()) {
                s.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        } catch (Exception e) {
            System.out.println("Unexpected Error");
        }
        return s;
    }
}
