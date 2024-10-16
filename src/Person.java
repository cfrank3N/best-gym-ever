import java.time.LocalDate;

public class Person {
    //Skapa nya personer av värdena som läses in från filen
    //Spara dessa värden i en Lista av Personer som går att söka i
    private String socialSecNumber;
    private String name;
    private LocalDate dateOfPayment;

    public Person(String socialSecNumber, String name, LocalDate dateOfPayment) {
        this.socialSecNumber = socialSecNumber;
        this.name = name;
        this.dateOfPayment = dateOfPayment;
    }

    public Person() {

    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getSocialSecNumber() {
        return socialSecNumber;
    }

    public void setSocialSecNumber(String socialSecNumber) {
        this.socialSecNumber = socialSecNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "socialSecNumber='" + socialSecNumber + '\'' +
                ", name='" + name + '\'' +
                ", dateOfPayment=" + dateOfPayment +
                '}';
    }
}
