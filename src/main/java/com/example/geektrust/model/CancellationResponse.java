package com.example.geektrust.model;

import java.util.Objects;

public class CancellationResponse {

    private String courseRegistrationId;

    public String getCourseRegistrationId() {
        return courseRegistrationId;
    }

    public void setCourseRegistrationId(String courseRegistrationId) {
        this.courseRegistrationId = courseRegistrationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CancellationResponse that = (CancellationResponse) o;
        return Objects.equals(courseRegistrationId, that.courseRegistrationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseRegistrationId);
    }
}
