package org.example.week9task.service;

import org.example.week9task.entity.model.Attendance;
import org.example.week9task.entity.model.Employee;

import java.util.List;

public interface AttendanceService {
    List<Attendance> getAllAttendances();

    Attendance getAttendanceById(Long id);

    List<Attendance> getAttendancesByEmployee(Employee employee);

    Attendance createAttendance(Attendance attendance);

    Attendance updateAttendance(Long id, Attendance attendance);

    void deleteAttendance(Long id);
}

