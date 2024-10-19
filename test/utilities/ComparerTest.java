package utilities;

import exceptions.BestGymException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class ComparerTest {

    @Test
    public void testCompareDates() throws BestGymException {

        //Skapa upp ett objekt som formaterar om ett datum till yyyy-MM-dd
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //Skapa upp datum att testa med
        LocalDate ld1 =
                LocalDate.parse(LocalDate.now().minusMonths(2).minusDays(45).format(dtf));

        LocalDate ld2 =
                LocalDate.parse(LocalDate.now().minusYears(1).minusMonths(2).format(dtf));

        LocalDate ld3 =
                LocalDate.parse(LocalDate.now().minusYears(1).format(dtf));

        assertTrue(Comparer.dateIsLessThanAYearAgo(ld1));
        assertFalse(Comparer.dateIsLessThanAYearAgo(ld2));
        assertFalse(Comparer.dateIsLessThanAYearAgo(ld3));

    }
}
