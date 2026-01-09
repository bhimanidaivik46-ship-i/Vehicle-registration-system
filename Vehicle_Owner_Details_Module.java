import java.util.Scanner;

class VehicleOwner {

    String ownerName;
    String address;
    String mobileNumber;
    String idProofNumber;

    void setDetails(String name, String address,
                    String mobile, String idProof) {
        this.ownerName = name;
        this.address = address;
        this.mobileNumber = mobile;
        this.idProofNumber = idProof;
    }

    // Mobile number check
    boolean mobilenumber(String mob) {
        if (mob.length() == 10 && (mob.charAt(0) == '9' || mob.charAt(0) == '8')) {
            return true;
        } else {
            System.out.println("Invalid mobile number! Try again.");
            return false;
        }
    }

    // ID proof check
    boolean checkIdProof(String idProof) {
        return idProof.matches("\\d{12}") || idProof.length() >= 6;
    }

    void updateAddress(Scanner sc) {
        System.out.print("Enter New Address: ");
        address = sc.nextLine();
    }

    void changeMobile(Scanner sc) {
        String mob;
        do {
            System.out.print("Enter New Mobile Number: ");
            mob = sc.nextLine();
        } while (!mobilenumber(mob));
        mobileNumber = mob;
    }

    void displayOwner() {
        System.out.println("Owner Name    : " + ownerName);
        System.out.println("Address       : " + address);
        System.out.println("Mobile Number : " + mobileNumber);
        System.out.println("ID Proof      : " + idProofNumber);
    }
}
class VehicleOwnerDetails {

    String vehicleNumber;
    String modelName;
    String vehicleType;

    void inputVehicle(Scanner sc) {
        System.out.print("Enter Vehicle Number: ");
        vehicleNumber = sc.nextLine();

        System.out.print("Enter Model Name: ");
        modelName = sc.nextLine();

        System.out.print("Enter Vehicle Type: ");
        vehicleType = sc.nextLine();
    }

    void updateVehicle(Scanner sc) {
        System.out.print("Enter New Model Name: ");
        modelName = sc.nextLine();

        System.out.print("Enter New Vehicle Type: ");
        vehicleType = sc.nextLine();
    }

    void displayVehicle() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Model Name     : " + modelName);
        System.out.println("Vehicle Type   : " + vehicleType);
    }
}
class VehicleOwnerRun {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VehicleOwner o1 = new VehicleOwner();
        VehicleOwnerDetails V3 = new VehicleOwnerDetails();

        System.out.print("Enter Owner Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        String mobile;
        do {
            System.out.print("Enter Mobile Number: ");
            mobile = sc.nextLine();
        } while (!o1.mobilenumber(mobile));

        String idProof;
        do {
            System.out.print("Enter ID Proof (Aadhaar / License): ");
            idProof = sc.nextLine();
        } while (!o1.checkIdProof(idProof));

        o1.setDetails(name, address, mobile, idProof);

        System.out.println("\nEnter Vehicle Details:");
        V3.inputVehicle(sc);

        do {
            System.out.println("\n--- Update Menu ---");
            System.out.println("1. Update Owner Address");
            System.out.println("2. Change Mobile Number");
            System.out.println("3. Correct Vehicle Details");
            System.out.println("4. Display Records");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

           int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    {
                    o1.updateAddress(sc);
                    break;
                    }

                case 2:
                    {
                    o1.changeMobile(sc);
                    break;
                    }

                case 3:
                    {
                    V3.updateVehicle(sc);
                    break;
                    }

                case 4:
                    {
                    System.out.println("\n--- Owner Details ---");
                    o1.displayOwner();
                    System.out.println("\n--- Vehicle Details ---");
                    V3.displayVehicle();
                    break;
                    }

                case 5:
                    {
                    System.out.println("Exiting Program...");
                    break;
                    }
                default:
                    {
                    System.out.println("Invalid Choice!");
                    }
                }
        } while (choice != 5);
    }
}


