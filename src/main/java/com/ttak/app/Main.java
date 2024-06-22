package com.ttak.app;

import com.ttak.app.employee.EmployeeProcessor;
import com.ttak.app.employee.JsonUtils;
import com.ttak.app.model.Employee;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        JsonUtils jsonUtils = new JsonUtils();
        EmployeeProcessor employeeProcessor = new EmployeeProcessor(jsonUtils);

        try {
            List<Employee> employeesAbove40 = employeeProcessor.getEmployeesAgeAbove40();
            employeesAbove40.forEach(employee -> System.out.println(employee.getBirthday()));
        } catch (IOException | ParseException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while processing employees", e);
        }
    }
}
