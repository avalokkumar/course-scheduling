package com.example.geektrust.service;

import com.example.geektrust.model.CourseRegistrationDetail;
import com.example.geektrust.model.RegistrationInfo;

import java.util.Map;

public interface CourseRegistrationService extends BaseService {

    RegistrationInfo register(Map<String, String> registrationInput, CourseRegistrationDetail courseRegistrationMapping);
}
