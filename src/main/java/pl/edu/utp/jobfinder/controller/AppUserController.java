package pl.edu.utp.jobfinder.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.utp.jobfinder.generator.converter.DataConverter;
import pl.edu.utp.jobfinder.model.AppUser;
import pl.edu.utp.jobfinder.model.Apply;
import pl.edu.utp.jobfinder.model.JobOffer;
import pl.edu.utp.jobfinder.model.Message;
import pl.edu.utp.jobfinder.service.AppUserService;
import pl.edu.utp.jobfinder.service.ApplyService;
import pl.edu.utp.jobfinder.service.JobOfferService;
import pl.edu.utp.jobfinder.service.MessageService;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
@RequestMapping("/account")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private ApplyService applyService;
    
    @Autowired
    private JobOfferService jobOfferService;

    @Autowired
    private DataConverter dataConverter;

    @RequestMapping
    public String dashboard(Model model) {
        AppUser user = appUserService.findByEmail("admin@jobfinder.com");
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "User dashboard - JobFinder");

        model.addAttribute("userBirthDate", dataConverter.birthDateConverter(user.getCv().getBirthDate()));
        model.addAttribute("userAddress", dataConverter.addressConverter(user.getCv().getAddress()));

        List<Message> messages = messageService.findByUserEmail("admin@jobfinder.com");
        if (messages != null) {
            switch (messages.size()) {
                case 0:
                    model.addAttribute("messagesNotFound", true);
                    break;
                case 1:
                    model.addAttribute("messagesNotFound", false);
                    model.addAttribute("messageOne", messages.get(0));
                    model.addAttribute("messageTwo", null);
                    model.addAttribute("messageThree", null);
                    break;
                case 2:
                    model.addAttribute("messagesNotFound", false);
                    model.addAttribute("messageOne", messages.get(0));
                    model.addAttribute("messageTwo", messages.get(1));
                    model.addAttribute("messageThree", null);
                    break;
                default:
                    model.addAttribute("messagesNotFound", false);
                    model.addAttribute("messageOne", messages.get(0));
                    model.addAttribute("messageTwo", messages.get(1));
                    model.addAttribute("messageThree", messages.get(2));
                    break;
            }
        } else {
            model.addAttribute("messagesNotFound", true);
        }

        List<Apply> applies = applyService.findByCvEmail("admin@jobfinder.com");
        if (applies != null) {
            switch (applies.size()) {
                case 0:
                    model.addAttribute("appliesNotFound", true);
                    break;
                case 1:
                    model.addAttribute("appliesNotFound", false);
                    model.addAttribute("applyOne", applies.get(0));
                    model.addAttribute("applyTwo", null);
                    model.addAttribute("applyThree", null);
                    break;
                case 2:
                    model.addAttribute("appliesNotFound", false);
                    model.addAttribute("applyOne", applies.get(0));
                    model.addAttribute("applyTwo", applies.get(1));
                    model.addAttribute("applyThree", null);
                    break;
                default:
                    model.addAttribute("appliesNotFound", false);
                    model.addAttribute("applyOne", applies.get(0));
                    model.addAttribute("applyTwo", applies.get(1));
                    model.addAttribute("applyThree", applies.get(2));
                    break;
            }
        } else {
            model.addAttribute("appliesNotFound", true);
        }

        return "userDashboard";
    }

    // TODO: cv
    @RequestMapping("/cv")
    public String cvForm(Model model) {
        model.addAttribute("user", appUserService.findByEmail("admin@jobfinder.com"));
        model.addAttribute("pageTitle", "User CV - JobFinder");
        return "userCv";
    }

    @RequestMapping("/messages")
    public String messages(Model model) {
        model.addAttribute("user", appUserService.findByEmail("admin@jobfinder.com"));
        model.addAttribute("pageTitle", "User Messages - JobFinder");
        model.addAttribute("messages", messageService.findByUserEmail("admin@jobfinder.com"));
        model.addAttribute("messagesAmount", messageService.findByUserEmail("admin@jobfinder.com").size() + 1);
        return "userMessages";
    }

    @RequestMapping("/messages/{id}")
    public String readMessage(Model model, @PathVariable(name = "id") Long id) {
        Message message = messageService.findOne(id);
        model.addAttribute("pageTitle", "Message");
        model.addAttribute("message", message);
        if (!message.isIsReaded()) {
            message.setIsReaded(true);
            messageService.save(message);
        }
        return "userMessagesSingle";
    }

    @RequestMapping("/applies")
    public String applies(Model model) {
        model.addAttribute("user", appUserService.findByEmail("admin@jobfinder.com"));
        model.addAttribute("pageTitle", "User Applies - JobFinder");
        model.addAttribute("applies", applyService.findByCvEmail("admin@jobfinder.com"));
        model.addAttribute("appliesAmount", applyService.findByCvEmail("admin@jobfinder.com").size() + 1);
        return "userApplies";
    }
    
    @RequestMapping("/applies/{id}")
    public String showJobOffer(Model model, @PathVariable(name = "id") Long id) {
        JobOffer jobOffer = jobOfferService.findOne(id);
        model.addAttribute("pageTitle", jobOffer.getPosition() + " in " + jobOffer.getCity() + " - JobFinder");
        model.addAttribute("jobOffer", jobOffer);
        return "userJobOfferDetails";
    }
    
}
