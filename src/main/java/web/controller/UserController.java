package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;


import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String printCars(ModelMap model,  @RequestParam(defaultValue = "5") int count) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "/users";
    }
}