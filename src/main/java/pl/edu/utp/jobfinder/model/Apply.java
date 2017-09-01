package pl.edu.utp.jobfinder.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import pl.edu.utp.jobfinder.enumerator.ApplyStatus;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Entity
public class Apply implements Serializable {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = JobOffer.class, fetch = FetchType.EAGER)
    @JoinColumn
    private JobOffer jobOffer;
    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Cv.class, fetch = FetchType.EAGER)
    @JoinColumn
    private Cv cv;
    @Enumerated(EnumType.STRING)
    private ApplyStatus applyStatus;

    // Constructors
    public Apply() {
    }

    public Apply(JobOffer jobOffer, Cv cv) {
        this.jobOffer = jobOffer;
        this.cv = cv;
        this.applyStatus = ApplyStatus.NEUTRAL;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public JobOffer getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOffer jobOffer) {
        this.jobOffer = jobOffer;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    public ApplyStatus getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(ApplyStatus applyStatus) {
        this.applyStatus = applyStatus;
    }

    @Override
    public String toString() {
        StringBuilder apply = new StringBuilder();

        apply.append("Apply\n\n");

        apply.append("Job Offer: ").append(jobOffer.getPosition()).append("\n");
        apply.append("Company: ").append(jobOffer.getCompany()).append("\n");
        apply.append("City: ").append(jobOffer.getCity()).append("\n");
        apply.append("Work Time: ").append(jobOffer.getWorkTime().getWorkTimeEN()).append("\n");
        apply.append("Added: ").append(jobOffer.getDate()).append("\n\n");

        apply.append("Applicant: ").append(cv.getFirstname()).append(" ").append(cv.getLastname()).append("\n");
        apply.append("Birth: ").append(cv.getBirthDate()).append("\n");
        apply.append("Address: ").append(cv.getAddress()).append("\n");
        apply.append("Phone: ").append(cv.getPhone()).append("\n\n");

        apply.append("Status: ").append(applyStatus.getApplyStatusEN()).append("\n");

        return apply.toString();
    }

}
