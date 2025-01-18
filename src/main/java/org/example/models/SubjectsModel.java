package org.example.models;

public class SubjectsModel {
    private int subjectID;
    private String subject_name;


    public SubjectsModel(int subjectID, String subject_name) {
        this.subjectID = subjectID;
        this.subject_name = subject_name;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }
}
