package com.peter.management.controller;

import com.peter.management.dto.EmployeeDto;
import com.peter.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // building Add rest API
    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> creatEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }
    // Build the Get Employee Api
    @GetMapping("getEmployeeById/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
    // Build get AllEmployees Api
    @GetMapping("getAllEmployee")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
        List<EmployeeDto> employeeDto = employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeDto);
    }
    // Build Update employee rest Api
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto updateEmployee){
            EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updateEmployee);
        return ResponseEntity.ok(employeeDto);
    }
    // Delete Employee rest Api
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
         employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully");
    }
}
