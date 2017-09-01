package pl.edu.utp.jobfinder.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Entity
public class Message implements Serializable {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 1024)
    private String content;
    @Column(nullable = false)
    private boolean isReaded;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, targetEntity = AppUser.class, optional = false)
    private AppUser user;

    // Constructors
    public Message() {
    }

    public Message(String content, AppUser user) {
        this.content = content;
        this.isReaded = false;
        this.date = new Date();
        this.user = user;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isIsReaded() {
        return isReaded;
    }

    public void setIsReaded(boolean isReaded) {
        this.isReaded = isReaded;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    /**
     * To string - returns pretty string of object
     * 
     * @return 
     */
    @Override
    public String toString() {
        // Create new string for message
        StringBuilder message = new StringBuilder();

        // Message header
        message.append("MESSAGE\n\n");

        // Message content
        if (content != null && !content.isEmpty()) {
            message.append("Content:\n").append(content).append("\n");
        }

        // Message status
        if (isReaded) {
            message.append("READED\n");
        } else {
            message.append("NOT READED\n");
        }
        
        // Message date
        if (date != null) {
            message.append(date).append("\n");
        }

        // Receiver
        message.append("Receiver: ").append(user.getEmail()).append("\n");
        
        // Return message
        return message.toString();
    }

}
