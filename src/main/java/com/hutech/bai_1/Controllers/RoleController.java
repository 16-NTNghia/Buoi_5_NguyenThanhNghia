package com.hutech.bai_1.Controllers;

import com.hutech.bai_1.Entities.Role;
import com.hutech.bai_1.RequestEntities.RoleCreate;
import com.hutech.bai_1.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("")
    public String getRoles(Model model) {
        List<Role> roles = roleService.getAllRole();
        model.addAttribute("roles", roles);
        return "Role/getAll";
    }

    @GetMapping("/new")
    public String addRole(Model model) {
        model.addAttribute("roleCreate", new RoleCreate());
        return "Role/add";
    }
    @PostMapping("/save")
    public String saveRole(RoleCreate roleCreate) {
        roleService.createRole(roleCreate);
        return "redirect:/Roles";
    }
}