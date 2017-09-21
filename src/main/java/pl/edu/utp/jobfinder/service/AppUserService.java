package pl.edu.utp.jobfinder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.utp.jobfinder.model.AppUser;
import pl.edu.utp.jobfinder.repository.AppUserRepository;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Service
@Transactional
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    // Delegate methods
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    public <S extends AppUser> List<S> save(Iterable<S> itrbl) {
        return appUserRepository.save(itrbl);
    }

    public <S extends AppUser> S save(S s) {
        return appUserRepository.save(s);
    }

    public AppUser findOne(Long id) {
        return appUserRepository.findOne(id);
    }

    public AppUser findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    public AppUser findByEmailAndPassword(String email, String password) {
        return appUserRepository.findByEmailAndPassword(email, password);
    }

}
