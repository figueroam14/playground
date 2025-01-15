
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("myFinance");
        frame.setSize(1400, 1000);
        frame.setVisible(true);

        JButton button = new JButton("Create User");
        button.setBounds(400, 200, 200, 200);
        frame.add(button);

        JLabel userLabel = new JLabel();
        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("password");

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(500, 300, 200, 200);
        JButton forgotPWButton = new JButton("Forgot Password");
        forgotPWButton.setBounds(600, 200, 200, 200);

        frame.add(userLabel);
        frame.add(passwordLabel);
        frame.add(loginButton);
        frame.add(forgotPWButton);

        Person Michael = new Person("Michael", "Money", "Figueroa", "6020 Altomonte ", "634634634634");
        int assests = 1000;
        int debts = 100;
        int netWorth = Michael.getNetWorth(assests, debts);

        String fullName = Michael.getFullName();
        System.out.println("Full Name: " + fullName);
        System.out.println("Net Worth: " + String.valueOf(netWorth));
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
    String getFullName() {
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
    public int getNetWorth(int assets, int debts) {
        int netWorth = assets - debts;
        return netWorth;
    }
}
