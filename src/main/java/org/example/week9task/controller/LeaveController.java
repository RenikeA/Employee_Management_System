package org.example.week9task.controller;

import org.example.week9task.entity.model.Leave;
import org.example.week9task.entity.model.Employee;
import org.example.week9task.service.LeaveService;
import org.example.week9task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/leaves")
public class LeaveController {


    private final LeaveService leaveService;
    //private final EmployeeService employeeService;

    @Autowired
    LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
       // this.employeeService = employeeService1;
    }

    //"@{/leaves/new}"

    @GetMapping
    public String getAllLeaves(Model model) {
        List<Leave> leaves = leaveService.getAllLeaves();
        model.addAttribute("leaves", leaves);
        return "leaves"; // Thymeleaf template name (leaves.html)
    }


    @GetMapping("/new")
    public String showLeaveForm(Model model) {
        model.addAttribute("leave", new Leave());
        model.addAttribute("title", "Create New Leave");
        model.addAttribute("action", "/leaves/new");
        return "leave-form"; // Thymeleaf template name
    }

//    @GetMapping("/new")
//    public String showLeaveForm(Model model) {
//        model.addAttribute("leave", new Leave());
//        List<Employee> employees = employeeService.getAllEmployees();
//        model.addAttribute("employees", employees);
//        return "leave-form";
//    }

    @PostMapping("/new")
    public String createLeave(@ModelAttribute Leave leave) {
        leaveService.createLeave(leave);
        return "redirect:/leaves";
    }

    @GetMapping("/{id}/approve")
    public String approveLeave(@PathVariable Long id) {
        leaveService.approveLeave(id);
        return "redirect:/leaves";
    }

    @GetMapping("/{id}/decline")
    public String declineLeave(@PathVariable Long id) {
        leaveService.declineLeave(id);
        return "redirect:/leaves";
    }
}
