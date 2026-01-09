import java.util.Scanner;

class Vehicleonline {
    String vehicleNumber;
    String ownerName;
    String email;
    String phone;

    Vehicleonline(String vehicleNumber, String ownerName, String email, String phone) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.email = email;
        this.phone = phone;
    }
}

class VehicleSystem {
    Vehicleonline[] vehicles = new Vehicleonline[10]; // array for storing vehicles
    int count = 0;
    Scanner sc = new Scanner(System.in);


    boolean payOnline(String vehicleNumber) {
        System.out.println("Processing online payment for " + vehicleNumber + "...");
        System.out.println("Payment Successful!");
        return true;
    }


   void generateQRCode(String vehicleNumber) {
        System.out.println("Generating QR code for vehicle: " + vehicleNumber);
        System.out.println("[QR_CODE: " + vehicleNumber + "_QR]");
    }


    void sendNotification(Vehicleonline v) {
        System.out.println("Sending SMS to " + v.phone + ": Vehicle " + v.vehicleNumber + " registered successfully.");
        System.out.println("Sending Email to " + v.email + ": Vehicle " + v.vehicleNumber + " registered successfully.");
    }


    void addVehicle() {
        if (count >= vehicles.length) {
            System.out.println("Vehicle storage full!");
            return;
        }

        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        System.out.print("Enter Owner Name: ");
        String owner = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();


        if (payOnline(number)) {
            Vehicleonline vehicle = new Vehicleonline(number, owner, email, phone);
            vehicles[count++] = vehicle; // store in array


            generateQRCode(number);


            sendNotification(vehicle);

            System.out.println("Vehicle registration completed successfully!");
        }
    }
    
   void displayVehicles() {
        if (count == 0) {
            System.out.println("No vehicles registered.");
            return;
        }
        System.out.println("Registered Vehicles:");
        for (int i = 0; i < count; i++) {
            Vehicleonline v = vehicles[i];
            System.out.println("Vehicle: " + v.vehicleNumber + ", Owner: " + v.ownerName);
        }
    }
}

class Main {
    public static void main(String[] args) {
        VehicleSystem vs = new VehicleSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register Vehicle");
            System.out.println("2. Display Vehicles");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> vs.addVehicle();
                case 2 -> vs.displayVehicles();
                case 3 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
