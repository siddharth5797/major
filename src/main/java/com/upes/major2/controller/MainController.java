package com.upes.major2.controller;

import com.upes.major2.service.ExternalDriveService;
import com.upes.major2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    LoginService loginService;

    @Autowired
    ExternalDriveService externalDriveService;

    @GetMapping("/login")
    public String login(Model model) throws IOException {
        model.addAttribute("successLogin",loginService.getSuccessLogins());
        model.addAttribute("failedLogin",loginService.getFailedLogins());
        model.addAttribute("successLoginCount",loginService.getSuccessLogins().size());
        model.addAttribute("failedLoginCount",loginService.getFailedLogins().size());
        return "login";
    }

    @GetMapping("/external")
    public String external(Model model) throws IOException {
        model.addAttribute("deviceDetails",externalDriveService.getRecords());
        return "external";
    }
}
