package inputoutput;

import exceptions.BestGymException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer {

    private final String file;

    public Writer(String file) {
        this.file = file;
    }

    public void writeToFile(String textToWrite) throws BestGymException {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(file, true))) {
            pw.println(textToWrite);
        } catch (IOException e) {
            throw new BestGymException("Can't find " + file + ", supply a new filepath", e);
        } catch (Exception e) {
            throw new BestGymException("Unknown error occurred", e);
        }
    }

    public String getFile() {
        return file;
    }
}
