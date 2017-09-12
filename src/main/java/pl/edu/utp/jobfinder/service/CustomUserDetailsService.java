package pl.edu.utp.jobfinder.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.utp.jobfinder.model.AppUser;
import pl.edu.utp.jobfinder.model.UserProfile;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    AppUserService appUserService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        AppUser appUser = appUserService.findByEmail(userEmail);
        System.out.println("USER: " + appUser);
        if (appUser == null) {
            System.out.println("USER NOT FOUND");
            throw new UsernameNotFoundException("User email not found!");
        }
        return new User(appUser.getEmail(), appUser.getPassword(), true, true, true, true, getGrantedAuthorities(appUser));
    }

    private List<GrantedAuthority> getGrantedAuthorities(AppUser appUser) {
        List<GrantedAuthority> authorities = new ArrayList<>();

//        for (UserProfile userProfie : appUser.getUserProfiles()) {
//            System.out.println("User profile: " + userProfie);
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfie.getType()));
//        }

        UserProfile userProfile = appUser.getUserProfile();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));

        System.out.println("Authorities: " + authorities);
        return authorities;
    }

}
