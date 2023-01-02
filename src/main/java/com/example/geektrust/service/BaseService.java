package com.example.geektrust.service;

import java.util.Map;

public interface BaseService {

    boolean validateInput(String[] request);
    Map<String, String> extract(String[] request);
}
