package inputoutput;

import exceptions.BestGymException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    private final String file;

    public Reader(String file) {
        this.file = file;
    }

    public List<String> readFromFile() throws BestGymException {
        //String att returnera
        List<String> s = new LinkedList<>();
        //Try with resources
        try (Scanner scan = new Scanner(new File(file))) {
            while (scan.hasNextLine()) {
                s.add(scan.nextLine().trim());
            }
        } catch (FileNotFoundException e) {
            throw new BestGymException("Can't find " + file + ", supply a new filepath", e);
        } catch (Exception e) {
            throw new BestGymException("Unexpected Error", e);
        }
        return s;
    }
}
