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

    // TODO : generateJobOffers (work test)
    public List<JobOffer> generateJobOffers(int amount) {
        List<JobOffer> jobOffers = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            JobOffer jobOffer = new JobOffer();

            jobOffer.setPosition(stringGenerator(DataValues.getPositions()));
            jobOffer.setCompany(stringGenerator(DataValues.getEmployers()));
            jobOffer.setCity(stringGenerator(DataValues.getCities()));
            jobOffer.setDescription(descriptionsGenerator());
            jobOffer.setRequirements(listOfStringsGenerator(DataValues.getRequirementsAndAdvantages(), random.nextInt(12)));
            jobOffer.setAdvantages(listOfStringsGenerator(DataValues.getRequirementsAndAdvantages(), random.nextInt(12)));
            jobOffer.setBusiness(stringGenerator(DataValues.getBusinessCategories()));
            jobOffer.setWorkTime(workTimeGenerator());
            jobOffer.setIsAvailable(isAvailableGenerator());

            jobOffers.add(jobOffer);
        }

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
