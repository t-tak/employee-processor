package com.ttak.app.employee.test;

import com.ttak.app.employee.EmployeeProcessor;
import com.ttak.app.employee.JsonUtils;
import com.ttak.app.model.Employee;
import com.ttak.app.model.Employees;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeProcessorTest {

    private EmployeeProcessor employeeProcessor;
    private JsonUtils jsonUtils;

    /**
     * Set up the test environment before each test.
     * Initialize the JsonUtils mock and the EmployeeProcessor with the mocked JsonUtils.
     */
    @BeforeEach
    void setUp() {
        jsonUtils = mock(JsonUtils.class); // Create a mock instance of JsonUtils
        employeeProcessor = new EmployeeProcessor(jsonUtils); // Inject the mock into EmployeeProcessor
    }

    /**
     * Test the getEmployeesAgeAbove40 method to ensure it correctly filters employees above 40 years old.
     *
     * @throws IOException if there's an error reading the file
     * @throws ParseException if there's an error parsing dates
     */
    @Test
    void testGetEmployeesAgeAbove40() throws IOException, ParseException {
        // Define a JSON string that represents two employees
        String jsonString = "{\"employees\":[{\"name\":\"Markus\",\"birthday\":\"1970-01-01\"},{\"name\":\"Steve\",\"birthday\":\"1990-01-01\"}]}";

        // Mock the behavior of readJsonFromFile to return the jsonString
        when(jsonUtils.readJsonFromFile("employeeList.json")).thenReturn(jsonString);

        // Create Employee objects based on the JSON string
        Employees employees = new Employees();
        Employee employee1 = new Employee();
        employee1.setFirstName("Markus");
        employee1.setBirthday(EmployeeProcessorTest.createDate("1970-01-01")); // Method to create Date object from string

        Employee employee2 = new Employee();
        employee2.setFirstName("Steve");
        employee2.setBirthday(EmployeeProcessorTest.createDate("1990-01-01")); // Method to create Date object from string

        // Add employees to the Employees object
        employees.setEmployees(Arrays.asList(employee1, employee2));

        // Mock the behavior of parseEmployeesFromJson to return the Employees object
        when(jsonUtils.parseEmployeesFromJson(jsonString)).thenReturn(employees);

        // Call the method to test
        List<Employee> employeesAbove40 = employeeProcessor.getEmployeesAgeAbove40();

        // Verify the result
        assertEquals(1, employeesAbove40.size()); // Expecting only one employee above 40 years old
        assertEquals("Markus", employeesAbove40.get(0).getFirstName()); // The employee above 40 should be Markus
    }

    /**
     * Helper method to create a Date object from a string.
     *
     * @param dateString the date in string format
     * @return the Date object
     */
    private static LocalDate createDate(String dateString)  {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return  LocalDate.parse(dateString, formatter);
    }
}
