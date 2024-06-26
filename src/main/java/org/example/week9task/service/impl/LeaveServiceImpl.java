package org.example.week9task.service.impl;

import org.example.week9task.entity.model.Leave;
import org.example.week9task.repository.LeaveRepository;
import org.example.week9task.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    @Override
    public Leave getLeaveById(Long id) {
        Optional<Leave> leaveOptional = leaveRepository.findById(id);
        return leaveOptional.orElse(null);
    }

    @Override
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public Leave createLeave(Leave leave) {
       // leave.setStatus("Pending"); // Set initial status
        return leaveRepository.save(leave);
    }

    @Override
    public Leave updateLeave(Long id, Leave leave) {
        Leave existingLeave = getLeaveById(id);
        if (existingLeave != null) {
            existingLeave.setStartDate(leave.getStartDate());
            existingLeave.setEndDate(leave.getEndDate());
            existingLeave.setReason(leave.getReason());
            return leaveRepository.save(existingLeave);
        }
        return null;
    }

    @Override
    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }

    @Override
    public void approveLeave(Long id) {
        Leave leave = getLeaveById(id);
        if (leave != null) {
            leave.setStatus("Approved");
            leaveRepository.save(leave);
        }
    }

    @Override
    public void declineLeave(Long id) {
        Leave leave = getLeaveById(id);
        if (leave != null) {
            leave.setStatus("Declined");
            leaveRepository.save(leave);
        }
    }
}
