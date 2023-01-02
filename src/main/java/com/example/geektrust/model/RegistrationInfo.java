package com.example.geektrust.model;

import java.util.Objects;

public class RegistrationInfo {

    private String email;
    private String employeeName;
    private String courseName;
    private String courseRegistrationId;
    private CourseStatus courseRegistrationStatus;

    public RegistrationInfo() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseRegistrationId() {
        return courseRegistrationId;
    }

    public void setCourseRegistrationId(String courseRegistrationId) {
        this.courseRegistrationId = courseRegistrationId;
    }

    public CourseStatus getCourseRegistrationStatus() {
        return courseRegistrationStatus;
    }

    public void setCourseRegistrationStatus(CourseStatus courseRegistrationStatus) {
        this.courseRegistrationStatus = courseRegistrationStatus;
    }

    @Override
    public String toString() {
        return "RegistrationResponse{" +
                "email='" + email + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseRegistrationId='" + courseRegistrationId + '\'' +
                ", courseRegistrationStatus=" + courseRegistrationStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationInfo that = (RegistrationInfo) o;
        return Objects.equals(email, that.email) && Objects.equals(employeeName, that.employeeName) && Objects.equals(courseName, that.courseName) && Objects.equals(courseRegistrationId, that.courseRegistrationId) && courseRegistrationStatus == that.courseRegistrationStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, employeeName, courseName, courseRegistrationId, courseRegistrationStatus);
    }
}
