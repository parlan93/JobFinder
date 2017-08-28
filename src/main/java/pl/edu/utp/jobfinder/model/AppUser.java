package pl.edu.utp.jobfinder.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import pl.edu.utp.jobfinder.enumerator.UserRole;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Entity
public class AppUser implements Serializable {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
//    @OneToOne(fetch = FetchType.EAGER, targetEntity = Cv.class, cascade = {CascadeType.MERGE})
    @OneToOne
    @JoinColumn
    // TODO : Cv Annotation
    private Cv cv;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    // Constructors
    public AppUser() {
    }

    public AppUser(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.cv = new Cv(firstname, lastname, email);
        this.role = UserRole.USER;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    // To String
    @Override
    public String toString() {
        // Create user application string
        StringBuilder appUser = new StringBuilder();

        // Append user information
        appUser.append("Application User: ").append(firstname).append(" ").append(lastname).append("\n\n");
        appUser.append("E-mail: ").append(email).append("\n");
        appUser.append("Password: ").append(password).append("\n");
        appUser.append("Role: ").append(role.getRoleEN()).append("\n");

        // Return user application string
        return appUser.toString();
    }

}
