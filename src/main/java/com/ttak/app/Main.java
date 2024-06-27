package com.ttak.app;

import com.ttak.app.employee.EmployeeProcessor;
import com.ttak.app.employee.JsonUtils;
import com.ttak.app.model.Color;
import com.ttak.app.model.Employee;

import java.io.IOException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public static void main(String[] args) {
        JsonUtils jsonUtils = new JsonUtils();
        EmployeeProcessor employeeProcessor = new EmployeeProcessor(jsonUtils);

        try {
            List<Employee> employeesAbove40 = employeeProcessor.getEmployeesAgeAbove40();
            employeesAbove40.forEach(Main::logEmployeeDetails);
        } catch (IOException | ParseException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while processing employees", e);
        }
    }

    private static void logEmployeeDetails(Employee employee) {
        if (employee == null) {
            LOGGER.warning("Attempted to log details of a null employee.");
            return;
        }

        StringBuilder logMessage = new StringBuilder("Employee Details: ");
        logMessage.append("First Name: ").append(employee.getFirstName()).append(", ");
        logMessage.append("Last Name: ").append(employee.getLastName()).append(", ");

        String birthdayStr = (employee.getBirthday() != null) ? employee.getBirthday().format(DATE_FORMATTER) : "N/A";
        logMessage.append("Birthday: ").append(birthdayStr).append(", ");

        List<Color> favoriteColors = employee.getFavoriteColors();
        if (favoriteColors != null && !favoriteColors.isEmpty()) {
            String colorsStr = favoriteColors.stream()
                    .map(Color::getValue)
                    .collect(Collectors.joining(", "));
            logMessage.append("Favorite Colors: ").append(colorsStr);
        } else {
            logMessage.append("Favorite Colors: None");
        }
        LOGGER.info(logMessage.toString());
    }
}
