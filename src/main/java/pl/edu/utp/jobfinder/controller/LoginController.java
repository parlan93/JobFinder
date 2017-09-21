package pl.edu.utp.jobfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.utp.jobfinder.model.AppUser;
import pl.edu.utp.jobfinder.service.AppUserService;
import pl.edu.utp.jobfinder.validator.SignUpValidator;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private SignUpValidator validator;

    @RequestMapping
    public String loginPage(Model model) {
        model.addAttribute("pageTitle", "Sign In or Sign Up - JobFinder");
        return "login";
    }

    @RequestMapping("/sign-up")
    public String signUp(Model model,
            @RequestParam("register-email") String email,
            @RequestParam("register-password") String password,
            @RequestParam("register-repeat-password") String repeatedPassword) {
        if (validator.emailValidation(email) && validator.passwordValidation(password, repeatedPassword)) {
            appUserService.save(new AppUser("", "", email, password));
            model.addAttribute("pageTitle", "Sign up - Success!");
            model.addAttribute("user", appUserService.findByEmail(email));
            return "signUpSuccess";
        }
        model.addAttribute("pageTitle", "Sign up - Error!");
        return "signUpError";
    }

    @RequestMapping("/sign-in")
    public String signIn(Model model,
            @RequestParam("login-email") String email,
            @RequestParam("login-password") String password) {
        if (appUserService.findByEmailAndPassword(email, password) != null) {
            return "redirect:/account";
        } 
        model.addAttribute("pageTitle", "Sign in - Error!");
        return "signInError";
    }
    
}
