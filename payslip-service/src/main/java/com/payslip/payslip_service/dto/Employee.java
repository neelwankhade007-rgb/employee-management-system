package com.payslip.payslip_service.dto;

import lombok.Data;

@Data
public class Employee {

    private Long id;
    private String name;
    private double salaryPerDay;
}
