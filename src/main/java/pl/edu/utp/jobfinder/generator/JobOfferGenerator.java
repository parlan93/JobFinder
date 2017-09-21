package pl.edu.utp.jobfinder.generator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pl.edu.utp.jobfinder.enumerator.WorkTime;
import pl.edu.utp.jobfinder.generator.data.DataValues;
import pl.edu.utp.jobfinder.model.JobOffer;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Service
public class JobOfferGenerator extends AbstractGenerator {

    // Constructors
    public JobOfferGenerator() {
        super();
    }

    /**
     * Generate job offers - generate declared amount random job offers
     * 
     * @param amount
     * @return 
     */
    public List<JobOffer> generateJobOffers(int amount) {
        // Create new list of job offers
        List<JobOffer> jobOffers = new ArrayList<>();

        // Generates job offers
        for (int i = 0; i < amount; i++) {
            // Create new job offer
            JobOffer jobOffer = new JobOffer();

            // Set random values to job offer object
            jobOffer.setPosition(stringGenerator(DataValues.getPositions()));
            jobOffer.setCompany(stringGenerator(DataValues.getEmployers()));
            jobOffer.setCity(stringGenerator(DataValues.getCities()));
            jobOffer.setDate(dateObjectGenerator());
            jobOffer.setDescription(descriptionsGenerator());
            jobOffer.setRequirements(listOfSentencesGenerator(DataValues.getWords(), random.nextInt(12)));
            jobOffer.setAdvantages(listOfSentencesGenerator(DataValues.getWords(), random.nextInt(12)));
            jobOffer.setBusiness(stringGenerator(DataValues.getBusinessCategories()));
            jobOffer.setWorkTime(workTimeGenerator());
            jobOffer.setIsAvailable(isAvailableGenerator());

            // Add job offer to job offers list
            jobOffers.add(jobOffer);
        }

        // Return job offers
        return jobOffers;
    }

    /**
     * Work time generator - retun random value of WorkTime enum
     *
     * @return
     */
    private WorkTime workTimeGenerator() {
        return WorkTime.values()[random.nextInt(WorkTime.values().length)];
    }

    /**
     * Is available generator - return true or false based on random value
     *
     * @return
     */
    private Boolean isAvailableGenerator() {
        return (random.nextInt(4) + 1) % 2 != 0;
    }
}
