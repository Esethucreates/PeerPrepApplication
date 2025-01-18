package org.example.models;

public class UserModel {
    private int userID;
    private String fullName;
    private String email;
    private String password_hash;
    private String qualification;
    private String userStatus;
    private int campusID;

    public UserModel(int userID, String fullName, String email, String password_hash,
                     String qualification, String userStatus, int campusID) {
        this.userID = userID;
        this.fullName = fullName;
        this.email = email;
        this.password_hash = password_hash;
        this.qualification = qualification;
        this.userStatus = userStatus;
        this.campusID = campusID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public int getCampusID() {
        return campusID;
    }

    public void setCampusID(int campusID) {
        this.campusID = campusID;
    }
}
