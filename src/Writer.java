import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Writer {

    private final String file;

    public Writer(String file) {
        this.file = file;
    }

    public void writeToFile(String s) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(file, true))) {
            pw.println(s);
            //pw.println(String.format("Namn: %s Personnummer: %s Datum för besök: %s", p.getName(), p.getSocialSecNumber(), getTodaysDateString()));
        } catch (IOException e) {
            System.err.println("Can't find file " + file);
        } catch (Exception e) {
            System.err.println("Unknown error occurred: " + e.getMessage());
        }
    }
}
