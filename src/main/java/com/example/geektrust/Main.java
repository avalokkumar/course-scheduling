package com.example.geektrust;

import com.example.geektrust.model.*;
import com.example.geektrust.service.*;
import com.example.geektrust.service.impl.CourseAllotmentServiceImpl;
import com.example.geektrust.service.impl.CourseOfferingServiceImpl;
import com.example.geektrust.service.impl.CourseRegistrationServiceImpl;
import com.example.geektrust.service.impl.RegistrationCancellationServiceImpl;
import com.example.geektrust.util.Command;
import com.example.geektrust.util.ErrorCodes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static com.example.geektrust.util.Constants.*;

public class Main {
    static Map<Command, BaseService> serviceMapping;

    public static void main(String[] args) {

        serviceMapping = new EnumMap<>(Command.class);
        serviceMapping.put(Command.ADD_COURSE_OFFERING, new CourseOfferingServiceImpl());
        serviceMapping.put(Command.REGISTER, new CourseRegistrationServiceImpl());
        serviceMapping.put(Command.ALLOT, new CourseAllotmentServiceImpl());
        serviceMapping.put(Command.CANCEL, new RegistrationCancellationServiceImpl());

        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            /**
             * Add course offering
             *  A course offering has course title, instructor and date.
             *  It should also contain a minimum & maximum number of employees for the course offering.
             *
             *  ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2 --------- OFFERING-JAVA-JAMES
             */

            Map<String, CourseRegistrationDetail> courseRegistrationMapping = new HashMap<>();
            Map<String, String> registrationOfferingMapping = new HashMap<>();

            while (sc.hasNextLine()) {
                String[] inputCommand = sc.nextLine().split(" ");
                if (!Command.isValidCommand(inputCommand[0])) {
                    System.out.println(ErrorCodes.INPUT_DATA_ERROR);
                }
                Command command = Command.getCommand(inputCommand[0]);
                switch (command) {
                    case ADD_COURSE_OFFERING:
                        CourseOfferingService courseOfferingService = (CourseOfferingService) serviceMapping.get(command);
                        if (!courseOfferingService.validateInput(inputCommand)) {
                            System.out.println(ErrorCodes.INPUT_DATA_ERROR);
                            break;
                        }
                        Map<String, String> courseOfferingInput = courseOfferingService.extract(inputCommand);
                        CourseRegistrationDetail courseRegistrationDetail = courseOfferingService.addCourseOffering(courseOfferingInput);
                        courseRegistrationMapping.put(courseRegistrationDetail.getCourseOfferingId(), courseRegistrationDetail);
                        System.out.println(courseRegistrationDetail.getCourseOfferingId());
                        break;

                    case REGISTER:
                        CourseRegistrationService courseRegistrationService = (CourseRegistrationService) serviceMapping.get(command);
                        if (!courseRegistrationService.validateInput(inputCommand)) {
                            System.out.println(ErrorCodes.INPUT_DATA_ERROR);
                            break;
                        }
                        Map<String, String> registrationInput = courseRegistrationService.extract(inputCommand);
                        String courseOfferingId = registrationInput.get(COURSE_OFFERING_ID);

                        CourseRegistrationDetail registrationDetail = courseRegistrationMapping.get(courseOfferingId);

                        RegistrationInfo registrationInfo = courseRegistrationService.register(registrationInput, registrationDetail);

                        if (CourseStatus.ACCEPTED.equals(registrationInfo.getCourseRegistrationStatus())) {
                            registrationDetail.getRegistrationInfo().add(registrationInfo);
                        }
                        registrationDetail.setStatus(registrationDetail.getRegistrationInfo().size() >= registrationDetail.getMinEmployee()? CONFIRMED: UNCONFIRMED);
                        courseRegistrationMapping.put(courseOfferingId, registrationDetail);
                        if (registrationDetail.getRegistrationInfo().stream().allMatch(regInfo -> regInfo.getCourseRegistrationStatus().equals(CourseStatus.ACCEPTED))) {
                            registrationOfferingMapping.put(registrationInfo.getCourseRegistrationId(), courseOfferingId);
                        }
                        break;
                    case ALLOT:
                        CourseAllotmentService courseAllotmentService = (CourseAllotmentService) serviceMapping.get(command);
                        if (!courseAllotmentService.validateInput(inputCommand)) {
                            System.out.println(ErrorCodes.INPUT_DATA_ERROR);
                            break;
                        }
                        Map<String, String> allotmentInput = courseAllotmentService.extract(inputCommand);
                        String offeringId = allotmentInput.get(COURSE_OFFERING_ID);
                        CourseRegistrationDetail courseRegDetail = courseRegistrationMapping.get(offeringId);
                        boolean isAlloted = courseAllotmentService.allotCourse(courseRegDetail);
                        courseRegDetail.setAlloted(isAlloted);
                        courseRegistrationMapping.put(offeringId, courseRegDetail);
                        break;
                    case CANCEL:
                        RegistrationCancellationService registrationCancellationService = (RegistrationCancellationService) serviceMapping.get(command);
                        if (!registrationCancellationService.validateInput(inputCommand)) {
                            System.out.println(ErrorCodes.INPUT_DATA_ERROR);
                            break;
                        }
                        Map<String, String> cancellationInput = registrationCancellationService.extract(inputCommand);
                        String courseRegistrationId = cancellationInput.get(COURSE_REGISTRATION_ID);
                        String cOfferingId = registrationOfferingMapping.get(courseRegistrationId);
                        CourseRegistrationDetail courseRegistrationDetail1 = courseRegistrationMapping.get(cOfferingId);
                        if (courseRegistrationDetail1.isAlloted()){
                            System.out.println(cancellationInput.get(COURSE_REGISTRATION_ID +" " + CancellationStatus.CANCEL_REJECTED.name()));
                        } else {
                            System.out.println(cancellationInput.get(COURSE_REGISTRATION_ID) +" " + CancellationStatus.CANCEL_ACCEPTED.name());
                            registrationOfferingMapping.remove(courseRegistrationId);
                        }
                    case VIEW:
                        System.out.println("=================Course Offering Details=================\n");
                        for (Map.Entry<String, CourseRegistrationDetail> entry :courseRegistrationMapping.entrySet()) {
                            System.out.println(entry.getKey() +" - "+ entry.getValue());
                            System.out.println();
                        }
                        System.out.println("\n\n=================Course Registration Details=================\n");
                        for (Map.Entry<String, String> registrationResponse: registrationOfferingMapping.entrySet()) {
                            System.out.println(registrationResponse.getKey() + " : "+ registrationResponse.getValue());
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid Command");
                }

            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println("INPUT_DATA_ERROR");
        }
    }
}
