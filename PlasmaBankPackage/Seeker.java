package PlasmaBankPackage;

import java.util.Scanner;

public class Seeker {

    Scanner ob = new Scanner(System.in);
    int seeker_id;
    String name = "";
    String blood_group = "";
    String contact_no = "";
    int quantity;
    String seeking_date = "";
    String location = "";

    Seeker(int id, String n, String bg, String con, int q, String sd, String loc) {

        setId(id);
        setName(n);
        setBloodGroup(bg);
        setContact(con);
        setQuantity(q);
        setDate(sd);
        setLocation(loc);

    }

    public void setId(int id) {
        this.seeker_id = id;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setBloodGroup(String bg) {
        this.blood_group = bg;
    }

    public void setContact(String con) {
        this.contact_no = con;
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }

    public void setDate(String date) {
        this.seeking_date = date;
    }

    public void setLocation(String loc) {
        this.location = loc;
    }
    //*********************************

    public int getId() {
        return seeker_id;
    }

    public String getName() {
        return name;
    }

    public String getBloodGroup() {
        return blood_group;
    }

    public String getContact() {
        return contact_no;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return seeking_date;
    }

    public String getLocation() {
        return location;
    }

}
