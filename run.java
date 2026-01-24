import java.util.Scanner;
import java.util.Random;
import java.util.Date;

/* ======================================================
 PASSWORD UTILITY CLASS
 ====================================================== */
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

/* ======================================================
 NUMBER PLATE GENERATOR
 ====================================================== */
class VehiclePlateGenerator {

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

    /* ======================================================
     VEHICLE OWNER CLASS
     ====================================================== */
    class VehicleOwner {

        String name;
        String address;
        String mobile;
        String idProof;

        void setOwnerDetails(String n, String a, String m, String id) {
            name = n;
            address = a;
            mobile = m;
            idProof = id;
        }

        boolean validateMobile() {
            return mobile.length() == 10;
        }

        void displayOwner() {
            System.out.println("Owner Name   : " + name);
            System.out.println("Address      : " + address);
            System.out.println("Mobile No    : " + mobile);
            System.out.println("ID Proof No  : " + idProof);
        }
    }

    /* ======================================================
     VEHICLE CLASS
     ====================================================== */
    class Vehicle {

        static int regCounter = 1000;

        int regId;
        String vehicleNo;
        String model;
        String type;
        String fuel;
        String plateNo;
        String status;

        Vehicle(String vNo, String m, String t, String f, String plate) {
            regCounter++;
            regId = regCounter;
            vehicleNo = vNo;
            model = m;
            type = t;
            fuel = f;
            plateNo = plate;
            status = "ACTIVE";
        }

        void displayVehicle() {
            System.out.println("Reg ID       : " + regId);
            System.out.println("Vehicle No   : " + vehicleNo);
            System.out.println("Model        : " + model);
            System.out.println("Type         : " + type);
            System.out.println("Fuel         : " + fuel);
            System.out.println("Plate No     : " + plateNo);
            System.out.println("Status       : " + status);
        }
    }

    /* ======================================================
     RC BOOK CLASS
     ====================================================== */
    class RCBook {

        String rcNumber;
        String ownerName;
        String address;
        String vehicleNo;
        String plateNo;
        String model;
        String type;
        String fuel;
        Date regDate;
        String validity;
        String status;

        RCBook(VehicleOwner owner, Vehicle v) {
            rcNumber = "RC" + v.regId;
            ownerName = owner.name;
            address = owner.address;
            vehicleNo = v.vehicleNo;
            plateNo = v.plateNo;
            model = v.model;
            type = v.type;
            fuel = v.fuel;
            status = v.status;
            regDate = new Date();
            validity = "15 YEARS";
        }

        void displayRC() {
            System.out.println("\n========== DIGITAL RC BOOK ==========");
            System.out.println("RC Number     : " + rcNumber);
            System.out.println("Owner Name    : " + ownerName);
            System.out.println("Address       : " + address);
            System.out.println("Vehicle No    : " + vehicleNo);
            System.out.println("Plate No      : " + plateNo);
            System.out.println("Model         : " + model);
            System.out.println("Type          : " + type);
            System.out.println("Fuel          : " + fuel);
            System.out.println("Reg Date      : " + regDate);
            System.out.println("Validity      : " + validity);
            System.out.println("Status        : " + status);
            System.out.println("====================================");
        }
    }

    /* ======================================================
     VEHICLE SYSTEM (MAIN LOGIC)
     ====================================================== */
    class VehicleSystem {

        Scanner sc = new Scanner(System.in);

        VehicleOwner[] owners = new VehicleOwner[50];
        Vehicle[] vehicles = new Vehicle[50];
        RCBook[] rcBooks = new RCBook[50];

        int count = 0;

        /* ----------------------------------------------
           REGISTER VEHICLE
        ---------------------------------------------- */
        void registerVehicle() {

            VehicleOwner owner = new VehicleOwner();

            System.out.print("Enter Owner Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Address: ");
            String addr = sc.nextLine();

            System.out.print("Enter Mobile No: ");
            String mob = sc.nextLine();

            System.out.print("Enter ID Proof No: ");
            String id = sc.nextLine();

            owner.setOwnerDetails(name, addr, mob, id);

            if (!owner.validateMobile()) {
                System.out.println("Invalid Mobile Number!");
                return;
            }

            System.out.print("Vehicle Number: ");
            String vNo = sc.nextLine();

            System.out.print("Model: ");
            String model = sc.nextLine();

            System.out.print("Type (BIKE/CAR/TRUCK): ");
            String type = sc.nextLine();

            System.out.print("Fuel (PETROL/DIESEL/ELECTRIC): ");
            String fuel = sc.nextLine();

            System.out.println("Enter State Name:");
            String stateName = sc.nextLine().toUpperCase();

            // static method call (NO object needed)
            String stateCode = VehiclePlateGenerator.getStateCode(stateName);

            System.out.print("Enter District Code (ex:- AHMEDABAD = 01): ");
            String district = sc.nextLine();

            if (district.length() == 1) {
                district = "0" + district;
            }

            System.out.print("How many plates to generate? ");
            int n = sc.nextInt();
            sc.nextLine();   // buffer clear

            System.out.println("\nGenerated Vehicle Plates:");
            String plate = "";   // last generated plate store karega

            for (int i = 1; i <= n; i++) {
                plate = VehiclePlateGenerator.generatePlate(stateCode, district);
                System.out.println(i + ". " + plate);
            }

            /* Use ONE plate for vehicle registration */
            Vehicle v = new Vehicle(vNo, model, type, fuel, plate);


            owners[count] = owner;
            vehicles[count] = v;
            rcBooks[count] = new RCBook(owner, v);

            count++;

            System.out.println("\nVehicle Registered Successfully!");
            System.out.println("Generated Plate No: " + plate);
            System.out.println("Registration ID  : " + v.regId);
        }

        /* ----------------------------------------------
           DISPLAY ALL RECORDS
        ---------------------------------------------- */
        void displayAll() {

            if (count == 0) {
                System.out.println("No Records Found!");
                return;
            }

            for (int i = 0; i < count; i++) {
                System.out.println("\n--------------------------------");
                owners[i].displayOwner();
                vehicles[i].displayVehicle();
            }
        }

        /* ----------------------------------------------
           SEARCH VEHICLE
        ---------------------------------------------- */
        void searchVehicle() {

            System.out.print("Enter Registration ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < count; i++) {
                if (vehicles[i].regId == id) {
                    owners[i].displayOwner();
                    vehicles[i].displayVehicle();
                    return;
                }
            }
            System.out.println("Vehicle Not Found!");
        }

        /* ----------------------------------------------
           UPDATE STATUS
        ---------------------------------------------- */
        void updateStatus() {

            System.out.print("Enter Registration ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < count; i++) {
                if (vehicles[i].regId == id) {
                    System.out.print("Enter New Status: ");
                    vehicles[i].status = sc.nextLine();
                    rcBooks[i].status = vehicles[i].status;
                    System.out.println("Status Updated!");
                    return;
                }
            }
            System.out.println("Vehicle Not Found!");
        }

        /* ----------------------------------------------
           VIEW RC BOOK
        ---------------------------------------------- */
        void viewRC() {

            System.out.print("Enter Registration ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < count; i++) {
                if (vehicles[i].regId == id) {
                    rcBooks[i].displayRC();
                    return;
                }
            }
            System.out.println("RC Book Not Found!");
        }
    }

    /* ======================================================
   **********************  MAIN CLASS  **********************
     ====================================================== */
    class SmartVehicleRegistration {

        static String username;
        static String password;// generated password

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            VehicleSystem vs = new VehicleSystem();

            System.out.print("Enter Username : ");
            username = sc.nextLine();

            // Auto-generate password
            password = PasswordUtil.generatePassword();

            System.out.println("Generated Password (save it): " + password);



            System.out.println("::::::::::::::::::::::::::::::::::::::");
            System.out.println(" SMART VEHICLE REGISTRATION SYSTEM ");
            System.out.println("::::::::::::::::::::::::::::::::::::::");

            System.out.println("\n------ LOGIN ------");
            int flag = 0;
            do {
                // Login input
                System.out.print("Enter Username : ");
                String u = sc.nextLine();

                System.out.print("Enter Password : ");
                String p = sc.nextLine();
                // Authentication
                if (u.equals(username) && p.equals(password)) {
                    System.out.println(" LOGIN SUCCESSFUL");
                    flag++;
                } else {
                    System.out.println(" LOGIN FAILED");
                }
            } while (flag != 1);

            int choice;

            do {
                System.out.println("\n========== MENU ==========");
                System.out.println("1. Register Vehicle");
                System.out.println("2. Display All Records");
                System.out.println("3. Search Vehicle");
                System.out.println("4. Update Vehicle Status");
                System.out.println("5. View RC Book");
                System.out.println("0. Exit");
                System.out.print("Choose Option: ");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> vs.registerVehicle();
                    case 2 -> vs.displayAll();
                    case 3 -> vs.searchVehicle();
                    case 4 -> vs.updateStatus();
                    case 5 -> vs.viewRC();
                    case 0 -> System.out.println("Thank You!");
                    default -> System.out.println("Invalid Choice!");
                }

            } while (choice != 0);
        }
    }
