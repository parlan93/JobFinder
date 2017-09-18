package pl.edu.utp.jobfinder.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.utp.jobfinder.model.Message;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByUserEmail(String email);
}
