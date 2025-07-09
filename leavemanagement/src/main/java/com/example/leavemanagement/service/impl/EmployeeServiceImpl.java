package com.example.leavemanagement.service.impl;
import com.example.leavemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import com.example.leavemanagement.dto.EmployeeDto;
import com.example.leavemanagement.service.EmployeeService;
import com.example.leavemanagement.model.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService{

      private EmployeeRepository employeeRepository;

      public EmployeeServiceImpl(EmployeeRepository employeeRepository){
            this.employeeRepository = employeeRepository;
      }

      @Override
      public EmployeeDto createEmp(EmployeeDto employeeDto){

            // converting dto to entity 
            Employee employee = new Employee();
            employee.setId(employeeDto.getId());
            employee.setName(employeeDto.getName());
            employee.setEmail(employeeDto.getEmail());
            employee.setRole(employeeDto.getRole());
            // System.out.println("Saving employee with ID: " + employee.getId());

            Employee newemp = employeeRepository.save(employee);

            // converting entity to dto 

            EmployeeDto response = new EmployeeDto();
            response.setId(newemp.getId());
            response.setName(newemp.getName());
            response.setEmail(newemp.getEmail());
            response.setRole(newemp.getRole());

            return response;
      }
}