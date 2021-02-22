package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.Role;
import web.models.User;
import web.service.UserService;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("usersList", userService.allUsers());
        return "usersPage";
    }

    @GetMapping(value = "/add")
    public String addPage() {
        return "addUser";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";

    }

    @PostMapping(value = "/edit")
    public String editUser(
            @ModelAttribute("user") User user, HttpServletRequest request) {
        Set<Role> roles = user.getRoles();
        String RoleUser = request.getParameter("user");
        String RoleAdmin = request.getParameter("admin");
        if (RoleUser != null) {
            roles.add(Role.USER);
        }
        if (RoleAdmin != null) {
            roles.add(Role.ADMIN);
        }
        user.setRoles(roles);
        userService.save(user);
        return "redirect:/admin";
    }
    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.delete(user);
        return "redirect:/admin";
    }


}
