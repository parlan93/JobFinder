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
public class Apply implements Serializable {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = JobOffer.class)
    private JobOffer jobOffer;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Cv.class)
    private Cv cv;
    @Column(nullable = false)
    private int isPositive; // 0 - Neutral // -1 - Negative // 1 - Positive

    // Constructors
    public Apply() {
    }

    public Apply(JobOffer jobOffer, Cv cv) {
        this.jobOffer = jobOffer;
        this.cv = cv;
        this.isPositive = 0;
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

    public int getIsPositive() {
        return isPositive;
    }

    public void setIsPositive(int isPositive) {
        this.isPositive = isPositive;
    }

}
