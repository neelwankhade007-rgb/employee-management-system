package com.employee.employee_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonAlias;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Long id;
    
    @JsonAlias({"Name", "name"})
    private String name;
    
    private double salaryPerDay;
}
