package com.example.geektrust.model;

import java.util.Objects;

public class CourseOfferingResponse {

    private String courseOfferingId;

    public CourseOfferingResponse() {
    }

    public CourseOfferingResponse(String courseOfferingId) {
        this.courseOfferingId = courseOfferingId;
    }

    public String getCourseOfferingId() {
        return courseOfferingId;
    }

    public void setCourseOfferingId(String courseOfferingId) {
        this.courseOfferingId = courseOfferingId;
    }

    @Override
    public String toString() {
        return "CourseOfferingResponse{" +
                "courseOfferingId='" + courseOfferingId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseOfferingResponse that = (CourseOfferingResponse) o;
        return Objects.equals(courseOfferingId, that.courseOfferingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseOfferingId);
    }
}
