package com.example.geektrust.service.impl;

import com.example.geektrust.model.CourseRegistrationDetail;
import com.example.geektrust.model.CourseStatus;
import com.example.geektrust.model.RegistrationInfo;
import com.example.geektrust.service.CourseRegistrationService;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

import static com.example.geektrust.util.Constants.*;


public class CourseRegistrationServiceImpl implements CourseRegistrationService {

    @Override
    public boolean validateInput(String[] request) {
        return request.length == 3;
    }

    @Override
    public Map<String, String> extract(String[] request) {
        return Map.of(EMAIL, request[1], COURSE_OFFERING_ID, request[2]);
    }

    @Override
    public RegistrationInfo register(Map<String, String> registrationInput, CourseRegistrationDetail courseRegistrationDetail) {
        CourseStatus courseStatus = validateRegistration(registrationInput, courseRegistrationDetail);
        RegistrationInfo registrationInfo = buildRegistrationInfo(registrationInput, courseRegistrationDetail);
        registrationInfo.setCourseRegistrationStatus(courseStatus);
        if (courseStatus.equals(CourseStatus.ACCEPTED)) {
            registrationInfo.setCourseRegistrationId(REGISTRATION_PREFIX + "-" + registrationInfo.getEmployeeName() + "-" + registrationInfo.getCourseName());
            System.out.println(registrationInfo.getCourseRegistrationId() + " "+ ACCEPTED);
        } else {
            System.out.println(courseStatus);
        }
        return registrationInfo;
    }

    private RegistrationInfo buildRegistrationInfo(Map<String, String> registrationInput, CourseRegistrationDetail courseRegistrationDetail) {
        RegistrationInfo registrationInfo = new RegistrationInfo();
        registrationInfo.setCourseName(courseRegistrationDetail.getTitle());
        registrationInfo.setEmail(registrationInput.get(EMAIL));
        registrationInfo.setEmployeeName(getEmployeeName(registrationInput.get(EMAIL)));
        return registrationInfo;
    }

    private static CourseStatus validateRegistration(Map<String, String> commandParams, CourseRegistrationDetail courseRegistrationDetail) {
        CourseStatus courseStatus = CourseStatus.ACCEPTED;
        int totalRegistration = courseRegistrationDetail.getRegistrationInfo().size();
        if (totalRegistration  == courseRegistrationDetail.getMaxEmployee()) {
            courseStatus = CourseStatus.COURSE_FULL_ERROR;
        }
        Date courseLastRegDate = courseRegistrationDetail.getDate();
        if (courseLastRegDate!= null && courseLastRegDate.before(Date.from(Instant.now()))) {
            courseStatus = CourseStatus.COURSE_CANCELLED;
        }

        return courseStatus;
    }

    private String getEmployeeName(String email) {
        return email.substring(0, email.indexOf("@"));
    }
}
