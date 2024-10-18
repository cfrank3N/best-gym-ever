
public class Main {
    public static void main(String[] args) {
        SaveData saveData = new SaveData("./src/data.txt", "visit_log.txt");
        Comparer c = new Comparer();

        for (Person p : saveData.getPersons()) {
            saveData.writePersonToFile(p);
        }

        Input input = new Input();

        String s = input.getUserInput("Skriv in Personnummer eller Namn på personen du söker:");

        //TODO: skriv om detta till metoder. Vart de ska läggas vettetusan
        //public String/void isMember(String personInfo)
        boolean foundPerson = false;
        for (Person p : saveData.getPersons()) {
            if (p.getName().equalsIgnoreCase(s) || p.getSocialSecNumber().equalsIgnoreCase(s)) {
                foundPerson = true;
                if (c.dateIsLessThanAYearAgo(p.getDateOfPayment())) {
                    System.out.println(p.getName() + " is a current member. They purchased their membership: " + p.getDateOfPayment());
                    saveData.writePersonToFile(p);
                    System.out.println("Saved person info in Private trainers file");

                } else {
                    System.out.println(p.getName() + " is a former member. They purchased their membership: " + p.getDateOfPayment());
                }
                break;
            }
        }
        if(!foundPerson) {
            System.out.println("This person is not a customer");
        }

    }
}
