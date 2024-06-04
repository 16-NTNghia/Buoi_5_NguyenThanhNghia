package com.hutech.bai_1.Controllers;


import com.hutech.bai_1.Entities.Role;
import com.hutech.bai_1.Entities.User;
import com.hutech.bai_1.RequestEntities.UserCreate;
import com.hutech.bai_1.RequestEntities.UserUpdate;
import com.hutech.bai_1.Services.RoleService;
import com.hutech.bai_1.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @GetMapping("")
    public String getAllUser(Model model){
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "User/getAll";
    }
    @GetMapping("/new")
    public String addUser(Model model){
        UserCreate userCreate = new UserCreate();
        List<Role> roles = roleService.getAllRole();
        model.addAttribute("userCreate", userCreate);
        model.addAttribute("roles", roles);
        return "User/add";
    }
    @PostMapping("/save")
    public String saveUser(UserCreate userCreate){
        userService.createUser(userCreate);
        return "redirect:/Users";
    }
    @GetMapping("/view/{id}")
    public String viewUser(@PathVariable String id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "User/view";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable String id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "User/edit";
    }

    @PostMapping("/saveedit")
    public String saveUserEdit(UserUpdate userUpdate){
        userService.Updateuser(userUpdate);
        return "redirect:/Users";
    }
}
