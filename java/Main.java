
public class Main {

    public class Vehicle {

        String vehicleName;
        String vehicleModel;
        String callsign;
        int fuelTotalCapacity = 100;
        int fuelCurrentCapacity = 10;
    }

    static int getFuelPercentage(int currentFuel, int totalFuel) {

        int fuelPercent = 0;

        fuelPercent = currentFuel / totalFuel;
        return fuelPercent;

    }

    public static void main(String args[]) {
        int percent = getFuelPercentage(10, 100);
        String stringPercent;
        stringPercent = String.valueOf(percent);
        System.out.println("Percent" + percent;
        System.out.println("BOT");
    }
}
