import java.util.Random;
import java.util.Scanner;

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
    class numberplate {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
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
        }
    }