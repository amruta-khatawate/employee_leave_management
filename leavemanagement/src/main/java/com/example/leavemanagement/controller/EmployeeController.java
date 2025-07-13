package com.example.leavemanagement.controller;
import org.springframework.web.bind.annotation.*;
import com.example.leavemanagement.service.EmployeeService;
import com.example.leavemanagement.dto.EmployeeDto;
import org.springframework.http.*;
import java.util.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController{

      private EmployeeService employeeService;

      public EmployeeController(EmployeeService employeeService){
            this.employeeService = employeeService;
      }

      @PostMapping
      public ResponseEntity<EmployeeDto> createemp(@RequestBody EmployeeDto employeeDto){
            System.out.println(employeeDto);
           return new ResponseEntity<>(employeeService.createEmp(employeeDto), HttpStatus.CREATED);
      }

      @GetMapping("/employees")
      public ResponseEntity<List<EmployeeDto>> getAllEmps(){
            return new ResponseEntity<>(employeeService.getAllEmps(), HttpStatus.OK);
      }

      @GetMapping("/{id}")
      public ResponseEntity<EmployeeDto> getEmpById(@PathVariable Long id){
            return new ResponseEntity<>(employeeService.getEmpById(id), HttpStatus.OK);
      }

      @PutMapping("/{id}")
      public ResponseEntity<EmployeeDto> updateEmpById(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
            return new ResponseEntity<>(employeeService.updateEmpById(id,employeeDto), HttpStatus.OK);
      }

      @DeleteMapping("/{id}")
      public ResponseEntity<String> deleteEmpById(@PathVariable Long id){
            employeeService.deleteEmpById(id);
            return new ResponseEntity<>("Employee Deleted Successfully!!", HttpStatus.OK);
      }
      
}