/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findingcareer.controller;

import com.findingcareer.pojo.Employer;
import com.findingcareer.pojo.User;
import com.findingcareer.service.EmployerService;
import com.findingcareer.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hp
 */
@Controller
public class UserController {

    @Autowired
    private UserService userDetailsService;
    @Autowired
    private EmployerService employerService;

    @RequestMapping("/user/authorize")
    public String Authorize() {

        return "authorization";
    }

    @GetMapping("/login")
    public String Login() {

        return "login";
    }

    @GetMapping("/signup")
    public String SignupView(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }
//    

    @PostMapping("/signup")
    public String Signup(Model model, @ModelAttribute(value = "user") User user) {
        String errorMessage;

        if (user.getPassword().equals(user.getRePassword())) {
            if (this.userDetailsService.addUser(user) == true) {
                return "redirect:/login";
            } else {
                errorMessage = "Hệ thống hiện đang lỗi! Vui lòng thử lại sau";
            }
        } else {
            errorMessage = "Mật khẩu không khớp! Vui lòng thực hiện lại";
        }

        model.addAttribute("errorMessage", errorMessage);

        return "signup";
    }

    @GetMapping(path = "/admin")
    public String admin(Model model) {

        return "dashboard";
    }

    @GetMapping(path = "/admin/browse")
    public String browseEmployer(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        String page = params.getOrDefault("page", "1");

        model.addAttribute("employer",
                this.employerService.getListEmployerByName("", Integer.parseInt(page), 0));
        model.addAttribute("counter",
                this.employerService.countEmployer());

        return "browseEmployer";
    }
}
