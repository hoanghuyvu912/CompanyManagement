package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class CompanyManagementException {
    private static final String DEPARTMENT_NOT_FOUND_MSG_KEY = "DepartmentNotExisted";
    private static final String DEPARTMENT_NOT_FOUND_MSG = "Department Not Found";

    private static final String EMPLOYEE_NOT_FOUND_MSG_KEY = "EmployeeNotExisted";
    private static final String EMPLOYEE_NOT_FOUND_MSG = "Employee Not Found";

    private static final String LOCATION_NOT_FOUND_MSG_KEY = "LocationNotExisted";
    private static final String LOCATION_NOT_FOUND_MSG = "Location Not Found";

    private static final String PROJECT_NOT_FOUND_MSG_KEY = "ProjectNotExisted";
    private static final String PROJECT_NOT_FOUND_MSG = "Project Not Found";

    private static final String RELATIVES_NOT_FOUND_MSG_KEY = "RelativesNotExisted";
    private static final String RELATIVES_NOT_FOUND_MSG = "Relatives Not Found";

    private static final String ASSIGNMENT_NOT_FOUND_MSG_KEY = "AssignmentNotExisted";
    private static final String ASSIGNMENT_NOT_FOUND_MSG = "Assignment Not Found";

    public static ResponseException notFound(String msgKey, String msg) {
        return new ResponseException(msgKey, msg, HttpStatus.NOT_FOUND);
    }

    public static ResponseException badRequest(String msgKey, String msg) {
        return new ResponseException(msgKey, msg, HttpStatus.BAD_REQUEST);
    }

    public static ResponseException internalServerError(String msgKey, String msg) {
        return new ResponseException(msgKey, msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseException DepartmentNotFound() {
        return notFound(DEPARTMENT_NOT_FOUND_MSG_KEY, DEPARTMENT_NOT_FOUND_MSG);
    }

    public static ResponseException EmployeeNotFound() {
        return notFound(EMPLOYEE_NOT_FOUND_MSG_KEY, EMPLOYEE_NOT_FOUND_MSG);
    }

    public static ResponseException LocationNotFound() {
        return notFound(LOCATION_NOT_FOUND_MSG_KEY, LOCATION_NOT_FOUND_MSG);
    }

    public static ResponseException ProjectNotFound() {
        return notFound(PROJECT_NOT_FOUND_MSG_KEY, PROJECT_NOT_FOUND_MSG);
    }

    public static ResponseException RelativesNotFound() {
        return notFound(RELATIVES_NOT_FOUND_MSG_KEY, RELATIVES_NOT_FOUND_MSG);
    }

    public static ResponseException AssignmentNotFound() {
        return notFound(ASSIGNMENT_NOT_FOUND_MSG_KEY, ASSIGNMENT_NOT_FOUND_MSG);
    }
}
