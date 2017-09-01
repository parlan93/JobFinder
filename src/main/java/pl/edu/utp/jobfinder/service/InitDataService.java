package pl.edu.utp.jobfinder.service;

import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.utp.jobfinder.generator.AppUserGenerator;
import pl.edu.utp.jobfinder.generator.ApplyGenerator;
import pl.edu.utp.jobfinder.generator.CvGenerator;
import pl.edu.utp.jobfinder.generator.JobOfferGenerator;
import pl.edu.utp.jobfinder.model.AppUser;
import pl.edu.utp.jobfinder.model.Apply;
import pl.edu.utp.jobfinder.model.Cv;
import pl.edu.utp.jobfinder.model.JobOffer;
import pl.edu.utp.jobfinder.repository.AppUserRepository;
import pl.edu.utp.jobfinder.repository.ApplyRepository;
import pl.edu.utp.jobfinder.repository.CvRepository;
import pl.edu.utp.jobfinder.repository.JobOfferRepository;
import pl.edu.utp.jobfinder.repository.MessageRepository;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Service
@Transactional
public class InitDataService {

    // Repositories
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private ApplyRepository applyRepository;
    @Autowired
    private CvRepository cvRepository;
    @Autowired
    private JobOfferRepository jobOfferRepository;
    @Autowired
    private MessageRepository messageRepository;
    
    // Generators
    @Autowired
    private AppUserGenerator appUserGenerator;
    @Autowired
    private CvGenerator cvGenerator;
    @Autowired
    private JobOfferGenerator jobOfferGenerator;
    @Autowired
    private ApplyGenerator applyGenerator;
    
    // Random object to generate values
    Random random = new Random();

    // Constructor
    public InitDataService() {
    }

    /**
     * Init - generate initial data
     */
    @PostConstruct
    public void init() {

        // Delete existing data in database
        deleteExistingData();

        // Generate new data
        
        List<AppUser> appUsers = appUserGenerator.generateAppUsers(5);
        appUserRepository.save(appUsers);
        
        List<Cv> cvs = cvGenerator.generateCVs(appUserRepository.findAll());
        cvRepository.save(cvs);
        
        List<JobOffer> jobOffers = jobOfferGenerator.generateJobOffers(5);
        jobOfferRepository.save(jobOffers);
        
        List<Apply> applies = applyGenerator.generateApplies(3);
        applyRepository.save(applies);
        
        
    }

    /**
     * Delete existing data in database
     */
    private void deleteExistingData() {
        // Delete data from all repositories
        appUserRepository.deleteAll();
        applyRepository.deleteAll();
        cvRepository.deleteAll();
        jobOfferRepository.deleteAll();
        messageRepository.deleteAll();
    }

}
