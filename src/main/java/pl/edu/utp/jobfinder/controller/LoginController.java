package pl.edu.utp.jobfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.utp.jobfinder.model.AppUser;
import pl.edu.utp.jobfinder.service.AppUserService;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AppUserService appUserService;

    @RequestMapping
    public String loginPage(Model model) {
        model.addAttribute("pageTitle", "Sign In or Sign Up - JobFinder");
        return "login";
    }

    @RequestMapping("/sign-up")
    public String signUp(Model model,
            @RequestParam("register-email-field") String email,
            @RequestParam("register-password-field") String password,
            @RequestParam("register-repeat-password-field") String repeatedPassword) {
        // TODO : valid email, password and repeated password
        // TODO : add registered user to DB
        // TODO : set session user and redirect to user panel and add user panel to view
        return null;
    }

    @RequestMapping("/sign-in")
    public String signIn(Model model,
            @ModelAttribute("user") AppUser user,
            @RequestParam("login-email") String email,
            @RequestParam("login-password") String password) {
        // TODO : valid user
        // TODO : set session user and redirect to user panel and add user panel to view
        AppUser tmp = null;
        tmp = appUserService.findByEmailAndPassword(email, password);
        System.out.println(tmp.getFirstname());
        if (tmp != null) {
            user = tmp;
        }

        return "tmp";
    }

    @ModelAttribute("user")
    public AppUser getUser() {
        return new AppUser();
    }

}
