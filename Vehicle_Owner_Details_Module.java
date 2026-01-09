import java.util.Scanner;

class VehicleOwner {

     String ownerName;
     String address;
    String mobileNumber;
     String idProofNumber;

    // Set owner details
    void setDetails(String name, String address,
                    String mobile, String idProof) {
        this.ownerName = name;
        this.address = address;
        this.mobileNumber = mobile;
        this.idProofNumber = idProof;
    }
    boolean mobilenumber(String mob) {
        if (mob.length() == 10 && (mob.charAt(0) == '9' || mob.charAt(0) == '8')) {
            return true;
        } else {
            System.out.println("Invalid mobile number! Try again.");
            return false;
        }
    }
    
        boolean checkIdProof(String idProof) {
            if (idProof.matches("\\d{12}") || idProof.length() >= 6) {
                return true;
            }
            return false;
        }

        void setIdProofNumber(String idProofNumber) {
            this.idProofNumber = idProofNumber;
        }


    // Display owner details
    void displayDetails() {
        System.out.println("Owner Name     : " + ownerName);
        System.out.println("Address        : " + address);
        System.out.println("Mobile Number  : " + mobileNumber);
        System.out.println("ID Proof       : " + idProofNumber);
    }
}

class VehicleOwnerRun {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VehicleOwner o1= new VehicleOwner();

        System.out.print("Enter Owner Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        String mobile="";
        do {
            System.out.println("Enter Mobile No : ");
            mobile= sc.nextLine();
        } while (!o1.mobilenumber(mobile));

        String idProof;
        do {
            System.out.print("Enter ID Proof (Aadhaar / License): ");
            idProof = sc.nextLine();

            if (!o1.checkIdProof(idProof)) {
                System.out.println("Invalid ID Proof! Try again.");
            }
        } while (!o1.checkIdProof(idProof));

        o1.setIdProofNumber(idProof);


        o1.setDetails(name, address, mobile, idProof);

        System.out.println("\n--- Vehicle Owner Details ---");
        o1.displayDetails();

    }
}

