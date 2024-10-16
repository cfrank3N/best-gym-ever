import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Comparer {

    public boolean dateIsLessThanAYearAgo(LocalDate dateToCheck) throws DateTimeParseException {

        //Skapa en formaterare som formaterar dagens datum så att det blir 20XX-XX-XX
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //Skapa upp dagens datum
        LocalDate aYearAgo = LocalDate.parse(LocalDate.now().minusYears(1).format(dtf));

        //returnera sant om dateToCheck är efter dagens datum minus ett år.
        return aYearAgo.isBefore(dateToCheck);
    }

}
