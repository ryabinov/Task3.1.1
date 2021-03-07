package web.controllers;

//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import web.models.User;
//import org.springframework.stereotype.Controller;
//import web.service.UserService;
//import web.service.UserServiceImpl;
//
//@Controller
//@RequestMapping("/")
//public class UserController {
//
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/user")
//    public ModelAndView showUser() {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("infoUser");
//        modelAndView.addObject("user", user);
//        return modelAndView;
//
//    }
//    @GetMapping(value = "/user/{id}")
//    public String showUserById(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("user", userService.getById(id));
//        return "infoUser";
//
//    }
//
//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }
//
//
//}
//
