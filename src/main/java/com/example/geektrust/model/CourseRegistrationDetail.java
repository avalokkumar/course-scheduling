package com.example.geektrust.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CourseRegistrationDetail {

    private String courseOfferingId;
    private String title;
    private String instructor;
    private Date date;
    private Long minEmployee;
    private Long maxEmployee;

    private String status;

    private boolean isAlloted = false;

    List<RegistrationInfo> registrationInfo;

    public CourseRegistrationDetail() {
    }

    public String getCourseOfferingId() {
        return courseOfferingId;
    }

    public void setCourseOfferingId(String courseOfferingId) {
        this.courseOfferingId = courseOfferingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getMinEmployee() {
        return minEmployee;
    }

    public void setMinEmployee(Long minEmployee) {
        this.minEmployee = minEmployee;
    }

    public Long getMaxEmployee() {
        return maxEmployee;
    }

    public void setMaxEmployee(Long maxEmployee) {
        this.maxEmployee = maxEmployee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAlloted() {
        return isAlloted;
    }

    public void setAlloted(boolean alloted) {
        isAlloted = alloted;
    }

    public List<RegistrationInfo> getRegistrationInfo() {
        return registrationInfo;
    }

    public void setRegistrationInfo(List<RegistrationInfo> registrationInfo) {
        this.registrationInfo = registrationInfo;
    }

    @Override
    public String toString() {
        return "CourseRegistrationDetail{" +
                "courseOfferingId='" + courseOfferingId + '\'' +
                ", title='" + title + '\'' +
                ", instructor='" + instructor + '\'' +
                ", date=" + date +
                ", minEmployee=" + minEmployee +
                ", maxEmployee=" + maxEmployee +
                ", status='" + status + '\'' +
                ", isAlloted=" + isAlloted +
                ", registrationInfo=" + registrationInfo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseRegistrationDetail that = (CourseRegistrationDetail) o;
        return isAlloted == that.isAlloted && Objects.equals(courseOfferingId, that.courseOfferingId) && Objects.equals(title, that.title) && Objects.equals(instructor, that.instructor) && Objects.equals(date, that.date) && Objects.equals(minEmployee, that.minEmployee) && Objects.equals(maxEmployee, that.maxEmployee) && Objects.equals(status, that.status) && Objects.equals(registrationInfo, that.registrationInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseOfferingId, title, instructor, date, minEmployee, maxEmployee, status, isAlloted, registrationInfo);
    }
}
