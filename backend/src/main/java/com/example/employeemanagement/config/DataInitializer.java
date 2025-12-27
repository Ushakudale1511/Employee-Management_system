package com.example.employeemanagement.config;

import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.DepartmentRepository;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class initializes fake data for the application when it starts.
 */
@Configuration
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private final Faker faker = new Faker();
    private final Random random = new Random();

    @Override
    public void run(String... args) {

        // ✅ SAFETY CHECK: Data already exists then skip
        if (departmentRepository.count() > 0) {
            System.out.println("Data already exists. Skipping fake data initialization.");
            return;
        }

        // -------------------------------
        // Create fake departments
        // -------------------------------
        List<Department> departments = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            Department department = new Department();
            department.setName(faker.company().industry());
            departments.add(department);
        }

        departmentRepository.saveAll(departments);

        // -------------------------------
        // Create fake employees
        // -------------------------------
        List<Employee> employees = new ArrayList<>();

        for (int i = 1; i <= 295; i++) {
            Employee employee = new Employee();
            employee.setFirstName(faker.name().firstName());
            employee.setLastName(faker.name().lastName());
            employee.setEmail(faker.internet().emailAddress());
            employee.setAge(random.nextInt(40) + 20); // age between 20 and 60

            // Assign random department
            employee.setDepartment(
                departments.get(random.nextInt(departments.size()))
            );

            employees.add(employee);
        }

        employeeRepository.saveAll(employees);

        System.out.println("Fake data initialized successfully!");
    }
}
