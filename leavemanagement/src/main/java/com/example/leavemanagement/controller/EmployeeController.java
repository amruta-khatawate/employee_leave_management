package com.example.leavemanagement.controller;
import org.springframework.web.bind.annotation.*;
import com.example.leavemanagement.service.EmployeeService;
import com.example.leavemanagement.dto.EmployeeDto;
import org.springframework.http.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController{

      private EmployeeService employeeService;

      public EmployeeController(EmployeeService employeeService){
            this.employeeService = employeeService;
      }

      @PostMapping
      public ResponseEntity<EmployeeDto> createemp(EmployeeDto employeeDto){
            System.out.println(employeeDto);
           return new ResponseEntity(employeeService.createEmp(employeeDto), HttpStatus.CREATED);
      }
      
}