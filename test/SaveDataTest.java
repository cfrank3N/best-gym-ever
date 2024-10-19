import exceptions.BestGymException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaveDataTest {

    LocalDate ld1 = LocalDate.of(2024, 7, 1);
    LocalDate ld2 = LocalDate.of(2019, 12, 2);
    LocalDate ld3 = LocalDate.of(2018, 3, 12);
    Person p1 = new Person("7703021234", "Alhambra Aromes", ld1);
    Person p2 = new Person("8204021234", "Bear Belle", ld2);
    Person p3 = new Person("8512021234", "Chamade Coriola", ld3);
    List<Person> expectedContent = Arrays.asList(p1, p2, p3);
    final String TEST_FILE_NAME_READ = "./test/data.txt";
    final String TEST_FILE_NAME_WRITE = "test.txt";
    SaveData save = new SaveData(TEST_FILE_NAME_READ, TEST_FILE_NAME_WRITE);

    @AfterEach
    public void cleanUp() {
        try {
            Path path = Paths.get(TEST_FILE_NAME_WRITE);
            Files.deleteIfExists(path);
        } catch (IOException e) {
            System.err.println("Couldn't delete file");
        }
    }

    @Test
    public void testSavePersons() throws BestGymException {

        save.saveDataFromFile();
        save.savePersons();

        int count = 0;
        for (Person p : save.getPersons()) {
            assertEquals(p.getName(), expectedContent.get(count).getName());
            assertEquals(p.getSocialSecNumber(), expectedContent.get(count).getSocialSecNumber());
            assertEquals(p.getDateOfPayment(), expectedContent.get(count).getDateOfPayment());
            System.out.println(p);
            System.out.println(expectedContent.get(count));
            count++;
        }
        assertEquals(3, save.getPersons().size());
        assertNotEquals(2, save.getPersons().size());
    }

    @Test
    public void testSavePersonsThrowsException() throws BestGymException {
        SaveData save = new SaveData("./test/faultydata.txt", TEST_FILE_NAME_WRITE);

        save.saveDataFromFile();
        BestGymException e = assertThrows(BestGymException.class, save::savePersons);
        System.err.println(e.getMessage());
    }

    @Test
    public void testParseStringToDate() {

        LocalDate ld = LocalDate.of(2024, 8, 4);
        LocalDate ld2 = LocalDate.of(2025, 8, 4);

        String date = "2024-08-04";
        LocalDate localDate = save.parseStringToDate(date);

        assertEquals(ld, localDate);
        assertThrows(DateTimeParseException.class, () -> save.parseStringToDate("ghjki"));
        assertNotEquals(ld2, localDate);
    }
}