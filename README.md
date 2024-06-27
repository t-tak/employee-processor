
```markdown
# Employee Processing Application

This application demonstrates how to parse JSON data, retrieve employee details, filter employees above 40 years old, and log their details. It uses Java, Jackson for JSON parsing, and Java's built-in logging.

## Table of Contents
- [Setup](#setup)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Dependencies](#dependencies)
- [Classes and Methods](#classes-and-methods)
- [Unit Testing](#unit-testing)

## Setup

### Prerequisites
- Java 8 or higher
- Maven

### Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/employee-processing-app.git
    cd employee-processing-app
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

## Usage

1. Run the application:
    ```bash
    mvn exec:java -Dexec.mainClass="com.ttak.app.Main"
    ```

2. The application will parse the JSON data from `employeeList.json`, filter employees who are above 40 years old, and log their details.

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── ttak/
│   │           ├── app/
│   │           │   ├── Main.java
│   │           │   ├── employee/
│   │           │   │   ├── EmployeeProcessor.java
│   │           │   │   └── JsonUtils.java
│   │           │   └── model/
│   │           │       ├── Employee.java
│   │           │       ├── Employees.java
│   │           │       └── Color.java
│   └── resources/
│       └── employeeList.json
└── test/
    └── java/
        └── com/
            └── ttak/
                └── app/
                    └── employee/
                        └── EmployeeProcessorTest.java
```

## Dependencies

The project uses the following dependencies:
- `com.fasterxml.jackson.core:jackson-databind:2.14.0` - for JSON parsing
- `com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.0` - to support Java 8 Date and Time API types
- `org.mockito:mockito-core:4.6.0` - for unit testing

Add these dependencies in your `pom.xml` file.

## Classes and Methods

### Main.java
- Entry point of the application.
- Initializes `JsonUtils` and `EmployeeProcessor`.
- Processes and logs details of employees above 40 years old.

### EmployeeProcessor.java
- Contains methods to filter employees by age.
- Uses `JsonUtils` to parse JSON data.

### JsonUtils.java
- Handles JSON reading and parsing.
- Registers `JavaTimeModule` to handle Java 8 Date and Time API types.

### Employee.java
- Model class representing an employee.

### Employees.java
- Wrapper class for a list of `Employee` objects.

### Color.java
- Enum representing favorite colors.

## Unit Testing

### EmployeeProcessorTest.java
- Contains unit tests for `EmployeeProcessor`.

To run the tests, use:
```bash
mvn test
```

## Example Usage

### Employee JSON (employeeList.json)
```json
[
    {
        "firstName": "Kiv",
        "lastName": "Dan",
        "birthday": "1980-06-15",
        "favoriteColors":[{"value":"Goldenrod"},{"value":"Aquamarine"}]
    },
    {
        "firstName": "Julian",
        "lastName": "Assan",
        "birthday": "1990-01-01",
        "favoriteColors":[{"value":"Blue"},{"value":"Mauv"}]
    }
]
```

### Log Output
```
INFO: Employee Details: First Name: Kiv, Last Name: Dan, Birthday: 1980-06-15, Favorite Colors: Goldenrod, Aquamarine
INFO: Employee Details: First Name: Julian, Last Name: Assan, Birthday: 1990-01-01, Favorite Colors: Blue, Mauv
```

