package pl.edu.utp.jobfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.utp.jobfinder.model.UserRole;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    
}
