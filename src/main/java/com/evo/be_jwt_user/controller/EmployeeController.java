package com.evo.be_jwt_user.controller;

import com.evo.be_jwt_user.entity.Employee;
import com.evo.be_jwt_user.exception.ResourceNotFoundException;
import com.evo.be_jwt_user.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @GetMapping()
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    //create employee rest api
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

    //get employee by id rest api
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){

        Employee employee = employeeRepo.findById(id).orElseThrow(() ->new ResourceNotFoundException("Employee not exits with id :" + id));
        return ResponseEntity.ok(employee);
    }

    //Update employee rest api
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails){
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("Employee not exits with id :" + id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());

        Employee updateEmployee = employeeRepo.save(employee);
        return ResponseEntity.ok(employee);
    }

    //Delete employee
    @DeleteMapping("/delete/{id}")
    // delete employee rest api
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        employeeRepo.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}