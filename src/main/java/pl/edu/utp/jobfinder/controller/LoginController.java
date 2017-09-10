package pl.edu.utp.jobfinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    
    @RequestMapping
    public String loginPage(Model model) {
        model.addAttribute("pageTitle", "Sign In or Sign Up - JobFinder");
        return "login";
    } 
    
}
