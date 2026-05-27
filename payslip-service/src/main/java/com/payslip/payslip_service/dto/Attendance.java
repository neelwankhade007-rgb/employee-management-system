package com.payslip.payslip_service.dto;

import lombok.Data;

@Data
public class Attendance {

    private Long employeeId;
    private int daysPresent;
}