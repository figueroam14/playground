
class Platform {

    // platform data
    private String callsign;
    private String platformModel;
    private double fuelPercentage = 50.0; // out of 100

    // positional data
    private double latitude;
    private double longitude;
    private int altitude;

    // orientation data
    private double yaw;
    private double pitch;
    private double roll;

    boolean isFriendly = false;

    public Platform(String callsign, String platformModel) {
        this.callsign = callsign;
        this.platformModel = platformModel;

    }

    // getter methods
    public String getCallsign() {
        return callsign;
    }

    public String getPlatformModel() {
        return platformModel;
    }

    public double getYaw() {
        return yaw;
    }

    public double getPitch() {
        return pitch;

    }

    public double getRoll() {
        return roll;

    }

    // display platform info
    public  void displayInfo()
    {
        System.out.println("CALLSIGN: " + callsign);
        System.out.println("Platform Model: " + platformModel);
    }

};

public class Main {

    public static void main(String[] args) {
        {


            Platform ac130 = new Platform("ABF01", "F22");
            ac130.displayInfo();
            System.out.println("Hello World");
        }
    }
}
