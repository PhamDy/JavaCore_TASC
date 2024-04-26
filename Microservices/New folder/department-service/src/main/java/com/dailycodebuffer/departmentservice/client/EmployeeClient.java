package com.dailycodebuffer.departmentservice.client;

import com.dailycodebuffer.departmentservice.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetMapping("employee/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId){

    }
}
