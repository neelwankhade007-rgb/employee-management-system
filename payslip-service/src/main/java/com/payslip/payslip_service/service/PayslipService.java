package com.payslip.payslip_service.service;

import com.payslip.payslip_service.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PayslipService {

    private final RestTemplate restTemplate;

    public PayslipService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PayslipResponse generatePayslip(Long id) {

        Employee employee =
                restTemplate.getForObject(
                        "http://localhost:8081/employees/" + id,
                        Employee.class
                );

        Attendance attendance =
                restTemplate.getForObject(
                        "http://localhost:8082/attendance/" + id,
                        Attendance.class
                );

        double salary =
                employee.getSalaryPerDay()
                        * attendance.getDaysPresent();

        return new PayslipResponse(
                employee.getName(),
                attendance.getDaysPresent(),
                salary
        );
    }
}