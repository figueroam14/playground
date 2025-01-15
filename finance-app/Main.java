
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello-World");

        Person Michael = new Person("Michael", "Money", "Figueroa", "6020 Altomonte ", "634634634634");
        Michael.printFullname();
    }
}

class Person {

    String fName;
    String mName;
    String lName;
    String homeAddress;
    String SSN;

    int assetsTotal;
    int debtsTotal;
    int netWorthTotal;

    public Person(String fName, String mName, String lName, String homeAddress, String SSN) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.homeAddress = homeAddress;
        this.SSN = SSN;
    }

    // method to get the full name
    void printFullname() {
        String fullName = fName + " " + mName + " " + lName;
        System.out.println(fullName);
    }

    // method to calculate net worth
    public int calculateNetWorth() {
        int netWorth = assetsTotal - debtsTotal;
        return netWorth;
    }
}
