package com.peter.management.service;

import com.peter.management.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto EmployeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

   List<EmployeeDto> getAllEmployee();
}
