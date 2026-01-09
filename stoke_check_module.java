import java.util.Scanner;

class Vehiclestockcheck{
    int regId;
    String vehicleNumber;
    String ownerName;
    String status;

    Vehiclestockcheck(int id, String vNo, String owner) {
        regId = id;
        vehicleNumber = vNo;
        ownerName = owner;
        status = "ACTIVE";
    }

    void display() {
        System.out.println("Reg ID: " + regId + " | Vehicle No: " + vehicleNumber +
                " | Owner: " + ownerName + " | Status: " + status);
    }
}

class VehicleManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Vehiclestockcheck[] vehicles = new Vehiclestockcheck[5];
        int count = 0;  // Number of vehicles added

        int choice;

        do {
            System.out.println("\n--- Vehicle Registration Menu ---");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Delete Vehicle");
            System.out.println("3. Mark Vehicle as Stolen");
            System.out.println("4. Mark Vehicle as Scrapped");
            System.out.println("5. Display All Vehicles");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    if (count < vehicles.length) {
                        System.out.print("Enter Vehicle Number: ");
                        String vNo = sc.nextLine();

                        System.out.print("Enter Owner Name: ");
                        String owner = sc.nextLine();

                        vehicles[count] = new Vehiclestockcheck(1000 + count + 1, vNo, owner);
                        System.out.println("Vehicle added with Reg ID: " + vehicles[count].regId);
                        count++;
                    }

                    else {
                        System.out.println("Vehicle limit reached!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Reg ID to delete: ");
                    int delId = sc.nextInt();
                    boolean deleted = false;
                    for (int i = 0; i < count; i++) {
                        if (vehicles[i] != null && vehicles[i].regId == delId) {
                            vehicles[i] = null;
                            System.out.println("Vehicle deleted successfully!");
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted) System.out.println("Vehicle not found!");
                    break;

                case 3:
                    System.out.print("Enter Reg ID to mark as STOLEN: ");
                    int stolenId = sc.nextInt();
                    boolean foundStolen = false;
                    for (int i = 0; i < count; i++) {
                        if (vehicles[i] != null && vehicles[i].regId == stolenId) {
                            vehicles[i].status = "STOLEN";
                            System.out.println("Vehicle marked as STOLEN.");
                            foundStolen = true;
                            break;
                        }
                    }
                    if (!foundStolen) System.out.println("Vehicle not found!");
                    break;

                case 4:
                    System.out.print("Enter Reg ID to mark as SCRAPPED: ");
                    int scrapId = sc.nextInt();
                    boolean foundScrap = false;
                    for (int i = 0; i < count; i++) {
                        if (vehicles[i] != null && vehicles[i].regId == scrapId) {
                            vehicles[i].status = "SCRAPPED";
                            System.out.println("Vehicle marked as SCRAPPED.");
                            foundScrap = true;
                            break;
                        }
                    }
                    if (!foundScrap) System.out.println("Vehicle not found!");
                    break;

                case 5:
                    System.out.println("\n--- All Vehicles ---");
                    for (int i = 0; i < count; i++) {
                        if (vehicles[i] != null) {
                            vehicles[i].display();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
