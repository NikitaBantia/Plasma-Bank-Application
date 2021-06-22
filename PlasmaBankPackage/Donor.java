package PlasmaBankPackage;

import java.io.*;
import java.util.*;
public class Donor {

    int donor_id;
    String name;
    String bloodgroup;
    int age;
    String contact_no;
    int units;
    String city;
    String location;

    Donor(int donor_id, String name, String bloodgroup, int age, String contact_no, int units, String city, String location) {
        setid(donor_id);
        setname(name);
        setbloodgroup(bloodgroup);
        setAge(age);
        setUnitsOfPlasma(units);
        setcontact_no(contact_no);
        setcity(city);
        setlocation(location);
    }

    public void setid(int donor_id) {
        this.donor_id = donor_id;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setbloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public void setcontact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public void setUnitsOfPlasma(int units) {
        this.units = units;
    }

    public void setcity(String city) {
        this.city = city;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    public int getid() {
        return donor_id;
    }

    public String getname() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getbloodgroup() {
        return bloodgroup;
    }

    public String getcontact_no() {
        return contact_no;
    }

    public int getUnits() {
        return units;
    }

    public String getcity() {
        return city;
    }

    public String getlocation() {
        return location;
    }
}
