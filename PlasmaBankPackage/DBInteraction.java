package PlasmaBankPackage;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.EmailValidator;

public class DBInteraction {

    Connection con;
    Statement st;
    Scanner sc;

    DBInteraction() {
        try {
            String url = "jdbc:mysql://localhost:3306/plasmabank";
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(url, "root", "Nikki");
            this.st = con.createStatement();
            sc = new Scanner(System.in);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public static boolean isValidNum(String num) {
        boolean flag = false;
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            if (!Character.isDigit(ch)) {
                flag = true;
                break;
            }
        }
        return (!flag && num.length() == 10);
    }

    public static boolean isValidLoc(String num) {
        boolean flag = true;
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (!Character.isLetter(ch)) {
                flag = false;
                break;
            }
        }
        return (flag);
    }

    public static boolean isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }
//****************************HOSPITAL************************************************************

    public void registerHospital() {
        try {

            System.out.println("Enter the name of the Hospital : ");
            String n = sc.nextLine();
            System.out.println("Is Hospital Private or Government : ");
            String type = sc.nextLine();
            System.out.println("Enter the Address of the Hospital : ");
            String address = sc.nextLine();
            String l;
            do {
                System.out.println("Enter the State of the Hospital : ");
                l = sc.nextLine();
            } while (!isValidLoc(l));
            String c;
            do {
                System.out.println("Enter the City of the Hospital : ");
                c = sc.nextLine();
            } while (!isValidLoc(c));

            String mail;
            do {
                System.out.println("Enter the E-Mail id of the Hospital : ");
                mail = sc.nextLine();
            } while (!isValidEmail(mail));

            String num;
            do {
                System.out.println("Enter the Contact Number of the Hospital : ");
                num = sc.nextLine();
            } while (!isValidNum(num));

            String Qh_id = "select count(h_id) from hospital";
            ResultSet rs = st.executeQuery(Qh_id);
            int h_id = 0;
            while (rs.next()) {
                h_id = rs.getInt(1);
            }
            h_id = h_id + 1;
            String inHos = "insert into hospital(h_id,h_name,h_type,h_address,h_state,h_city,h_email,h_contactno)"
                    + "values(" + h_id + ",'" + n + "','" + type + "','" + address + "','" + l + "','" + c + "','" + mail + "','" + num + "')";
            boolean status = st.execute(inHos);

            if (!status) {
                System.out.println("The Hospital is registered successfully!");
            } else {
                System.out.println("The Hospital is not registered. Please Try again!");
            }

            System.out.println("Enter the Number of Blood Group for which Plasma is available : ");
            int count = sc.nextInt();
            int i = 1;
            System.out.println("Enter the blood group and its units for which Plasma is available : ");
            while (i <= count) {
                String bg = sc.next();
                int unit = sc.nextInt();
                String inHosStore = "insert into hospital_plasmabank values(" + h_id + ",'" + bg + "'," + unit + ")";
                //System.out.println(inHosStore);
                st.execute(inHosStore);
                i++;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void getAllHospitals() {

        try {
            String getAllHos = "select * from hospitalbycity";
            ResultSet rs = st.executeQuery(getAllHos);
            if (rs.next() == false) {
                System.out.println("We are Sorry, Currently No Hospital Available . ");
            } else {
                do {
                    System.out.println("------------------------------------------");
                    System.out.println("Hospital ID : " + rs.getInt("h_id"));
                    System.out.println("Hospital Name : " + rs.getString("h_name"));
                    System.out.println("Hospital Type : " + rs.getString("h_type"));
                    System.out.println("Hospital Address : " + rs.getString("h_address"));
                    System.out.println("Hospital State : " + rs.getString("h_state"));
                    System.out.println("Hospital City : " + rs.getString("h_city"));
                    System.out.println("Hospital E-Mail : " + rs.getString("h_email"));
                    System.out.println("Hospital Contact Number : " + rs.getString("h_contactno"));
                    System.out.println("------------------------------------------");
                } while (rs.next());
                System.out.println("Details of All the Available Blood Group for Plasma : ");
                int ch;
                do {
                    System.out.println("1.Enter the Hospital ID for which you want to see the Plasma Store Details:  \nEnter 0 if you want to Exit");
                    ch = sc.nextInt();
                    switch (ch) {

                        case 1:
                            System.out.println("1.Enter the Hospital ID: ");
                            int hid = sc.nextInt();

                            String getHPlasmaDetails = "select * from hospital_plasmabank where Hospital_h_id='" + hid + "'";
                            ResultSet rs1 = st.executeQuery(getHPlasmaDetails);
                            System.out.println("Hospital ID : " + hid);
                            if (rs1.next() == false) {
                                System.out.println("We are Sorry, This Hospital has no plasma reserves. ");
                            } else {
                                do {
                                    System.out.println("------------------------------------------");
                                    System.out.println("Blood Group : " + rs1.getString("bloodgroup"));
                                    System.out.println("Units : " + rs1.getInt("blood_units"));
                                    System.out.println("------------------------------------------");
                                } while (rs1.next());
                            }
                            break;
                        case 0:
                            break;

                    }
                } while (ch != 0);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void getAvailableHospital(String state, String city, String bg) {

        try {
            String query = "{CALL hospital_Bg_location(?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString(1, state);
            cs.setString(2, city);
            cs.setString(3, bg);
            ResultSet rs = cs.executeQuery();
            if (rs.next() == false) {
                System.out.println("Sorry , No Hospital Available with required details");

            } else {
                System.out.println("The Hospitals Present with the Following Details are : ");
                do {
                    System.out.println("------------------------------------------");
                    System.out.println("Hospital ID : " + rs.getInt(1));
                    System.out.println("Hospital Name : " + rs.getString(2));
                    System.out.println("Hospital Address : " + rs.getString(3));
                    System.out.println("Hospital Contact No. : " + rs.getString(4));
                    System.out.println("BloodGroup : " + rs.getString(5));
                    System.out.println("Units of Plasma Available : " + rs.getString(6));
                    System.out.println("------------------------------------------");
                } while (rs.next());
                System.out.println("Enter the Hospital ID from which Plasma is Required");
                int hosid = sc.nextInt();
                System.out.println("Enter the Units of Plasma");
                int val = sc.nextInt();
                String query2 = "select blood_units from hospital_plasmabank where hospital_h_id = '" + hosid + "'";
                ResultSet rs4 = st.executeQuery(query2);
                int available_unit = 0;
                while (rs4.next()) {
                    available_unit = rs4.getInt(1);
                }

                if (available_unit == 0) {
                    System.out.println("Sorry, the required quantity is not avaialble");
                } else {
                    int diff = available_unit - val;
                    String query3;
                    if (diff > 0) {
                        query3 = "update hospital_plasmabank set blood_units= " + diff + " where hospital_h_id = '" + hosid + "'";
                        System.out.println("Plasma Units Arranged Successfully");
                    } else {
                        query3 = "update hospital_plasmabank set blood_units = 0 " + "where hospital_h_id = '" + hosid + "'";
                        System.out.println("Sorry We have arranged " + available_unit + " , Please arrange " + Math.abs(diff) + " by yourself");
                    }
                    st.executeUpdate(query3);
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void requestPlasmaHosp() {

        System.out.println("Enter the State where Plasma Required : ");
        String state = sc.next();
        sc.nextLine();
        System.out.println("Enter the City where Plasma Required : ");
        String city = sc.nextLine();

        System.out.println("Enter the Blood Group for which Plasma Required : ");
        String bg = sc.nextLine();
        getAvailableHospital(state, city, bg);
    }
//    **************************Hospital Ended***************************************

//    **************************Seeker Start***************************************
    public void enterDetailsOfSeeker() {
        try {
            System.out.println("Enter your Name: ");
            String name = sc.nextLine();
            System.out.println("Enter your Blood Group: ");
            String blood_group = sc.nextLine();

            String contact_no;

            do {
                System.out.println("Enter the Contact Number: ");
                contact_no = sc.nextLine();
            } while (!isValidNum(contact_no));

            System.out.println("Enter the required Units of Plasma: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter The Required Date (yyyy/mm/dd): ");
            String seeking_date = sc.nextLine();

            String state;
            do {
                System.out.println("Enter the state: ");
                state = sc.nextLine();
            } while (!isValidLoc(state));
            String city;
            do {
                System.out.println("Enter the city: ");
                city = sc.nextLine();
            } while (!isValidLoc(city));
            String Qs_id = "select count(s_id) from seeker";
            ResultSet rs = st.executeQuery(Qs_id);
            int s_id = 0;
            while (rs.next()) {
                s_id = rs.getInt(1);
            }
            s_id = s_id + 1;
            String inSeeker = "insert into seeker "
                    + "values(" + s_id + ",'" + name + "','" + blood_group + "','" + quantity + "','" + seeking_date + "',"
                    + "'" + city + "','" + state + "','" + contact_no + "')";
            boolean status = st.execute(inSeeker);
            if (!status) {
                System.out.println("The seeker is registered successfully!");
            } else {
                System.out.println("The seeker is not registered. Please Try again!");
            }
            int ch;
            do{
                System.out.println("Enter the choice for which you want to see the matching plasma details:\n"
                        + "1. Hospital\n2. Plasma Bank\n3. Donors\n4. Exit ");
                ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        getAvailableHospital(state, city, blood_group);
                        break;

                    case 2:
                        showListOfMatchingPlasma(state, city, blood_group);
                        break;

                    case 3:
                        showListOfMatchingDonors(state, city, blood_group);
                        break;
                    
                }
            }while(ch!=4);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void showSeekerDetails() {
        try {
            String query = "{CALL delSeekerAfter7Days()}";
            CallableStatement cs = con.prepareCall(query);
            cs.execute();
            String seek_date = "select * from seekerbydate";
            ResultSet rs = st.executeQuery(seek_date);
            if (rs.next() == false) {
                System.out.println("No seekers are present");
            } else {
                do {
                    System.out.println("------------------------------------------");
                    System.out.println("ID: " + rs.getInt("s_id"));
                    System.out.println("Name: " + rs.getString("s_name"));
                    System.out.println("Blood Group: " + rs.getString("s_bg"));
                    System.out.println("Contact Number: " + rs.getString("s_contactno"));
                    System.out.println("Units of Plasma: " + rs.getString("s_units"));
                    System.out.println("Date: " + rs.getString("s_date"));
                    System.out.println("City: " + rs.getString("s_city"));
                    System.out.println("State: " + rs.getString("s_state"));
                    System.out.println("------------------------------------------");
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void checkExistingSeeker(String state, String city, String bg) {

        try {
            String query3 = "{CALL checkExistingSeeker(?,?,?)}";
            CallableStatement cs = con.prepareCall(query3);
            cs.setString(1, state);
            cs.setString(2, city);
            cs.setString(3, bg);
            ResultSet rs = cs.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Seeker is in need at your location.");

            } else {
                System.out.println("The Seeker in need of Plasma are : ");
                do {
                    System.out.println("-----------------------------------------");
                    System.out.println("ID: " + rs.getInt("s_id"));
                    System.out.println("Name: " + rs.getString("s_name"));
                    System.out.println("Blood Group: " + rs.getString("s_bg"));
                    System.out.println("Contact Number: " + rs.getString("s_contactno"));
                    System.out.println("Units of Plasma: " + rs.getString("s_units"));
                    System.out.println("Date: " + rs.getString("s_date"));
                    System.out.println("City: " + rs.getString("s_city"));
                    System.out.println("State: " + rs.getString("s_state"));
                    System.out.println("-----------------------------------------");
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

//******************************Donor Start**************************************
    public void DonorRegistration() {
        try {
            int donor_id;
            String name;
            String bloodgroup;
            String contact_no;
            String city;
            String location;
            System.out.println("------------------------");
            System.out.println("Enter your Name : ");
            name = sc.nextLine();
            System.out.println("Enter your Blood Group!");
            bloodgroup = sc.nextLine();
            //s.nextLine();
            System.out.println("Enter your age");
            int age = sc.nextInt();
            do {
                System.out.println("Enter the Contact Number: ");
                contact_no = sc.next();
            } while (!isValidNum(contact_no));
            System.out.println("Enter the Units of Plasma willing to donate(200ml = 1 Unit): ");
            int units = sc.nextInt();
            sc.nextLine();
            do {
                System.out.println("Enter the state: ");
                location = sc.nextLine();
            } while (!isValidLoc(location));

            do {
                System.out.println("Enter the city: ");
                city = sc.nextLine();
            } while (!isValidLoc(city));
            String Qs_id = "Select count(d_id) from donor";
            ResultSet rs = st.executeQuery(Qs_id);
            int d_id = 0;
            while (rs.next()) {
                d_id = rs.getInt(1);
            }
            d_id = d_id + 1;
            String inDonor = "insert into donor values(" + d_id + ",'" + name + "','" + bloodgroup + "','" + age + "','" + units + "',"
                    + "'" + location + "','" + city + "','" + contact_no + "')";
            boolean status = st.execute(inDonor);
            System.out.println(status);
            if (!status) {
                System.out.println("The donor is registered successfully!");
            } else {
                System.out.println("The donor is not registered. Please Try again!");
            }

            checkExistingSeeker(location, city, bloodgroup);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void showDonorDetails() {
        try {

            String donor_list = "select * from showdonor";
            ResultSet rs = st.executeQuery(donor_list);
            if (rs.next() == false) {
                System.out.println("No donors are present");
            } else {
                do {
                    System.out.println("-----------------------------------------");
                    System.out.println("ID: " + rs.getInt("d_id"));
                    System.out.println("Name: " + rs.getString("d_name"));
                    System.out.println("Age: " + rs.getString("d_age"));
                    System.out.println("Blood Group: " + rs.getString("d_bg"));
                    System.out.println("Contact Number: " + rs.getString("d_contactno"));
                    System.out.println("Units of Plasma: " + rs.getString("d_units"));
                    System.out.println("City: " + rs.getString("d_city"));
                    System.out.println("State: " + rs.getString("d_state"));
                    System.out.println("-----------------------------------------");
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    ///function with sorted age
    public void showListOfMatchingDonors(String state, String city,String bg) {

        try {
            String query1 = "{CALL donor_Bg_location(?,?,?)}";
            CallableStatement cs = con.prepareCall(query1);
            cs.setString(1, state);
            cs.setString(2, city);
            cs.setString(3, bg);
            ResultSet rs = cs.executeQuery();
            if (rs.next() == false) {
                System.out.println("Sorry , No Donor Available with required details");

            } else {
                System.out.println("The Donors Present with the Following Details are : ");
                do {
                    System.out.println("-----------------------------------------");
                    System.out.println("ID: " + rs.getInt("d_id"));
                    System.out.println("Name: " + rs.getString("d_name"));
                    System.out.println("Age: " + rs.getString("d_age"));
                    System.out.println("Blood Group: " + rs.getString("d_bg"));
                    System.out.println("Contact Number: " + rs.getString("d_contactno"));
                    System.out.println("Units of Plasma: " + rs.getString("d_units"));
                    System.out.println("City: " + rs.getString("d_city"));
                    System.out.println("State: " + rs.getString("d_state"));
                    System.out.println("-----------------------------------------");
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void showListOfMatchingPlasma(String state, String city, String bg) {

        try {
            String query2 = "{CALL plasma_Bg_location(?,?,?)}";
            CallableStatement cs = con.prepareCall(query2);
            cs.setString(1, state);
            cs.setString(2, city);
            cs.setString(3, bg);
            ResultSet rs = cs.executeQuery();
            if (rs.next() == false) {
                System.out.println("Sorry , No Plasma Bank Available with required details");

            } else {
                System.out.println("The Plasma Banks Present with the Following Details are : ");
                do {

                    System.out.println("------------------------------------------");
                    System.out.println("Plasma Bank ID : " + rs.getInt("p_id"));
                    System.out.println("Plasma Bank Name : " + rs.getString("p_name"));
                    System.out.println("Plasma Bank State : " + rs.getString("p_state"));
                    System.out.println("Plasma Bank City : " + rs.getString("p_city"));
                    System.out.println("Plasma Bank Contact Number : " + rs.getString("p_contactno"));
                    System.out.println("------------------------------------------");
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void registerPlasmaBank() {
        try {
            System.out.println("Enter the name of the Plasma Bank : ");
            String n = sc.nextLine();
            String l;
            do {
                System.out.println("Enter the state of the Plasma Bank :: ");
                l = sc.nextLine();
            } while (!isValidLoc(l));
            sc.nextLine();
            String c;
            do {
                System.out.println("Enter the City of the Plasma Bank : : ");
                c = sc.nextLine();
            } while (!isValidLoc(c));
            String contact_no;
            do {
                System.out.println("Enter the Contact Number of the Plasma Bank :: ");
                contact_no = sc.next();
            } while (!isValidNum(contact_no));

            String Qp_id = "Select count(p_id) from plasmabank";
            ResultSet rs = st.executeQuery(Qp_id);
            int p_id = 0;
            while (rs.next()) {
                p_id = rs.getInt(1);
            }
            p_id = p_id + 1;
            String inPlasma = "insert into plasmabank "
                    + "values(" + p_id + ",'" + n + "','" + l + "','" + c + "','" + contact_no + "')";
            boolean status = st.execute(inPlasma);
            if (!status) {
                System.out.println("The Plasma Bank is registered successfully!");
            } else {
                System.out.println("The Plasma Bank is not registered. Please Try again!");
            }

            System.out.println("Enter the Number of Blood Group for which Plasma is available : ");
            int count = sc.nextInt();
            int i = 1;
            System.out.println("Enter the blood group and its units for which Plasma is available : ");
            while (i <= count) {
                String bg = sc.next();
                int unit = sc.nextInt();
                String inPlasmaStore = "insert into plasmabank_storage values(" + p_id + ",'" + bg + "'," + unit + ")";
                //System.out.println(inPlasmaStore);
                st.execute(inPlasmaStore);
                i++;
            }
            System.out.println("Below is the list of all Plasma:");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void viewPlasmaBank() {

        try {
            String getAllBank = "select * from plasmabankcity";
            ResultSet rs = st.executeQuery(getAllBank);
            if (rs.next() == false) {
                System.out.println("We are Sorry, Currently No Plasma Bank is Available . ");
            } else {
                do {
                    System.out.println("------------------------------------------");
                    System.out.println("Plasma Bank ID : " + rs.getInt("p_id"));
                    System.out.println("Plasma Bank Name : " + rs.getString("p_name"));
                    System.out.println("Plasma Bank State : " + rs.getString("p_state"));
                    System.out.println("Plasma Bank City : " + rs.getString("p_city"));
                    System.out.println("Plasma Bank Contact Number : " + rs.getString("p_contactno"));
                    System.out.println("------------------------------------------");
                } while (rs.next());
                System.out.println("Details of All the Available Blood Group for Plasma : ");

                System.out.println("Enter the Plasma Bank ID for which you want to see the Plasma Store Details:  ");
                int pid = sc.nextInt();
                String getPPlasmaDetails = "select * from plasmabank_storage where PlasmaBank_p_id='" + pid + "'";
                ResultSet rs1 = st.executeQuery(getPPlasmaDetails);
                System.out.println("Plasma Bank ID : " + pid);
                if (rs1.next() == false) {
                    System.out.println("We are Sorry, This Plasma Bank has no plasma reserves. ");
                } else {
                    do {
                        System.out.println("------------------------------------------");
                        System.out.println("Blood Group : " + rs1.getString("bloodgroup"));
                        System.out.println("Units : " + rs1.getInt("units"));
                        System.out.println("------------------------------------------");
                        
                    } while (rs1.next());

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
      public void requestPlasmaBank() {

        System.out.println("Enter the State where Plasma Required : ");
        String state = sc.nextLine();
        System.out.println("Enter the City where Plasma Required : ");
        String city = sc.nextLine();

        System.out.println("Enter the Blood Group for which Plasma Required : ");
        String bg = sc.nextLine();
        showListOfMatchingPlasma(state, city, bg);
    }
      
    }
      
      
   