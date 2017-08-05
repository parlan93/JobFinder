package pl.edu.utp.jobfinder.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @PostConstruct
    public void init() {
        jobOfferRepository.save(Arrays.asList(
                new JobOffer("Mechanik 1", "Mechanika Pojazdowa", "Bydgoszcz", Arrays.asList("1", "2", "3")),
                new JobOffer("Mechanik 2", "Mechanika Pojazdowa", "Bydgoszcz", Arrays.asList("1", "2", "3"))
        ));
    }

    public List<JobOffer> findAll() {
        return jobOfferRepository.findAll();
    }

}
