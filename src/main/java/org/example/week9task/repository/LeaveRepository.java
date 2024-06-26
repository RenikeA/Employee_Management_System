package org.example.week9task.repository;

import org.example.week9task.entity.model.Leave;
import org.example.week9task.entity.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
   // List<Leave> findByEmployee(Employee employee);
}
