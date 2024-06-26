package org.example.week9task.service;

import org.example.week9task.entity.model.Employee;
import org.example.week9task.entity.model.Leave;

import java.util.List;

public interface LeaveService {


    Leave getLeaveById(Long id);

    List<Leave> getAllLeaves();

    Leave createLeave(Leave leave);

    Leave updateLeave(Long id, Leave leave);

    void deleteLeave(Long id);

    void approveLeave(Long id);

    void declineLeave(Long id);
}
