import java.util.Scanner;
import java.util.Random;
import java.util.Date;

class PasswordUtil {

    static String generatePassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#";
        Random r = new Random();
        String pass = "";

        for (int i = 0; i < 6; i++) {   // 6 digit password
            pass = pass + chars.charAt(r.nextInt(chars.length()));
        }
        return pass;
    }
}
class VehicleOwner extends PasswordUtil {

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
class VehicleOwnerDetails extends VehicleOwner {

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
class VehicleType extends VehicleOwnerDetails {
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
class FuelType extends VehicleType{
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
class Vehicle extends FuelType {
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
class Vehicles extends Vehicle{
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

class RegistrationService extends Vehicle{
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
class VehiclePlateGenerator extends RegistrationService{

    static final String[] STATE_NAMES = {
            "ANDHRA PRADESH",
            "ARUNACHAL PRADESH",
            "ASSAM",
            "BIHAR",
            "CHHATTISGARH",
            "GOA",
            "GUJARAT",
            "HARYANA",
            "HIMACHAL PRADESH",
            "JHARKHAND",
            "KARNATAKA",
            "KERALA",
            "MADHYA PRADESH",
            "MAHARASHTRA",
            "MANIPUR",
            "MEGHALAYA",
            "MIZORAM",
            "NAGALAND",
            "ODISHA",
            "PUNJAB",
            "RAJASTHAN",
            "SIKKIM",
            "TAMIL NADU",
            "TELANGANA",
            "TRIPURA",
            "UTTAR PRADESH",
            "UTTARAKHAND",
            "WEST BENGAL",
            "ANDAMAN AND NICOBAR",
            "CHANDIGARH",
            "DADRA AND NAGAR HAVELI AND DAMAN AND DIU",
            "DELHI",
            "JAMMU AND KASHMIR",
            "LADAKH",
            "LAKSHADWEEP",
            "PUDUCHERRY"
    };

    static final String[] STATE_CODES = {
            "AP",
            "AR",
            "AS",
            "BR",
            "CG",
            "GA",
            "GJ",
            "HR",
            "HP",
            "JH",
            "KA",
            "KL",
            "MP",
            "MH",
            "MN",
            "ML",
            "MZ",
            "NL",
            "OD",
            "RJ",
            "SK",
            "TN",
            "TS",
            "TR",
            "UP",
            "UK",
            "WB",
            "AN",
            "CH",
            "DN",
            "DL",
            "JK",
            "LA",
            "LD",
            "PY"
    };

    static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String NUMBERS = "0123456789";

    static String getStateCode(String name) {
        for (int i = 0; i < STATE_NAMES.length; i++) {
            if (STATE_NAMES[i].equals(name)) {
                return STATE_CODES[i];
            }
        }
        return "GJ"; // default
    }

    // Plate generation method
    static String generatePlate(String stateCode, String districtCode) {
        Random r = new Random();
        String plate = stateCode + districtCode;

        for (int i = 0; i < 2; i++)
            plate += LETTERS.charAt(r.nextInt(LETTERS.length()));

        for (int i = 0; i < 4; i++)
            plate += NUMBERS.charAt(r.nextInt(NUMBERS.length()));

        return plate;
    }
}
class Vehiclestockcheck extends VehiclePlateGenerator{
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
class TaxInsurance {

    String roadTaxStatus;
    String insuranceNumber;
    String insuranceExpiryDate;

    // Method to take details
    void inputDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Road Tax Status (Paid / Unpaid) : ");
        roadTaxStatus = sc.nextLine();

        System.out.print("Insurance Number : ");
        insuranceNumber = sc.nextLine();

        System.out.print("Insurance Expiry Date (DD-MM-YYYY) : ");
        insuranceExpiryDate = sc.nextLine();
    }

    // Method to display details
    void displayDetails() {
        System.out.println("\n---- TAX & INSURANCE DETAILS ----");
        System.out.println("Road Tax Status      : " + roadTaxStatus);
        System.out.println("Insurance Number     : " + insuranceNumber);
        System.out.println("Insurance Expiry Date: " + insuranceExpiryDate);
    }
}
class Vehiclereportdetali extends Vehiclestockcheck{
    String vehicleNumber;
    String ownerName;
    String regDate;
    Vehiclereportdetali(String vno, String owner, String date) {
        vehicleNumber = vno;
        ownerName = owner;
        regDate = date;
    }
}

// Report class
class VehicleReport extends TaxInsurance{

    Vehiclereportdetali[] vehicles = new Vehiclereportdetali[10];
    int count = 0;

    // Add vehicle
    void addVehicle(String vno, String owner, String date) {
        vehicles[count++] = new Vehiclereportdetali(vno, owner, date);
    }


    void listAllVehicles() {
        System.out.println("\n--- LIST OF REGISTERED VEHICLES ---");
        for (int i = 0; i < count; i++) {
            System.out.println(
                    vehicles[i].vehicleNumber + " | " +
                            vehicles[i].ownerName + " | " +
                            vehicles[i].regDate
            );
        }
    }


    void vehiclesByDate(String date) {
        System.out.println("\n--- VEHICLES ON DATE: " + date + " ---");
        for (int i = 0; i < count; i++) {
            if (vehicles[i].regDate.equals(date)) {
                System.out.println(
                        vehicles[i].vehicleNumber + " | " +
                                vehicles[i].ownerName
                );
            }
        }
    }


    void vehiclesByOwner(String owner) {
        System.out.println("\n--- VEHICLES OF OWNER: " + owner + " ---");
        for (int i = 0; i < count; i++) {
            if (vehicles[i].ownerName.equalsIgnoreCase(owner)) {
                System.out.println(
                        vehicles[i].vehicleNumber + " | " +
                                vehicles[i].regDate
                );
            }
        }
    }
}
class VehicleSecurity extends VehiclePlateGenerator {
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
class VehicleSecurity2{
    String vehicleNumber;
    String ownerName;

    VehicleSecurity2(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }
}

// System class
class VehicleSystem{

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

class VehicleSystem3{
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

class RUN {

    static String username;
    static String password;   // generated password

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Username input
        System.out.print("Enter Username : ");
        username = sc.nextLine();

        // Auto-generate password
        password = PasswordUtil.generatePassword();

        System.out.println("Generated Password (save it): " + password);

        System.out.println("\n------ LOGIN ------");

        // Login input
        System.out.print("Enter Username : ");
        String u = sc.nextLine();

        System.out.print("Enter Password : ");
        String p = sc.nextLine();

        // Authentication
        if (u.equals(username) && p.equals(password)) {
            System.out.println(" LOGIN SUCCESSFUL");
        } else {
            System.out.println(" LOGIN FAILED");
        }
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

        int choice;
        do {
            System.out.println("\n--- Update Menu ---");
            System.out.println("1. Update Owner Address");
            System.out.println("2. Change Mobile Number");
            System.out.println("3. Correct Vehicle Details");
            System.out.println("4. Display Records");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    o1.updateAddress(sc);
                    break;

                case 2:
                    o1.changeMobile(sc);
                    break;

                case 3:
                    V3.updateVehicle(sc);
                    break;

                case 4:
                    System.out.println("\n--- Owner Details ---");
                    o1.displayOwner();
                    System.out.println("\n--- Vehicle Details ---");
                    V3.displayVehicle();
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 5);
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
        RegistrationService sv= new RegistrationService();
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
        VehiclePlateGenerator p1 = new VehiclePlateGenerator();

        System.out.println("Enter State Name:");
        String stateName = sc.nextLine().toUpperCase();
        String stateCode = p1.getStateCode(stateName);

        System.out.print("Enter District Code (ex:-AHEMDABAD=01): ");
        String district = sc.next();

        if (district.length() == 1){
            district = "0" + district;
        }

        System.out.print("How many plates? ");
        int n = sc.nextInt();

        System.out.println("\nGenerated Vehicle Plates:");
        for (int i = 1; i <= n; i++) {
            System.out.println(i + ". " + p1.generatePlate(stateCode, district));
        }
        Vehiclestockcheck[] vehicles = new Vehiclestockcheck[5];
        int count = 0;  // Number of vehicles added

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
        TaxInsurance ti = new TaxInsurance();

        System.out.print("Do you want to enter Tax & Insurance details? (yes/no): ");
        String choiceS = sc.nextLine();

        if (choiceS.equalsIgnoreCase("yes")) {
            ti.inputDetails();
            ti.displayDetails();
        } else {
            System.out.println("Tax & Insurance details skipped.");
        }
        VehicleReport vr = new VehicleReport();

        // Sample data
        vr.addVehicle("GJ01AB1234", "Ramesh", "10-01-2026");
        vr.addVehicle("GJ05CD5678", "Suresh", "10-01-2026");
        vr.addVehicle("MH12EF9999", "Ramesh", "11-01-2026");

        vr.listAllVehicles();

        System.out.print("\nEnter date (DD-MM-YYYY): ");
        String date = sc.nextLine();
        vr.vehiclesByDate(date);

        System.out.print("\nEnter owner name: ");
        String owner = sc.nextLine();
        vr.vehiclesByOwner(owner);
        VehicleSystem vs = new VehicleSystem();
        VehicleSystem3 vs2 = new VehicleSystem3();

        while (true) {
            System.out.println("\n1. Add Vehicle");
            System.out.println("2. Delete Vehicle (Admin only)");
            System.out.println("3. Display Vehicles");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

             choice = sc.nextInt();
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

        /*do {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Vehicle Security System");
            System.out.println("2. Online Vehicle Registration");
            System.out.println("3. Display Security Vehicles");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    vs2.addVehicle();
                    break;

                case 2:
                    vs2.addVehicle();
                    break;

                case 3:
                    vs2.displayVehicles();
                    break;

                case 4:
                    System.out.println("Program Ended");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);*/
    }
}