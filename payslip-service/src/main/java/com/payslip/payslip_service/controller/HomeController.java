package com.payslip.payslip_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/index", "/index.html"})
    public String home() {
        return "index";
    }

    @GetMapping({"/employee", "/employee.html"})
    public String employee() {
        return "employee";
    }

    @GetMapping({"/attendance", "/attendance.html"})
    public String attendance() {
        return "attendance";
    }
}
