import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person {
    //Skapa nya personer av värdena som läses in från filen
    //Spara dessa värden i en Lista av Personer som går att söka i
    private int socialSecNumber;
    private String name;
    private LocalDate dateOfPayment;

    public Person(int socialSecNumber, String name, LocalDate dateOfPayment) {
        this.socialSecNumber = socialSecNumber;
        this.name = name;
        this.dateOfPayment = dateOfPayment;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public int getSocialSecNumber() {
        return socialSecNumber;
    }

    public void setSocialSecNumber(int socialSecNumber) {
        this.socialSecNumber = socialSecNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
