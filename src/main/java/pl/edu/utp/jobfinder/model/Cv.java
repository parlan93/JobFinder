package pl.edu.utp.jobfinder.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Entity
public class Cv implements Serializable {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    private String birthDate;
    private String phone;
    @Column(nullable = false, unique = true)
    private String email;
    private String address;

    @Enumerated(EnumType.STRING)
    private LevelOfEducation levelOfEducation;
    @Enumerated(EnumType.STRING)
    private EducationTitle educationTitle;
    @ElementCollection(targetClass = String.class)
    private List<String> schools;
    @ElementCollection(targetClass = String.class)
    private List<String> subjects;
    @ElementCollection(targetClass = String.class)
    private List<String> educationDates;

    @ElementCollection(targetClass = String.class)
    private List<String> employers;
    @ElementCollection(targetClass = String.class)
    private List<String> positions;
    @ElementCollection(targetClass = String.class)
    private List<String> experienceDates;

    @ElementCollection(targetClass = String.class)
    private List<String> skills;
    @ElementCollection(targetClass = String.class)
    private List<String> skillsLevels;

    @ElementCollection(targetClass = String.class)
    private List<String> languages;
    @ElementCollection(targetClass = String.class)
    private List<String> languagesLevels;

    @ElementCollection(targetClass = String.class)
    private List<String> interests;
    private String about;

    // Constructors
    public Cv() {
    }

    public Cv(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LevelOfEducation getLevelOfEducation() {
        return levelOfEducation;
    }

    public void setLevelOfEducation(LevelOfEducation levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    public EducationTitle getEducationTitle() {
        return educationTitle;
    }

    public void setEducationTitle(EducationTitle educationTitle) {
        this.educationTitle = educationTitle;
    }

    public List<String> getSchools() {
        return schools;
    }

    public void setSchools(List<String> schools) {
        this.schools = schools;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getEducationDates() {
        return educationDates;
    }

    public void setEducationDates(List<String> educationDates) {
        this.educationDates = educationDates;
    }

    public List<String> getEmployers() {
        return employers;
    }

    public void setEmployers(List<String> employers) {
        this.employers = employers;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public List<String> getExperienceDates() {
        return experienceDates;
    }

    public void setExperienceDates(List<String> experienceDates) {
        this.experienceDates = experienceDates;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getSkillsLevels() {
        return skillsLevels;
    }

    public void setSkillsLevels(List<String> skillsLevels) {
        this.skillsLevels = skillsLevels;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getLanguagesLevels() {
        return languagesLevels;
    }

    public void setLanguagesLevels(List<String> languagesLevels) {
        this.languagesLevels = languagesLevels;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

}
