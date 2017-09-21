package pl.edu.utp.jobfinder.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.utp.jobfinder.generator.extractor.DataExtractor;
import pl.edu.utp.jobfinder.model.Cv;
import pl.edu.utp.jobfinder.pdf.CvToPdf;
import pl.edu.utp.jobfinder.service.AppUserService;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
@RequestMapping("/")
public class DefaultController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private DataExtractor dataExtractor;

    @RequestMapping
    public String startPage(Model model) {
        model.addAttribute("pageTitle", "JobFinder - Home page");
        return "index";
    }

    @RequestMapping(value = "/cv-pdf", method = RequestMethod.GET)
    public ModelAndView cvPdf() {
        Map<String, Object> model = new HashMap<>();
        Cv cv = appUserService.findByEmail("admin@jobfinder.com").getCv();
        
        List<String> educationDates = new ArrayList<>();
        for (String educationDate : cv.getEducationDates()) {
            educationDates.add(getPrettyShortDate(educationDate));
        }
        List<String> experienceDates = new ArrayList<>();
        for (String experienceDate : cv.getExperienceDates()) {
            experienceDates.add(getPrettyShortDate(experienceDate));
        }
        
        model.put("cv", cv);
        model.put("birthDate", getPrettyBirthdate(cv.getBirthDate()));
        model.put("address", getPrettyAddress(cv.getAddress()));
        model.put("educationDates", educationDates);
        model.put("experienceDates", experienceDates);
        
        return new ModelAndView(new CvToPdf(), model);
    }

    private String getPrettyBirthdate(String ugly) {
        StringBuilder pretty = new StringBuilder();

        if ((Integer.valueOf(dataExtractor.birthDateDayExtractor(ugly)) + 1) < 10) {
            pretty.append("0");
        }
        pretty.append(dataExtractor.birthDateDayExtractor(ugly)).append(".");
        if ((Integer.valueOf(dataExtractor.birthDateMonthExtractor(ugly)) + 1) < 10) {
            pretty.append("0");
        }
        pretty.append(String.valueOf(Integer.valueOf(dataExtractor.birthDateMonthExtractor(ugly)) + 1)).append(".");
        pretty.append(dataExtractor.birthDateYearExtractor(ugly));

        return pretty.toString();
    }

    private String getPrettyAddress(String ugly) {
        StringBuilder pretty = new StringBuilder();

        pretty.append(dataExtractor.addressStreetExtractor(ugly)).append(" ");
        pretty.append(dataExtractor.addressNrExtractor(ugly));
        if (!dataExtractor.addressFlatExtractor(ugly).isEmpty() && dataExtractor.addressFlatExtractor(ugly) != null) {
            pretty.append("/").append(dataExtractor.addressFlatExtractor(ugly));
        }
        pretty.append("\n").append(dataExtractor.addressPostCodeExtractor(ugly)).append(" ");
        pretty.append(dataExtractor.addressCityExtractor(ugly));

        return pretty.toString();
    }

    private String getPrettyShortDate(String ugly) {
        StringBuilder pretty = new StringBuilder();
        
        if ((Integer.valueOf(dataExtractor.shortFromDateMonthExtractor(ugly)) + 1) < 10) {
            pretty.append("0");
        }
        pretty.append(dataExtractor.shortFromDateMonthExtractor(ugly)).append(".");
        pretty.append(dataExtractor.shortFromDateYearExtractor(ugly)).append(" - ");
        if ((Integer.valueOf(dataExtractor.shortToDateMonthExtractor(ugly)) + 1) < 10) {
            pretty.append("0");
        }
        pretty.append(dataExtractor.shortToDateMonthExtractor(ugly)).append(".");
        pretty.append(dataExtractor.shortToDateYearExtractor(ugly));
        
        return pretty.toString();
    }
    
}
