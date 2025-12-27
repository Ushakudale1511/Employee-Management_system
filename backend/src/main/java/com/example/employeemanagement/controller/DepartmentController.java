package com.example.employeemanagement.controller;

import com.example.employeemanagement.exception.ResourceNotFoundException;
import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "*")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * Get all departments
     */
    @Operation(summary = "Get all departments")
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    /**
     * Get department by ID
     */
    @Operation(summary = "Get department by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Department found"),
        @ApiResponse(responseCode = "404", description = "Department not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(
            @Parameter(description = "ID of the department") @PathVariable Long id) {

        Department department = departmentService
                .getDepartmentById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department not found with id : " + id));

        return ResponseEntity.ok(department);
    }

    /**
     * Create a new department
     */
    @Operation(summary = "Create a new department")
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    /**
     * Update an existing department
     */
    @Operation(summary = "Update a department")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Department updated"),
        @ApiResponse(responseCode = "404", description = "Department not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(
            @Parameter(description = "ID of the department to be updated")
            @PathVariable Long id,
            @RequestBody Department departmentDetails) {

        Department department = departmentService
                .getDepartmentById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department not found with id : " + id));

        department.setName(departmentDetails.getName());

        Department updatedDepartment =
                departmentService.saveDepartment(department);

        return ResponseEntity.ok(updatedDepartment);
    }

    /**
     * Delete a department
     */
    @Operation(summary = "Delete a department")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Department deleted"),
        @ApiResponse(responseCode = "404", description = "Department not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(
            @Parameter(description = "ID of the department to be deleted")
            @PathVariable Long id) {

        Department department = departmentService
                .getDepartmentById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department not found with id : " + id));

        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
