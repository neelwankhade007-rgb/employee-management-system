package com.payslip.payslip_service.controller;

import com.payslip.payslip_service.dto.PayslipResponse;
import com.payslip.payslip_service.service.PayslipService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payslip")
@CrossOrigin("*")
public class PayslipController {

    private final PayslipService service;

    public PayslipController(PayslipService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public PayslipResponse getPayslip(
            @PathVariable Long id
    ) {

        return service.generatePayslip(id);
    }
}