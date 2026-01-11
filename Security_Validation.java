import java.util.Scanner;

// Vehicle class
class VehicleSecurity {
    String vehicleNumber;
    String ownerName;

    VehicleSecurity(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }
}

// System class
class VehicleSystem1 {

    VehicleSecurity[] vehicles = new VehicleSecurity[10];
    int count = 0;
    final String ADMIN_PASSWORD = "admin123";
    Scanner sc = new Scanner(System.in);

    // Validate vehicle number
    boolean isValidVehicleNumber(String number) {
        if (number == null) return false;
        if (number.length() < 6 || number.length() > 10) return false;

        for (int i = 0; i < number.length(); i++) {
            if (!Character.isLetterOrDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Duplicate check
    boolean isDuplicate(String number) {
        for (int i = 0; i < count; i++) {
            if (vehicles[i].vehicleNumber.equalsIgnoreCase(number)) {
                return true;
            }
        }
        return false;
    }

    // Add vehicle
    void addVehicle() {
        if (count == vehicles.length) {
            System.out.println("Vehicle storage full!");
            return;
        }

        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        if (!isValidVehicleNumber(number)) {
            System.out.println("Invalid vehicle number!");
            return;
        }

        if (isDuplicate(number)) {
            System.out.println("Vehicle already exists!");
            return;
        }

        System.out.print("Enter Owner Name: ");
        String owner = sc.nextLine();

        vehicles[count++] = new VehicleSecurity(number, owner);
        System.out.println("Vehicle added successfully!");
    }

    void deleteVehicle() {
        System.out.print("Enter Admin Password: ");
        String pass = sc.nextLine();

        if (!pass.equals(ADMIN_PASSWORD)) {
            System.out.println("Access Denied!");
            return;
        }

        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (vehicles[i].vehicleNumber.equalsIgnoreCase(number)) {

                for (int j = i; j < count - 1; j++) {
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles[count - 1] = null;
                count--;

                System.out.println("Vehicle deleted successfully!");
                return;
            }
        }
        System.out.println("Vehicle not found!");
    }

    // Display vehicles
    void displayVehicles() {
        if (count == 0) {
            System.out.println("No vehicles registered.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(
                    "Vehicle Number: " + vehicles[i].vehicleNumber +
                            ", Owner: " + vehicles[i].ownerName
            );
        }
    }
}

class Main3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VehicleSystem1 vs = new VehicleSystem1();

        while (true) {
            System.out.println("\n1. Add Vehicle");
            System.out.println("2. Delete Vehicle (Admin only)");
            System.out.println("3. Display Vehicles");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> vs.addVehicle();
                case 2 -> vs.deleteVehicle();
                case 3 -> vs.displayVehicles();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
