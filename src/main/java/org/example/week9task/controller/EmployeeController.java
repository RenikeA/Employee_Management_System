package org.example.week9task.controller;

import org.example.week9task.entity.model.Employee;
import org.example.week9task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService  employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees"; // Thymeleaf template name (employees.html)
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("title", "Create New Employee");
        model.addAttribute("action", "/employees/new");
        return "employee-form"; // Thymeleaf template name
    }

    @PostMapping("/new")
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            model.addAttribute("title", "Edit Employee");
            model.addAttribute("action", "/employees/" + id + "/edit");
            return "employee-form"; // Thymeleaf template name (employee-form.html)
        }
        return "redirect:/employees";
    }

    @PostMapping("/{id}/edit")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
        Employee existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee != null) {
            employee.setId(id); // Ensure the ID is set correctly for update
            employeeService.updateEmployee(id, employee);
        }
        return "redirect:/employees";
    }

    @GetMapping("/{id}/delete")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
