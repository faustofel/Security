package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import web.model.Role;
import web.model.User;

import web.service.RoleService;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String getHello(){
        return "/admin/helloAdmin";
    }

    @GetMapping("/usersManagementMain")
    public String getUserManagmentMain(Model model){
        model   .addAttribute("users"   , userService.getAllUsers())
                .addAttribute("allroles", roleService.getAllRoles())
//                .addAttribute("roleId", new ArrayList<Long>())
                .addAttribute("newUser" , new User("USERNAME", "PaSsWoRd_1!"));
        return "/admin/usersManagementMain";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") long id){
        userService.removeUserById(id);
        return "redirect:/admin/usersManagementMain";
    }

    @PostMapping("/usersManagementMain")
    public String saveUser(@ModelAttribute("adduser") User user, @RequestParam(value="roleId")  ArrayList<Long> ids){
        Set<Role> roleSet = user.getRoleSet();
        for(long id : ids){
            roleSet.add(roleService.getRoleById(id));
        }
        userService.addUser(user);
        return "redirect:/admin/usersManagementMain";
    }

    @PatchMapping("{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model){
        model   .addAttribute("edituser", userService.getUserById(id))
                .addAttribute("allroles", roleService.getAllRoles());
        return "/admin/usersManagementEdit";
    }

    @PatchMapping("/usersManagementMain")
    public String updateUser(@ModelAttribute("adduser") User user, @RequestParam(value="roleId")  ArrayList<Long> ids){
        Set<Role> roleSet = user.getRoleSet();
        for(long id : ids){
            roleSet.add(roleService.getRoleById(id));
        }
        userService.updateUser(user);
        return "redirect:/admin/usersManagementMain";
    }
}
