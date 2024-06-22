# Employee Age Filter Application

This Java-based application processes employee data to filter and identify employees who are above 40 years old using JSON input. The application leverages JSON utilities for data handling and includes unit tests to ensure robust functionality.

## Project Structure

### Main Classes

1. **EmployeeProcessor**
    - **Purpose**: Processes employee data by filtering employees who are above 40 years old.
    - **Key Methods**:
        - `getEmployeesAgeAbove40()`: Fetches and filters employees based on age.
        - `filterEmployeesByAge()`: Filters employees based on a reference date.
        - `isBirthdayBeforeReferenceDate()`: Checks if an employee's birthday is before a reference date.

2. **JsonUtils**
    - **Purpose**: Handles JSON operations, including reading JSON content from a file and parsing it into Java objects.
    - **Key Methods**:
        - `readJsonFromFile(String fileName)`: Reads JSON content from a specified file.
        - `parseEmployeesFromJson(String jsonString)`: Parses JSON content into an `Employees` object.

3. **Main**
    - **Purpose**: Entry point of the application. Initializes the `EmployeeProcessor` and processes the employee data.
    - **Key Functionality**:
        - Initializes `JsonUtils` and `EmployeeProcessor`.
        - Processes and prints the birthdays of employees who are above 40 years old.

### Model Classes

4. **Employee**
    - **Purpose**: Represents an employee with properties such as `firstName` and `birthday`.
    - **Key Properties**:
        - `firstName`: The first name of the employee.
        - `birthday`: The birthday of the employee.

5. **Employees**
    - **Purpose**: Represents a collection of `Employee` objects.
    - **Key Properties**:
        - `employees`: A list of `Employee` objects.

### Test Classes

6. **EmployeeProcessorTest**
    - **Purpose**: Tests the functionality of the `EmployeeProcessor` class using JUnit and Mockito.
    - **Key Tests**:
        - `testGetEmployeesAgeAbove40()`: Verifies that the filtering logic correctly identifies employees above 40 years old.
        - Utilizes mocked `JsonUtils` for isolated testing.

## Getting Started

### Prerequisites
- Java 8 or higher
- Maven for dependency management

### Installation

1. **Clone the repository**:
    ```sh
    git clone https://github.com/your-username/employee-age-filter.git
    cd employee-age-filter
    ```

2. **Build the project**:
    ```sh
    mvn clean install

### Running the Application

1. **Run the main class**:
    ```sh
    java -cp target/employee-age-filter-1.0-SNAPSHOT.jar com.ttak.app.Main
    ```

### Running Tests

1. **Execute unit tests**:
    ```sh
    mvn test

