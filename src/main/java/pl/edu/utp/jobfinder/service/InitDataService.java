package pl.edu.utp.jobfinder.service;

import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.utp.jobfinder.generator.AppUserGenerator;
import pl.edu.utp.jobfinder.generator.ApplyGenerator;
import pl.edu.utp.jobfinder.generator.CvGenerator;
import pl.edu.utp.jobfinder.generator.JobOfferGenerator;
import pl.edu.utp.jobfinder.generator.MessageGenerator;
import pl.edu.utp.jobfinder.model.AppUser;
import pl.edu.utp.jobfinder.model.Apply;
import pl.edu.utp.jobfinder.model.Cv;
import pl.edu.utp.jobfinder.model.JobOffer;
import pl.edu.utp.jobfinder.model.Message;
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
    
    // Random object to generate values
    private final Random random = new Random();
    
    // Logger
    private final Logger LOGGER = LoggerFactory.getLogger(InitDataService.class);

    // Constants
    private final int USERS_TO_GENERATE = 50 + random.nextInt(50);
    private final int APPLIES_TO_GENERATE = 30 + random.nextInt(35);
    private final int JOB_OFFERS_TO_GENERATE = 10 + random.nextInt(20);
    private final int MESSAGES_TO_GENERATE = 100 + random.nextInt(100);
    
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
    @Autowired
    private MessageGenerator messageGenerator;

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
        List<AppUser> appUsers = appUserGenerator.generateAppUsers(USERS_TO_GENERATE);
        appUserRepository.save(appUsers);
        
        List<Cv> cvs = cvGenerator.generateCVs(appUserRepository.findAll());
        cvRepository.save(cvs);
        
        List<JobOffer> jobOffers = jobOfferGenerator.generateJobOffers(JOB_OFFERS_TO_GENERATE);
        jobOfferRepository.save(jobOffers);
        
        List<Apply> applies = applyGenerator.generateApplies(APPLIES_TO_GENERATE);
        applyRepository.save(applies);
        
        List<Message> messages = messageGenerator.generateMessages(MESSAGES_TO_GENERATE);
        messageRepository.save(messages);

        // Log info about generated data
        getGeneratedDataInfo();
        
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

    /**
     * Get information about generated data
     */
    private void getGeneratedDataInfo() {
        LOGGER.info("GENERATED DATA");
        LOGGER.info("Users: " + String.valueOf(appUserRepository.findAll().size()));
        LOGGER.info("JobOffers: " + String.valueOf(jobOfferRepository.findAll().size()));
        LOGGER.info("Applies: " + String.valueOf(applyRepository.findAll().size()));
        LOGGER.info("Messages: " + String.valueOf(messageRepository.findAll().size()));
    }
}
