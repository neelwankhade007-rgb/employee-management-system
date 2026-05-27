package com.attendance.attendance_service.controller;

import com.attendance.attendance_service.entity.Attendance;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/attendance")
@CrossOrigin("*")
public class AttendanceController {

    private final Map<Long, Attendance> attendanceDB = new HashMap<>();

    public AttendanceController() {
        attendanceDB.put(1L, new Attendance(1L, 25));
    }

    @GetMapping
    public java.util.Collection<Attendance> getAllAttendance() {
        return attendanceDB.values();
    }

    @GetMapping("/{id}")
    public Attendance getAttendance(@PathVariable Long id){
        return attendanceDB.getOrDefault(id, new Attendance(id, 0));
    }

    @PostMapping
    public Attendance addAttendance(@RequestBody Attendance attendance) {
        attendanceDB.put(attendance.getEmployeeId(), attendance);
        return attendance;
    }
}
