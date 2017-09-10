package pl.edu.utp.jobfinder.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.utp.jobfinder.enumerator.WorkTime;
import pl.edu.utp.jobfinder.model.JobOffer;
import pl.edu.utp.jobfinder.repository.JobOfferRepository;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Service
@Transactional
public class JobOfferService {

    @Autowired
    private JobOfferRepository jobOfferRepository;

    public List<JobOffer> getFilteredJobOffers(String business, String city, String workTime) {
        List<JobOffer> filteredJobOffers = new ArrayList<>();
        List<JobOffer> foundByBusiness = business.equals("*") ? jobOfferRepository.findAll() : jobOfferRepository.findByBusiness(business);
        List<JobOffer> foundByCity = city.equals("*") ? jobOfferRepository.findAll() : jobOfferRepository.findByCity(city);
        List<JobOffer> foundByWorkTime = workTime.equals("*") ? null : jobOfferRepository.findByWorkTime(WorkTime.valueOf(workTime));
        for (JobOffer jobOfferByBusiness : foundByBusiness) {
            if (foundByWorkTime != null) {
                if (foundByCity.contains(jobOfferByBusiness) && foundByWorkTime.contains(jobOfferByBusiness)) {
                    filteredJobOffers.add(jobOfferByBusiness);
                }
            } else {
                if (foundByCity.contains(jobOfferByBusiness)) {
                    filteredJobOffers.add(jobOfferByBusiness);
                }
            }

        }
        return filteredJobOffers;
    }

    public List<String> getAvailableBusinesses() {
        List<String> businesses = new ArrayList<>();
        List<JobOffer> jobOffers = jobOfferRepository.findAll();
        for (JobOffer jobOffer : jobOffers) {
            String business = jobOffer.getBusiness();
            if (!businesses.contains(business)) {
                businesses.add(business);
            }
        }
        return businesses;
    }

    public List<String> getAvailableCities() {
        List<String> cities = new ArrayList<>();
        List<JobOffer> jobOffers = jobOfferRepository.findAll();
        for (JobOffer jobOffer : jobOffers) {
            String city = jobOffer.getCity();
            if (!cities.contains(city)) {
                cities.add(city);
            }
        }
        return cities;
    }

    public List<String> getAvailableWorkTimes() {
        List<String> workTimes = new ArrayList<>();
        List<JobOffer> jobOffers = jobOfferRepository.findAll();
        for (JobOffer jobOffer : jobOffers) {
            String workTime = jobOffer.getWorkTime().name();
            if (!workTimes.contains(workTime)) {
                workTimes.add(workTime);
            }
        }
        return workTimes;
    }

    // Delegate methods
    public List<JobOffer> findAll() {
        return jobOfferRepository.findAll();
    }

    public JobOffer findOne(Long id) {
        return jobOfferRepository.findOne(id);
    }

}
