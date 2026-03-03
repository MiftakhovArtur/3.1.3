package ru.kata.spring.boot_security.demo.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ModelAndView listUsers() {
        ModelAndView mv = new ModelAndView("admin/users");
        List<User> users = userService.getAllUsers();
        mv.addObject("users", users);
        return mv;
    }

    @GetMapping("/userUpdate/{id}")
    public ModelAndView editUserForm(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("admin/userUpdate");
        User user = userService.findOneById(id);
        mv.addObject("user", user);
        return mv;
    }

    @PostMapping("/updateUser")
    public ModelAndView updateUser(@ModelAttribute("user") @Valid User user,
                                   BindingResult bindingResult,
                                   @RequestParam(value = "roles", required = false) List<String> roles) {
        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("admin/userUpdate");
            mv.addObject("user", user);
            return mv;
        }

        userService.updateUser(user, roles);
        return new ModelAndView("redirect:/admin/users");
    }

    @GetMapping("/deleteUser/{id}")
    public ModelAndView deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
        return new ModelAndView("redirect:/admin/users");
    }
}

