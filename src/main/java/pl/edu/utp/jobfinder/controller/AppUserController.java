package pl.edu.utp.jobfinder.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.utp.jobfinder.enumerator.EducationTitle;
import pl.edu.utp.jobfinder.enumerator.LevelOfEducation;
import pl.edu.utp.jobfinder.generator.converter.DataConverter;
import pl.edu.utp.jobfinder.generator.extractor.DataExtractor;
import pl.edu.utp.jobfinder.model.AppUser;
import pl.edu.utp.jobfinder.model.Apply;
import pl.edu.utp.jobfinder.model.Cv;
import pl.edu.utp.jobfinder.model.JobOffer;
import pl.edu.utp.jobfinder.model.Message;
import pl.edu.utp.jobfinder.service.AppUserService;
import pl.edu.utp.jobfinder.service.ApplyService;
import pl.edu.utp.jobfinder.service.CvService;
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
    private CvService cvService;

    @Autowired
    private DataConverter dataConverter;
    @Autowired
    private DataExtractor dataExtractor;

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
        AppUser user = appUserService.findByEmail("admin@jobfinder.com");
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "User CV - JobFinder");
        model.addAttribute("cv", user.getCv());

        model.addAttribute("cvPersonalDataBirthDateDay", dataExtractor.birthDateDayExtractor(user.getCv().getBirthDate()));
        model.addAttribute("cvPersonalDataBirthDateMonth", dataExtractor.birthDateMonthExtractor(user.getCv().getBirthDate()));
        model.addAttribute("cvPersonalDataBirthDateYear", dataExtractor.birthDateYearExtractor(user.getCv().getBirthDate()));

        model.addAttribute("cvPersonalDataAddressStreet", dataExtractor.addressStreetExtractor(user.getCv().getAddress()));
        model.addAttribute("cvPersonalDataAddressNr", dataExtractor.addressNrExtractor(user.getCv().getAddress()));
        model.addAttribute("cvPersonalDataAddressFlat", dataExtractor.addressFlatExtractor(user.getCv().getAddress()));
        model.addAttribute("cvPersonalDataAddressPostCode", dataExtractor.addressPostCodeExtractor(user.getCv().getAddress()));
        model.addAttribute("cvPersonalDataAddressCity", dataExtractor.addressCityExtractor(user.getCv().getAddress()));

        model.addAttribute("cvEducationLevelOfEducations", LevelOfEducation.values());
        model.addAttribute("cvEducationEducationTitles", EducationTitle.values());
        model.addAttribute("cvEducationSchools", user.getCv().getSchools());
        model.addAttribute("cvEducationSubjects", user.getCv().getSubjects());
        model.addAttribute("cvEducationEducationDates", user.getCv().getEducationDates());
        model.addAttribute("cvEducationBeginningMonths", dataExtractor.educationBeginningDateMonthsExtractor(user.getCv().getEducationDates()));
        model.addAttribute("cvEducationBeginningYears", dataExtractor.educationBeginningDateYearsExtractor(user.getCv().getEducationDates()));
        model.addAttribute("cvEducationEndMonths", dataExtractor.educationEndDateMonthsExtractor(user.getCv().getEducationDates()));
        model.addAttribute("cvEducationEndYears", dataExtractor.educationEndDateYearsExtractor(user.getCv().getEducationDates()));

        return "userCv";
    }

    @RequestMapping("/cv/personal-data/save")
    public String cvPersonalDataSave(Model model,
            @RequestParam(name = "personal-name") String firstname,
            @RequestParam(name = "personal-lastname") String lastname,
            @RequestParam(name = "personal-birth-day") String day,
            @RequestParam(name = "personal-birth-month") String month,
            @RequestParam(name = "personal-birth-year") String year,
            @RequestParam(name = "personal-email") String email,
            @RequestParam(name = "personal-phone") String phone,
            @RequestParam(name = "personal-address-street") String street,
            @RequestParam(name = "personal-address-building") String building,
            @RequestParam(name = "personal-address-local") String local,
            @RequestParam(name = "personal-address-post") String post,
            @RequestParam(name = "personal-address-city") String city,
            @RequestParam(name = "personal-user-id") Long userId,
            @RequestParam(name = "personal-cv-id") Long cvId
    ) {
        AppUser appUser = appUserService.findOne(userId);
        appUser.setFirstname(firstname.trim());
        appUser.setLastname(lastname.trim());
        appUser.setEmail(email.trim());
        appUserService.save(appUser);

        Cv cv = cvService.findOne(cvId);
        cv.setFirstname(firstname.trim());
        cv.setLastname(lastname.trim());
        cv.setEmail(email.trim());
        StringBuilder address = new StringBuilder();
        address.append(street).append(";").append(building).append(";").append(local).append(";").append(post).append(";").append(city);
        cv.setAddress(address.toString().trim());
        cvService.save(cv);

        return "userCvPersonalDataSaveSuccess";
    }

    @RequestMapping("/cv/education/save")
    public String cvEducationSave(Model model,
            @RequestParam(name = "education-level") String level,
            @RequestParam(name = "education-title") String title,
            @RequestParam(name = "education-school[]") List<String> schools,
            @RequestParam(name = "education-subject[]") List<String> subjects,
            @RequestParam(name = "education-beginning-month[]") List<String> beginningMonths,
            @RequestParam(name = "education-beginning-year[]") List<String> beginningYears,
            @RequestParam(name = "education-end-month[]") List<String> endMonths,
            @RequestParam(name = "education-end-year[]") List<String> endYears,
            @RequestParam(name = "personal-user-id") Long userId,
            @RequestParam(name = "personal-cv-id") Long cvId
    ) {
        Cv cv = cvService.findOne(cvId);
        
        for (LevelOfEducation value : LevelOfEducation.values()) {
            if (value.getLevelOfEducationEN().equals(level)) {
                cv.setLevelOfEducation(value);
            }
        }
        for (EducationTitle value : EducationTitle.values()) {
            if (value.getTitlePL().equals(title)) {
                cv.setEducationTitle(value);
            }
        }
        
        if(schools.size() > 0) {
            cv.setSchools(schools);
            cv.setSubjects(subjects);
            cv.setEducationDates(dataConverter.educationDatesConverter(beginningMonths, beginningYears, endMonths, endYears));
        } else {
            cv.setSchools(new ArrayList<String>());
            cv.setSubjects(new ArrayList<String>());
            cv.setEducationDates(new ArrayList<String>());
        }

        cvService.save(cv);
        
        return "userCvEducationSaveSuccess";
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
