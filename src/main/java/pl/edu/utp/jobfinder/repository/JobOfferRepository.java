package pl.edu.utp.jobfinder.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.utp.jobfinder.enumerator.WorkTime;
import pl.edu.utp.jobfinder.model.JobOffer;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Repository
public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {

    List<JobOffer> findByBusiness(String business);

    List<JobOffer> findByCity(String city);

    List<JobOffer> findByWorkTime(WorkTime workTime);
}
