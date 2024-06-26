package org.example.week9task.controller;

import org.example.week9task.entity.model.Admin;
import org.example.week9task.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public String getAllAdmins(Model model) {
        List<Admin> admins = adminService.getAllAdmins();
        model.addAttribute("admins", admins);
        return "admin/dashboard"; // Thymeleaf template name
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin/admin-form"; // Thymeleaf template name
    }

    @PostMapping
    public String createAdmin(@ModelAttribute Admin admin) {
        adminService.createAdmin(admin);
        return "redirect:/admins";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Admin admin = adminService.getAdminById(id);
        model.addAttribute("admin", admin);
        return "admin/admin-form"; // Thymeleaf template name
    }

    @PostMapping("/{id}")
    public String updateAdmin(@PathVariable Long id, @ModelAttribute Admin admin) {
        adminService.updateAdmin(id, admin);
        return "redirect:/admins";
    }

    @GetMapping("/{id}/delete")
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return "redirect:/admins";
    }
}
