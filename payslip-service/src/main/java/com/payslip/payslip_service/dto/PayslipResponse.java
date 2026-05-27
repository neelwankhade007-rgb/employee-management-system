package com.payslip.payslip_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayslipResponse {

    private String employeeName;
    private int daysPresent;
    private double totalSalary;
}
