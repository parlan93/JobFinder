package pl.edu.utp.jobfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.utp.jobfinder.model.JobOffer;
import pl.edu.utp.jobfinder.service.JobOfferService;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
@RequestMapping("/job-offers")
public class JobOfferController {

    @Autowired
    private JobOfferService jobOfferService;

    @RequestMapping(method = RequestMethod.GET)
    public String jobOffers(Model model) {
        model.addAttribute("pageTitle", "Job Offers - JobFinder");
        model.addAttribute("jobOffers", jobOfferService.findAll());
        model.addAttribute("businesses", jobOfferService.getAvailableBusinesses());
        model.addAttribute("cities", jobOfferService.getAvailableCities());
        model.addAttribute("workTimes", jobOfferService.getAvailableWorkTimes());
        return "jobOffers";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String jobOffersFiltered(Model model,
            @RequestParam("job-finder-business") String business,
            @RequestParam("job-finder-city") String city,
            @RequestParam("job-finder-employment") String workTime) {
        model.addAttribute("pageTitle", "Job Offers - JobFinder");
        model.addAttribute("businesses", jobOfferService.getAvailableBusinesses());
        model.addAttribute("cities", jobOfferService.getAvailableCities());
        model.addAttribute("workTimes", jobOfferService.getAvailableWorkTimes());
        model.addAttribute("selectedBusiness", business);
        model.addAttribute("selectedCity", city);
        model.addAttribute("selectedWorkTime", workTime);
        model.addAttribute("jobOffers", jobOfferService.getFilteredJobOffers(business, city, workTime));
        return "jobOffers";
    }
    
    @RequestMapping("/{id}")
    public String jobOfferDetails(Model model, @PathVariable(name = "id") Long id) {
        JobOffer jobOffer = jobOfferService.findOne(id);
        model.addAttribute("pageTitle", jobOffer.getPosition() + " in " + jobOffer.getCity() + " - JobFinder");
        model.addAttribute("jobOffer", jobOffer);
        return "jobOfferDetails";
    }

}
