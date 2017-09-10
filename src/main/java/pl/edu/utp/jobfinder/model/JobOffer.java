package pl.edu.utp.jobfinder.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import pl.edu.utp.jobfinder.enumerator.WorkTime;

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
    @Column(length = 1024)
    private String description;
    @Column(nullable = false)
    @ElementCollection(targetClass = String.class)
    private List<String> requirements;
    @ElementCollection(targetClass = String.class)
    private List<String> advantages;
    private String business;
    @Enumerated(EnumType.STRING)
    private WorkTime workTime;
    private boolean isAvailable;

    // Constructors
    public JobOffer() {
    }

    public JobOffer(String position, String company, String city, String description, List<String> requirements, List<String> advantages, String business, WorkTime workTime) {
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

    public void setDate(Date date) {
        this.date = date;
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

    public WorkTime getWorkTime() {
        return workTime;
    }

    public void setWorkTime(WorkTime workTime) {
        this.workTime = workTime;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * To string - returns pretty string of object
     *
     * @return
     */
    @Override
    public String toString() {
        // Create new string for job offer
        StringBuilder jobOffer = new StringBuilder();

        // Job offer header
        jobOffer.append("JOB OFFER\n\n");

        // Job offer primary information
        jobOffer.append("Position: ").append(position).append("\n");
        jobOffer.append("Company: ").append(company).append("\n");
        jobOffer.append("City: ").append(city).append("\n");

        // Job offer date 
        // TODO: Dates in generator
        if (date != null) {
            jobOffer.append("Date: ").append(date).append("\n");
        }

        // Job offer description
        if (description != null && !description.isEmpty()) {
            jobOffer.append("\nDescription: \n").append(description).append("\n");
        }

        // Requirements
        if (requirements != null && !requirements.isEmpty()) {
            jobOffer.append("\nRequirements: \n");
            for (String requirement : requirements) {
                jobOffer.append(requirement).append("\n");
            }
        }

        // Additional advantages
        if (advantages != null && !advantages.isEmpty()) {
            jobOffer.append("\nAdvantagers: \n");
            for (String advantage : advantages) {
                jobOffer.append(advantage).append("\n");
            }
        }

        // Job offer business
        if (business != null && !business.isEmpty()) {
            jobOffer.append("\nBusiness: ").append(business).append("\n");
        }

        // Job offer work time
        if (workTime != null) {
            jobOffer.append("WorkTime: ").append(workTime.getWorkTimeEN()).append("\n");
        }

        // Job offer availability
        jobOffer.append("Available: ").append(isAvailable).append("\n");

        // Return job offer string
        return jobOffer.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.position);
        hash = 61 * hash + Objects.hashCode(this.company);
        hash = 61 * hash + Objects.hashCode(this.city);
        hash = 61 * hash + Objects.hashCode(this.date);
        hash = 61 * hash + Objects.hashCode(this.description);
        hash = 61 * hash + Objects.hashCode(this.requirements);
        hash = 61 * hash + Objects.hashCode(this.advantages);
        hash = 61 * hash + Objects.hashCode(this.business);
        hash = 61 * hash + Objects.hashCode(this.workTime);
        hash = 61 * hash + (this.isAvailable ? 1 : 0);
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
        final JobOffer other = (JobOffer) obj;
        if (this.isAvailable != other.isAvailable) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.business, other.business)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.requirements, other.requirements)) {
            return false;
        }
        if (!Objects.equals(this.advantages, other.advantages)) {
            return false;
        }
        if (this.workTime != other.workTime) {
            return false;
        }
        return true;
    }

    
    
}
