package com.example.geektrust.service.impl;

import com.example.geektrust.model.CourseRegistrationDetail;
import com.example.geektrust.service.CourseAllotmentService;

import java.util.Map;

import static com.example.geektrust.util.Constants.COURSE_OFFERING_ID;

public class CourseAllotmentServiceImpl implements CourseAllotmentService {

    @Override
    public Map<String, String> extract(String[] request) {
        return Map.of(COURSE_OFFERING_ID, request[1]);
    }

    @Override
    public boolean validateInput(String[] request) {
        return request.length==2;
    }

    @Override
    public boolean allotCourse(CourseRegistrationDetail courseRegistrationDetail) {
        //TODO: print all values sorted by course-registration-id in ascending order
        return true;
    }
}
