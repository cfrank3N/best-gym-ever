import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Writer {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void writeToFile(String file, String s1) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(file, true))) {
            pw.println(s1);
            //pw.println(String.format("Namn: %s Personnummer: %s Datum för besök: %s", p.getName(), p.getSocialSecNumber(), getTodaysDateString()));
        } catch (IOException e) {
            System.err.println("Can't find file " + file);
        } catch (Exception e) {
            System.err.println("Unknown error occurred: " + e.getMessage());
        }
    }

    private static String getTodaysDateString() {
        return LocalDate.now().format(dtf);
    }
}
