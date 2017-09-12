package pl.edu.utp.jobfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.utp.jobfinder.model.UserProfile;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    UserProfile findByType(String type);
}
