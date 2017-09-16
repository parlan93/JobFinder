package pl.edu.utp.jobfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.utp.jobfinder.service.AppUserService;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
@RequestMapping("/account")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @RequestMapping
    public String dashboard(Model model) {
        model.addAttribute("user", appUserService.findByEmail("admin@jobfinder.com"));
        model.addAttribute("pageTitle", "User dashboard - JobFinder");
        return "dashboard";
    }

}
