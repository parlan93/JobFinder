package pl.edu.utp.jobfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.utp.jobfinder.model.Cv;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Repository
public interface CvRepository extends JpaRepository<Cv, Long> {
    
}
