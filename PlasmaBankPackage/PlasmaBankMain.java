package PlasmaBankPackage;

import java.util.*;

public class PlasmaBankMain {

    public static void main(String[] args) {
        DBInteraction DB = new DBInteraction();

        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("WELCOME TO PLASMA BANK SERVICE");
        while (true) {
            System.out.println("Press one of the following keys : ");
            System.out.println("1.Register as a Donor\n2.Register as Hospital\n"
                    + "3.Register as Plasma Seeker\n4.Register as Plasma Bank\n5.View All Plasma Banks\n6.View All Plasma Seekers\n7.View All Donors\n"
                    + "8.View All Hospitals\n"
                    + "9.Request Plasma from Hospital\n10.Request Plasma from Plasma Bank\n11. Exit");
            System.out.println("--------------------------------------------------------------------");

            int ch = sc.nextInt();

            switch (ch) {
                case 2:
                    DB.registerHospital();
                    break;

                case 1:
                    DB.DonorRegistration();
                    break;

                case 3:
                    DB.enterDetailsOfSeeker();
                    break;
                case 4:
                    DB.registerPlasmaBank();
                    break;

                case 5:
                    DB.viewPlasmaBank();
                    break;
                case 6:
                    DB.showSeekerDetails();
                    break;
                case 7:
                    DB.showDonorDetails();
                    break;
                case 8:
                    DB.getAllHospitals();
                    break;
                case 9:
                    DB.requestPlasmaHosp();
                    break;
                case 10:
                    DB.requestPlasmaBank();
                    break;
                case 11:
                    System.exit(0);
            }
        }
    }
}
