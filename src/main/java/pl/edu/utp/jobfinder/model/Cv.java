package pl.edu.utp.jobfinder.model;

import pl.edu.utp.jobfinder.enumerator.LevelOfEducation;
import pl.edu.utp.jobfinder.enumerator.EducationTitle;
import java.io.Serializable;
import java.util.List;
import java.util.StringTokenizer;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import pl.edu.utp.jobfinder.enumerator.LanguageLevel;
import pl.edu.utp.jobfinder.enumerator.SkillLevel;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Entity
public class Cv implements Serializable {

    // Fields - Personal information
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

    // Fields - Education
    @Enumerated(EnumType.ORDINAL)
    private LevelOfEducation levelOfEducation;
    @Enumerated(EnumType.ORDINAL)
    private EducationTitle educationTitle;
    @ElementCollection(targetClass = String.class)
    private List<String> schools;
    @ElementCollection(targetClass = String.class)
    private List<String> subjects;
    @ElementCollection(targetClass = String.class)
    private List<String> educationDates;

    // Fields - Experience
    @ElementCollection(targetClass = String.class)
    private List<String> employers;
    @ElementCollection(targetClass = String.class)
    private List<String> positions;
    @ElementCollection(targetClass = String.class)
    private List<String> experienceDates;

    // Fields - Skills
    @ElementCollection(targetClass = String.class)
    private List<String> skills;
    @ElementCollection(targetClass = SkillLevel.class)
    private List<SkillLevel> skillsLevels;

    // Fields - languages
    @ElementCollection(targetClass = String.class)
    private List<String> languages;
    @ElementCollection(targetClass = LanguageLevel.class)
    private List<LanguageLevel> languagesLevels;

    // Fields - Interests and about
    @ElementCollection(targetClass = String.class)
    private List<String> interests;
    @Column(length = 1024)
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

    public List<SkillLevel> getSkillsLevels() {
        return skillsLevels;
    }

    public void setSkillsLevels(List<SkillLevel> skillsLevels) {
        this.skillsLevels = skillsLevels;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<LanguageLevel> getLanguagesLevels() {
        return languagesLevels;
    }

    public void setLanguagesLevels(List<LanguageLevel> languagesLevels) {
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

    /**
     * To string - returns pretty string of object
     * 
     * @return 
     */
    @Override
    public String toString() {
        // Create new CV string
        StringBuilder cv = new StringBuilder();

        // CV header
        cv.append("Curriculum Vitae: ").append(firstname).append(" ").append(lastname).append("\n\n");

        // Personal information - basic
        if (birthDate != null) {
            cv.append("Birthday: ").append(birthDate).append("\n");
        }
        if (phone != null) {
            cv.append("Phone: ").append(phone).append("\n");
        }
        cv.append("Email: ").append(email).append("\n");
        if (address != null) {
            cv.append("Address: ").append(address).append("\n\n");
        }

        // Education information - title and level of education
        if (levelOfEducation != null) {
            cv.append("Level of education: ").append(levelOfEducation.getLevelOfEducationEN()).append("\n");
        }
        if (educationTitle != null) {
            cv.append("Education title: ").append(educationTitle.getTitleEN()).append("\n\n");
        }

        // Education information - Schools
        if (schools != null && !schools.isEmpty()) {
            cv.append("Education");
            for (int i = 1; i <= schools.size(); i++) {
                cv.append("\nSchool ").append(i).append(": ").append(schools.get(i - 1));
                cv.append("\nSubject: ").append(subjects.get(i - 1));
                cv.append("\nDates: ");
                StringTokenizer tokenizer = new StringTokenizer(educationDates.get(i - 1), ";");
                while (tokenizer.hasMoreTokens()) {
                    cv.append(tokenizer.nextToken()).append(" ");
                }
            }
        }

        // Experience information - employers and positions
        if (employers != null && !employers.isEmpty()) {
            cv.append("\n\nExperience");
            for (int i = 1; i <= employers.size(); i++) {
                cv.append("\nEmployee ").append(i).append(": ").append(employers.get(i - 1));
                cv.append("\nPosition: ").append(positions.get(i - 1));
                cv.append("\nDates: ");
                StringTokenizer tokenizer = new StringTokenizer(experienceDates.get(i - 1), ";");
                while (tokenizer.hasMoreTokens()) {
                    cv.append(tokenizer.nextToken()).append(" ");
                }
            }
        }

        // Skills informaction
        if (skills != null && !skills.isEmpty()) {
            cv.append("\n\nSkills\n");
            for (int i = 0; i < skills.size(); i++) {
                cv.append(skills.get(i)).append(" - ").append(skillsLevels.get(i).getSkillLevelEN()).append("\n");
            }
        }

        // Languages information
        if (languages != null && !languages.isEmpty()) {
            cv.append("\nLanguages\n");
            for (int i = 0; i < languages.size(); i++) {
                cv.append(languages.get(i)).append(" - ").append(languagesLevels.get(i).getLevelLabel()).append("\n");
            }
        }

        // Interests information
        if (interests != null && !interests.isEmpty()) {
            cv.append("\nInterests\n");
            for (int i = 0; i < interests.size(); i++) {
                cv.append(interests.get(i)).append(" ");
            }
        }

        // About information
        if (about != null) {
            cv.append("\n\nAbout: ").append(about).append("\n\n");
        }

        // Return CV string
        return cv.toString();
    }

}
