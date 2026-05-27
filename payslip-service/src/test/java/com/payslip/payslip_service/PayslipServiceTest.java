package com.payslip.payslip_service;

import com.payslip.payslip_service.dto.*;
import com.payslip.payslip_service.service.PayslipService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayslipServiceTest {

	@Test
	void testGeneratePayslip() {

		RestTemplate restTemplate =
				Mockito.mock(RestTemplate.class);

		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("Rahul");
		employee.setSalaryPerDay(1200);

		Attendance attendance = new Attendance();
		attendance.setEmployeeId(1L);
		attendance.setDaysPresent(20);

		Mockito.when(
				restTemplate.getForObject(
						"http://localhost:8081/employees/1",
						Employee.class
				)
		).thenReturn(employee);

		Mockito.when(
				restTemplate.getForObject(
						"http://localhost:8082/attendance/1",
						Attendance.class
				)
		).thenReturn(attendance);

		PayslipService service =
				new PayslipService(restTemplate);

		PayslipResponse response =
				service.generatePayslip(1L);

		assertEquals(
				24000,
				response.getTotalSalary()
		);
	}

	@Test
	void testGeneratePayslipWithZeroAttendance() {

		RestTemplate restTemplate =
				Mockito.mock(RestTemplate.class);

		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("Rahul");
		employee.setSalaryPerDay(1200);

		Attendance attendance = new Attendance();
		attendance.setEmployeeId(1L);
		attendance.setDaysPresent(0);

		Mockito.when(
				restTemplate.getForObject(
						"http://localhost:8081/employees/1",
						Employee.class
				)
		).thenReturn(employee);

		Mockito.when(
				restTemplate.getForObject(
						"http://localhost:8082/attendance/1",
						Attendance.class
				)
		).thenReturn(attendance);

		PayslipService service =
				new PayslipService(restTemplate);

		PayslipResponse response =
				service.generatePayslip(1L);

		assertEquals(
				0,
				response.getTotalSalary()
		);
	}
}