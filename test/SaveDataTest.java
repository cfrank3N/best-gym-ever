import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class SaveDataTest {

    SaveData save = new SaveData("test.txt", "test.txt", true);

    @Test
    public void testSplitString() {
        String[] expectedContent = {"7703021234", "Alhambra Aromes"};
        String[] s = save.splitString("7703021234, Alhambra Aromes", ", ");

        assertArrayEquals(s, expectedContent);
    }

    @Test
    public void testParseStringToDate() {

        LocalDate ld = LocalDate.of(2024, 8, 4);
        LocalDate ld2 = LocalDate.of(2025, 8, 4);

        String date = "2024-08-04";
        LocalDate localDate = save.parseStringToDate(date);

        assertEquals(ld, localDate);
        assertThrows(DateTimeParseException.class, () -> LocalDate.parse("abc"));
        assertNotEquals(ld2, localDate);
    }
}