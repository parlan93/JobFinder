package pl.edu.utp.jobfinder.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.utp.jobfinder.model.Apply;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Repository
public interface ApplyRepository extends JpaRepository<Apply, Long> {

    List<Apply> findByCvEmail(String email);
}
