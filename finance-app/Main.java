
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello-World");

        Person Michael = new Person("Michael", "Money", "Figueroa", "6020 Altomonte ", "634634634634");
        String fullName = Michael.getFullName();
        System.out.println("Full Name: " + fullName);
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

    // Public Setters
    public void setFname(String fname) {
        this.fName = fname;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public void setAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setSSN(String ssn) {
        this.SSN = ssn;
    }

    // Public Getters
    String getFullName () {
        String fullName = fName + " " + mName + " " + lName;
        return fullName;
    }

    String getFullAddress() {
        return homeAddress;
    }

    String getSSN() {
        return SSN;

    }

    // method to calculate net worth
    public int calculateNetWorth() {
        int netWorth = assetsTotal - debtsTotal;
        return netWorth;
    }
}
