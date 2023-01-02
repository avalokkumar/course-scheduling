package com.example.geektrust.service.impl;

import com.example.geektrust.service.RegistrationCancellationService;

import java.util.Map;

import static com.example.geektrust.util.Constants.*;

public class RegistrationCancellationServiceImpl implements RegistrationCancellationService {

    @Override
    public boolean validateInput(String[] request) {
        return request.length == 2;
    }

    @Override
    public Map<String, String> extract(String[] request) {
        return Map.of(COURSE_REGISTRATION_ID, request[1]);
    }
}
