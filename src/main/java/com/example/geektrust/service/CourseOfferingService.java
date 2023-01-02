package com.example.geektrust.service;

import com.example.geektrust.model.CourseRegistrationDetail;

import java.util.Map;

public interface CourseOfferingService extends BaseService {

    CourseRegistrationDetail addCourseOffering(Map<String, String> courseInput);
}
