package org.example.week9task.controller;

import org.example.week9task.entity.model.Attendance;
import org.example.week9task.entity.model.Employee;
import org.example.week9task.service.AttendanceService;
import org.example.week9task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attendances")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String getAllAttendances(Model model) {
        List<Attendance> attendances = attendanceService.getAllAttendances();
        model.addAttribute("attendances", attendances);
        return "attendances"; // Thymeleaf template name
    }

    @GetMapping("/new")
    public String showAttendanceForm(Model model) {
        model.addAttribute("attendance", new Attendance());
        model.addAttribute("title", "Create New Attendance");
        model.addAttribute("action", "/attendances/new");
        return "attendance-form"; // Thymeleaf template name
    }

    @PostMapping("/new")
    public String createAttendance(@ModelAttribute Attendance attendance) {
        attendanceService.createAttendance(attendance);
        return "redirect:/attendances";
    }

//    @GetMapping("/employee/{employeeId}")
//    public String getAttendancesByEmployee(@PathVariable Long employeeId, Model model) {
//        Employee employee = employeeService.getEmployeeById(employeeId);
//        if (employee == null) {
//
//            return "error";
//        }
//        List<Attendance> attendances = attendanceService.getAttendancesByEmployee(employee);
//        model.addAttribute("attendances", attendances);
//        model.addAttribute("employee", employee);
//        return "attendances/listByEmployee";
//    }

//    @PostMapping("/create")
//    public String createAttendance(@ModelAttribute Attendance attendance) {
//        attendanceService.createAttendance(attendance);
//        return "redirect:/attendances";
//    }

//    @GetMapping("/{id}/edit")
//    public String showUpdateForm(@PathVariable Long id, Model model) {
//        Attendance attendance = attendanceService.getAttendanceById(id);
//        model.addAttribute("attendance", attendance);
//        return "attendances/update-form";
//    }
//
//    @PostMapping("/{id}/edit")
//    public String updateAttendance(@PathVariable Long id, @ModelAttribute Attendance attendance) {
//        attendanceService.updateAttendance(id, attendance);
//        return "redirect:/attendances";
//    }

//    @GetMapping("/{id}/delete")
//    public String deleteAttendance(@PathVariable Long id) {
//        attendanceService.deleteAttendance(id);
//        return "redirect:/attendances";
//    }

}