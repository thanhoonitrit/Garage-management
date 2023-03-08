package model;

import java.sql.Date;

/**
 *
 * @author duc21
 */
public class Student {
    private int id;
    private String name;
    private Date dob;
    private int cid;
    private int vid;
    private Classes classes;
    private Vehicle vehicle;


    public Student() {
    }

    public Student(int id, String name, Date dob, int cid, int vid, Classes classes, Vehicle vehicle) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.cid = cid;
        this.vid = vid;
        this.classes = classes;
        this.vehicle = vehicle;
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    } 

}
