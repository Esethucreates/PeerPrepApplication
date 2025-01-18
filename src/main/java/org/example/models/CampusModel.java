package org.example.models;

public class CampusModel {
    private int campusID;
    private String campusName;
    private String campusImg;

    public CampusModel(int campusID, String campusName, String campusImg) {
        this.campusID = campusID;
        this.campusName = campusName;
        this.campusImg = campusImg;
    }

    public int getCampusID() {
        return campusID;
    }

    public void setCampusID(int campusID) {
        this.campusID = campusID;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getCampusImg() {
        return campusImg;
    }

    public void setCampusImg(String campusImg) {
        this.campusImg = campusImg;
    }
}
