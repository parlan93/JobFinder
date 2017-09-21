package pl.edu.utp.jobfinder.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum SkillLevel {

    // Options
    ELEMENTARY("Podstawowy", "Elementary"),
    INTERMEDIATE("Średnio-zaawansowany", "Intermediate"),
    ADVANCED("Zaawansowany", "Advanced");

    // Fields
    private final String skillLevelPL;
    private final String skillLevelEN;

    // Constructor
    private SkillLevel(String skillLevelPL, String skillLevelEN) {
        this.skillLevelPL = skillLevelPL;
        this.skillLevelEN = skillLevelEN;
    }

    // Getter
    public String getSkillLevelPL() {
        return skillLevelPL;
    }

    public String getSkillLevelEN() {
        return skillLevelEN;
    }

}
