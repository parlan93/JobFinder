package pl.edu.utp.jobfinder.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum SkillLevel {

    // Options
    ELEMENTARY("Podstawowy"),
    INTERMEDIATE("Średnio-zaawansowany"),
    ADVANCED("Zaawansowany");

    // Fields
    private String skillLevel;

    // Constructor
    private SkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    // Getter
    public String getSkillLevel() {
        return skillLevel;
    }

}
