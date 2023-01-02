package com.example.geektrust.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AllotmentResponse {

    private List<Allotment> allotments;

    public AllotmentResponse(List<Allotment> allotments) {
        this.allotments = allotments;
    }

    public List<Allotment> getAllotments() {
        return allotments;
    }

    public void setAllotments(List<Allotment> allotments) {
        this.allotments = allotments;
    }

    @Override
    public String toString() {
        return "AllotmentResponse{" +
                "allotments=" + allotments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllotmentResponse that = (AllotmentResponse) o;
        return Objects.equals(allotments, that.allotments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allotments);
    }
}

class Allotment {
    private String courseRegistrationId;

    private String emailId;
    private String courseOfferingId;
    private String courseName;
    private String instructor;
    private Date allotmentDate;

    public Allotment(String courseRegistrationId, String emailId, String courseOfferingId, String courseName, String instructor, Date allotmentDate) {
        this.courseRegistrationId = courseRegistrationId;
        this.emailId = emailId;
        this.courseOfferingId = courseOfferingId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.allotmentDate = allotmentDate;
    }

    public String getCourseRegistrationId() {
        return courseRegistrationId;
    }

    public void setCourseRegistrationId(String courseRegistrationId) {
        this.courseRegistrationId = courseRegistrationId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCourseOfferingId() {
        return courseOfferingId;
    }

    public void setCourseOfferingId(String courseOfferingId) {
        this.courseOfferingId = courseOfferingId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Date getAllotmentDate() {
        return allotmentDate;
    }

    public void setAllotmentDate(Date allotmentDate) {
        this.allotmentDate = allotmentDate;
    }

    @Override
    public String toString() {
        return "Allotment{" +
                "courseRegistrationId='" + courseRegistrationId + '\'' +
                ", emailId='" + emailId + '\'' +
                ", courseOfferingId='" + courseOfferingId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", instructor='" + instructor + '\'' +
                ", allotmentDate=" + allotmentDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allotment allotment = (Allotment) o;
        return Objects.equals(courseRegistrationId, allotment.courseRegistrationId) && Objects.equals(emailId, allotment.emailId) && Objects.equals(courseOfferingId, allotment.courseOfferingId) && Objects.equals(courseName, allotment.courseName) && Objects.equals(instructor, allotment.instructor) && Objects.equals(allotmentDate, allotment.allotmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseRegistrationId, emailId, courseOfferingId, courseName, instructor, allotmentDate);
    }
}