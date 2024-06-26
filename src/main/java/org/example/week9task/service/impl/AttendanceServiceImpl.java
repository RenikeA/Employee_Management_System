package org.example.week9task.service.impl;

import org.example.week9task.entity.model.Attendance;
import org.example.week9task.entity.model.Employee;
import org.example.week9task.repository.AttendanceRepository;
import org.example.week9task.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance getAttendanceById(Long id) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);
        return optionalAttendance.orElse(null);
    }

    @Override
    public List<Attendance> getAttendancesByEmployee(Employee employee) {
      //  return attendanceRepository.findByEmployee(employee);

        return null;
    }

    @Override
    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance updateAttendance(Long id, Attendance attendance) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);
        if (optionalAttendance.isPresent()) {
            Attendance existingAttendance = optionalAttendance.get();
            existingAttendance.setPosition(attendance.getPosition());
            existingAttendance.setDate(attendance.getDate());
            existingAttendance.setPresent(attendance.getPresent());
            // Update other fields as needed
            return attendanceRepository.save(existingAttendance);
        } else {
            return null;
        }
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}

