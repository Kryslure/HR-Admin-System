package net.javaguides.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Return the login page view
    }

    @PostMapping("/login")
    public RedirectView loginUser(@RequestParam String username, @RequestParam String password)
    {
        // authentication check
        if ("admin".equals(username) && "password".equals(password))
        {
            return new RedirectView("/"); // Redirect to homepage on successful login
        }
        return new RedirectView("/login?error=true"); // Redirect back to login page with error
    }
}
