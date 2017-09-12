package pl.edu.utp.jobfinder.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import pl.edu.utp.jobfinder.enumerator.UserRole;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Entity
public class UserProfile implements Serializable {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 15, unique = true, nullable = false)
    private String type;

    // Constructors
    public UserProfile() {
    }

    public UserProfile(String type) {
        this.type = type;
    }

    // Methods
    public static List<UserProfile> getUserProfiles() {
        List<UserProfile> userProfiles = new ArrayList<>();

        UserRole[] userRoles = UserRole.values();
        for (UserRole userRole : userRoles) {
            userProfiles.add(new UserProfile(userRole.getRole()));
        }

        return userProfiles;
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Equals and hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserProfile other = (UserProfile) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
