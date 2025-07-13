package com.example.leavemanagement.service.impl;
import com.example.leavemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import com.example.leavemanagement.dto.EmployeeDto;
import com.example.leavemanagement.service.EmployeeService;
import com.example.leavemanagement.model.Employee;


import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.NoSuchElementException;


@Service
public class EmployeeServiceImpl implements EmployeeService{

      private EmployeeRepository employeeRepository;

      public EmployeeServiceImpl(EmployeeRepository employeeRepository){
            this.employeeRepository = employeeRepository;
      }

      private EmployeeDto convertToDto(Employee employee){

            EmployeeDto response = new EmployeeDto();
            response.setId(employee.getId());
            response.setName(employee.getName());
            response.setEmail(employee.getEmail());
            response.setRole(employee.getRole());

            return response;
      }

      private Employee convertToEntity(EmployeeDto employeeDto){
            
            Employee employee = new Employee();
            employee.setId(employeeDto.getId());
            employee.setName(employeeDto.getName());
            employee.setEmail(employeeDto.getEmail());
            employee.setRole(employeeDto.getRole());

            return employee;
      }


      @Override
      public EmployeeDto createEmp(EmployeeDto employeeDto){

            // converting dto to entity 
            Employee employee = convertToEntity(employeeDto);
            Employee newemp = employeeRepository.save(employee);

            // converting entity to dto 
            EmployeeDto response = convertToDto(newemp); 

            return response;
      }

      @Override
      public List<EmployeeDto> getAllEmps(){
            List<Employee> employees =  employeeRepository.findAll();
            List<EmployeeDto> employeeDtos = new ArrayList<>();

            for(Employee employee : employees){
                  EmployeeDto dto = convertToDto(employee);
                  employeeDtos.add(dto);
            }

            return employeeDtos;
      }

      @Override
      public EmployeeDto getEmpById(Long id){
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);

            if(optionalEmployee.isPresent()){
                  Employee employee = optionalEmployee.get();
                  return convertToDto(employee);
            }else{
                  throw new NoSuchElementException("Employee not found with ID: " + id);
            } 
      }

      @Override
      public EmployeeDto updateEmpById(Long id, EmployeeDto employeeDto){
            Optional<Employee> employee = employeeRepository.findById(id);
            if(employee.isPresent()){
                  Employee exixstingEmp = employee.get();
                  exixstingEmp.setName(employeeDto.getName());
                  exixstingEmp.setEmail(employeeDto.getEmail());
                  exixstingEmp.setRole(employeeDto.getRole());

                  Employee updated = employeeRepository.save(exixstingEmp);
                  return convertToDto(updated);
            }else{
                  throw new NoSuchElementException("Emloyee not found with ID: " + id);
            }
      }

      @Override
      public void deleteEmpById(Long id){
           Optional<Employee> employee = employeeRepository.findById(id);
           if(employee.isPresent()){
                  Employee existingEmp = employee.get();
                  employeeRepository.deleteById(id);
           }else{
                  throw new NoSuchElementException("Emloyee not found with ID: " + id);
           }
      }

}