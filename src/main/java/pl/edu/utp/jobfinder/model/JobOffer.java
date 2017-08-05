package pl.edu.utp.jobfinder.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Entity
public class JobOffer implements Serializable {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String position;
    @Column(nullable = false)
    private String company;
    @Column(nullable = false)
    private String city;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;
    @Column(nullable = false)
    @ElementCollection
    private List<String> requirements;
    @ElementCollection
    private List<String> advantages;
    private String business;
    private String workTime;
    private boolean isAvailable;

    // Constructors
    public JobOffer() {
    }

    public JobOffer(String position, String company, String city, String description, List<String> requirements, List<String> advantages, String business, String workTime) {
        this.position = position;
        this.company = company;
        this.city = city;
        this.date = new Date();
        this.description = description;
        this.requirements = requirements;
        this.advantages = advantages;
        this.business = business;
        this.workTime = workTime;
        this.isAvailable = true;
    }

    public JobOffer(String position, String company, String city, List<String> requirements) {
        this.position = position;
        this.company = company;
        this.city = city;
        this.date = new Date();
        this.requirements = requirements;
        this.isAvailable = true;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<String> requirements) {
        this.requirements = requirements;
    }

    public List<String> getAdvantages() {
        return advantages;
    }

    public void setAdvantages(List<String> advantages) {
        this.advantages = advantages;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

}
