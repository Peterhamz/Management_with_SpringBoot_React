package com.peter.management.service.impl;

import com.peter.management.dto.EmployeeDto;
import com.peter.management.entity.Employee;
import com.peter.management.mapper.EmployeeMapper;
import com.peter.management.repository.EmployeeRepository;
import com.peter.management.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
