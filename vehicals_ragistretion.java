import java.util.*;
class VehicleType {
    String type;

    void setType(String a) {
        if (a.equalsIgnoreCase("BIKE") || a.equalsIgnoreCase("CAR") || a.equalsIgnoreCase("TRUCK")) {

            type = a.toUpperCase();
        }
        else {
            type = "INVALID";
        }
    }
    String getType() {
        return type;
    }
}
class FuelType {
    String fuel;

    void setFuel(String a) {
        if (a.equalsIgnoreCase("PETROL") || a.equalsIgnoreCase("DIESEL") || a.equalsIgnoreCase("CNG")|| a.equalsIgnoreCase("ELECTRIC") || a.equalsIgnoreCase("HYBRID")) {

            fuel = a.toUpperCase();
        }
        else {
            fuel = "INVALID";
        }
    }
    String getFuel() {
        return fuel;
    }
}
class Vehicle {
    String vehicleNumber;
    VehicleType vehicleType;
    String modelName;
    String engineNumber;
    String chassisNumber;
    FuelType fuelType;

    void display() {
        System.out.println("\n--- Vehicle Details ---");
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Vehicle Type   : " + vehicleType.getType());
        System.out.println("Model Name     : " + modelName);
        System.out.println("Engine Number  : " + engineNumber);
        System.out.println("Chassis Number : " + chassisNumber);
        System.out.println("Fuel Type      : " + fuelType.getFuel());
    }
}
 class VehicleInput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Vehicle v = new Vehicle();

        v.vehicleType = new VehicleType();
        v.fuelType = new FuelType();

        System.out.print("Enter Vehicle Number: ");
        v.vehicleNumber = sc.nextLine();

        System.out.print("Enter Vehicle Type (BIKE/CAR/TRUCK): ");
        v.vehicleType.setType(sc.nextLine());

        System.out.print("Enter Model Name: ");
        v.modelName = sc.nextLine();

        System.out.print("Enter Engine Number: ");
        v.engineNumber = sc.nextLine();

        System.out.print("Enter Chassis Number: ");
        v.chassisNumber = sc.nextLine();

        System.out.print("Enter Fuel Type (PETROL/DIESEL/CNG/ELECTRIC/HYBRID): ");
        v.fuelType.setFuel(sc.nextLine());

    }
}
