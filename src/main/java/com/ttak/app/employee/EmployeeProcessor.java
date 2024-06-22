package com.ttak.app.employee;

import com.ttak.app.model.Employee;
import com.ttak.app.model.Employees;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeProcessor {

    private static final Logger LOGGER = Logger.getLogger(EmployeeProcessor.class.getName());

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
    private static final String REFERENCE_DATE_STRING = "1984-05-21";

    private final JsonUtils jsonUtils;

    public EmployeeProcessor(JsonUtils jsonUtils) {
        this.jsonUtils = jsonUtils;
    }

    /**
     * Fetches employees whose age is above 40.
     *
     * @return a list of employees above 40 years old
     * @throws IOException, ParseException if there is an error reading the file or parsing dates
     */
    public List<Employee> getEmployeesAgeAbove40() throws IOException, ParseException {
        String jsonString = jsonUtils.readJsonFromFile("employeeList.json");
        Employees employees = jsonUtils.parseEmployeesFromJson(jsonString);
        Date referenceDate = getReferenceDate();
        return filterEmployeesByAge(employees, referenceDate);
    }

    /**
     * Filters employees by their age based on a reference date.
     *
     * @param employees the employees object containing a list of employees
     * @param referenceDate the reference date to compare against
     * @return a list of employees filtered by age
     */
    private List<Employee> filterEmployeesByAge(Employees employees, Date referenceDate) {
        return employees.getEmployees().stream()
                .filter(employee -> isBirthdayBeforeReferenceDate(employee.getBirthday(), referenceDate))
                .collect(Collectors.toList());
    }

    /**
     * Checks if the birthday is before the reference date.
     *
     * @param birthday the employee's birthday
     * @param referenceDate the reference date
     * @return true if the birthday is before the reference date, false otherwise
     */
    private boolean isBirthdayBeforeReferenceDate(Date birthday, Date referenceDate) {
        return birthday != null && birthday.before(referenceDate);
    }

    /**
     * Gets the reference date.
     *
     * @return the reference date
     * @throws ParseException if the date cannot be parsed
     */
    private Date getReferenceDate() throws ParseException {
        try {
            return FORMATTER.parse(REFERENCE_DATE_STRING);
        } catch (ParseException e) {
            LOGGER.log(Level.SEVERE, "Error parsing reference date", e);
            throw e;
        }
    }
}
