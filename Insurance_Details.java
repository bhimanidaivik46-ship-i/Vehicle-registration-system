import java.util.Scanner;

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
class VehicleSystemMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaxInsurance ti = new TaxInsurance();

        System.out.print("Do you want to enter Tax & Insurance details? (yes/no): ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            ti.inputDetails();
            ti.displayDetails();
        } else {
            System.out.println("Tax & Insurance details skipped.");
        }
    }
}
