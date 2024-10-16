import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ComparerTest {

    Comparer c = new Comparer();

    @Test
    public void testCompareDates() {

        LocalDate ld1 = LocalDate.of(2024, 2, 22);
        LocalDate ld2 = LocalDate.of(2023, 1, 22);
        LocalDate ld3 = LocalDate.of(2023, 10, 16);

        assertFalse(c.dateIsLessThanAYearAgo(ld2));
        assertTrue(c.dateIsLessThanAYearAgo(ld1));
        assertFalse(c.dateIsLessThanAYearAgo(ld3));


    }

}
