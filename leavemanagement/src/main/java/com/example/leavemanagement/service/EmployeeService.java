package com.example.leavemanagement.service;
import com.example.leavemanagement.dto.EmployeeDto;
import java.util.*;

public interface EmployeeService{

      EmployeeDto createEmp(EmployeeDto employeeDto);

      List<EmployeeDto> getAllEmps();

      EmployeeDto getEmpById(Long id);

      EmployeeDto updateEmpById(Long id, EmployeeDto employeeDto);

      void deleteEmpById(Long id);
}