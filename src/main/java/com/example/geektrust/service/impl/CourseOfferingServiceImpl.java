package com.example.geektrust.service.impl;

import com.example.geektrust.model.CourseOfferingResponse;
import com.example.geektrust.model.CourseRegistrationDetail;
import com.example.geektrust.service.CourseOfferingService;
import com.example.geektrust.util.Constants;
import com.example.geektrust.util.CustomDateFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.geektrust.util.Constants.*;

public class CourseOfferingServiceImpl implements CourseOfferingService {

    @Override
    public boolean validateInput(String[] request) {
        return request.length == 6;
    }

    @Override
    public Map<String, String> extract(String[] request) {
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put(TITLE, request[1]);
        requestMap.put(INSTRUCTOR, request[2]);
        requestMap.put(DATE, request[3]);
        requestMap.put(MIN_EMPLOYEE, request[4]);
        requestMap.put(MAX_EMPLOYEE, request[5]);
        return requestMap;
    }

    @Override
    public CourseRegistrationDetail addCourseOffering(Map<String, String> courseInput) {
        String offeringId = Constants.OFFERING + "-" + courseInput.get(TITLE) + "-" + courseInput.get(INSTRUCTOR);
        return buildCourseRegistrationDetail(offeringId, courseInput);
    }

    private CourseRegistrationDetail buildCourseRegistrationDetail(String offeringId, Map<String, String> courseInput) {
        CourseRegistrationDetail courseRegistrationDetail = new CourseRegistrationDetail();
        courseRegistrationDetail.setCourseOfferingId(offeringId);
        courseRegistrationDetail.setTitle(courseInput.get(TITLE));
        courseRegistrationDetail.setInstructor(courseInput.get(INSTRUCTOR));
        courseRegistrationDetail.setDate(CustomDateFormatter.formatInputToDdMmYyyy(courseInput.get(DATE)));
        courseRegistrationDetail.setMaxEmployee(Long.parseLong(courseInput.get(MAX_EMPLOYEE)));
        courseRegistrationDetail.setMinEmployee(Long.parseLong(courseInput.get(MIN_EMPLOYEE)));
        courseRegistrationDetail.setRegistrationInfo(new ArrayList<>());
        return courseRegistrationDetail;
    }
}
