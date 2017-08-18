package pl.edu.utp.jobfinder.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Entity
public class UserRole implements Serializable {

    // Roles
    public enum Role {
        ROLE_USER,
        ROLE_EMPLOYEE;
    }

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = AppUser.class)
    private AppUser user;
    @Column(nullable = false)
    private Role role;

    // Constructors
    public UserRole() {
    }

    public UserRole(AppUser user, Role role) {
        this.user = user;
        this.role = role;
    }

    public UserRole(AppUser user) {
        this.user = user;
        this.role = Role.ROLE_USER;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
