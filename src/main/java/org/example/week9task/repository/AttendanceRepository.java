package org.example.week9task.repository;

import org.example.week9task.entity.model.Attendance;
import org.example.week9task.entity.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    //List<Attendance> findByEmployee(Employee employee);
}


