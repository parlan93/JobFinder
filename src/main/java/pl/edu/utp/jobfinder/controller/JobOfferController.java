package pl.edu.utp.jobfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.utp.jobfinder.service.JobOfferService;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
public class JobOfferController {
    
    @Autowired
    private JobOfferService jobOfferService;
    
    @RequestMapping("/")
    public String jobOffers(Model model) {
        model.addAttribute("jobOffers", jobOfferService.findAll());
        return "jobOffers";
    }
}
