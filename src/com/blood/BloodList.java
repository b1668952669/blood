package com.blood;
 
public class BloodList {
 
    private int id;
    private String name;
    private String type;
    private String volume;
    private String date;
     
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getVolume() {
        return volume;
    }
    public void setVolume(String volume) {
        this.volume = volume;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
     
    public BloodList() {}
     
    public BloodList(int id, String name, String type, String volume, String date) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.volume = volume;
        this.date = date;
    }
     
    public BloodList(String name, String type, String volume, String date) {
        this.name = name;
        this.type = type;
        this.volume = volume;
        this.date = date;
    }
}