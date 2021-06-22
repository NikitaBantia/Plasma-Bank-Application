package PlasmaBankPackage;

import java.util.*;

public class Hospital {

    public ArrayList<Hospital> list = new ArrayList<>();
    private int id;
    private String h_name, h_type, h_address, h_location, h_city, h_email;
    private String h_contactnum;
    private ArrayList<ArrayList<String>> bg = new ArrayList<>();

    public Hospital() {

    }

    public Hospital(int id, String n, String t, String a, String l, String c, String e, String cn,
            ArrayList<ArrayList<String>> bg) {
        this.id = id;
        this.h_name = n;
        this.h_type = t;
        this.h_address = a;
        this.h_location = l;
        this.h_city = c;
        this.h_email = e;
        this.h_contactnum = cn;
        this.bg = bg;
    }
    
    public int getID() {
        return id;
    }

    public String getName() {
        return h_name;
    }

    public String getType() {
        return h_type;
    }

    public String getAddress() {
        return this.h_address;
    }

    public String getLocation() {
        return this.h_location;
    }

    public String getCity() {
        return this.h_city;
    }

    public String getMail() {
        return this.h_email;
    }

    public String getContact() {
        return this.h_contactnum;
    }

    public ArrayList<ArrayList<String>> getBloodGroup() {
        return this.bg;
    }

}
