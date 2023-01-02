package com.example.geektrust.service;

import com.example.geektrust.model.CourseRegistrationDetail;

public interface CourseAllotmentService extends BaseService{

    boolean allotCourse(CourseRegistrationDetail courseRegistrationDetail);
}
