import java.util.Scanner;
import java.util.Date;

class Vehicles{
    static int idCounter = 1000;
    int registrationId;
    String vehicleNumber;
    String ownerName;
    Date registrationDate;
    String status;

    Vehicles(String vehicleNumber, String ownerName) {
        this.registrationId = ++idCounter;
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.registrationDate = new Date();
        this.status = "Active";
    }

    int getRegistrationId() {
        return registrationId;
    }

    void setStatus(String status) {
        this.status = status;
    }

    void display() {
        System.out.println("Registration ID : " + registrationId);
        System.out.println("Vehicle Number  : " + vehicleNumber);
        System.out.println("Owner Name      : " + ownerName);
        System.out.println("Reg Date        : " + registrationDate);
        System.out.println("Status          : " + status);
        System.out.println("---------------------------");
    }
}

class RegistrationService {
    Vehicles[] vehicles = new Vehicles[50]; // max 50 vehicles
    int count = 0;

    void registerVehicle(String vNumber, String owner) {
        if (count >= vehicles.length) {
            System.out.println("Vehicle limit reached!");
            return;
        }
        vehicles[count] = new Vehicles(vNumber, owner);
        System.out.println("Vehicle Registered Successfully!");
        System.out.println("Registration ID: " + vehicles[count].getRegistrationId());
        count++;
    }

    void displayAllVehicles() {
        if (count == 0) {
            System.out.println("No vehicles found!");
            return;
        }
        for (int i = 0; i < count; i++) {
            vehicles[i].display();
        }
    }

    void changeStatus(int regId, String status) {
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getRegistrationId() == regId) {
                vehicles[i].setStatus(status);
                System.out.println("Status Updated Successfully!");
                return;
            }
        }
        System.out.println("Vehicle not found!");
    }
}

class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegistrationService sv= new RegistrationService();
        int choice;
        boolean x=true;

        do {
            System.out.println("\n-----------Vehicle Registration Menu----------");
            System.out.println("1. New Vehicle Registration");
            System.out.println("2. Display All Vehicles");
            System.out.println("3. Change Vehicle Status");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Vehicle Number: ");
                    String vNum = sc.nextLine();
                    System.out.print("Enter Owner Name: ");
                    String owner = sc.nextLine();
                    sv.registerVehicle(vNum, owner);
                    break;

                case 2:
                    sv.displayAllVehicles();
                    break;

                case 3:
                    System.out.print("Enter Registration ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Status (Active/Inactive): ");
                    String status = sc.nextLine();
                    sv.changeStatus(id, status);
                    break;

                case 4:
                    System.out.println("Thank You!");
                    x=false;
                    break;

                default:
                    System.out.println("Invalid Choice!");
                    x=false;
                    break;
            }
        } while (x);
    }
}
