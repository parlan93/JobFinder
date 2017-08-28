package pl.edu.utp.jobfinder.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum LevelOfEducation {

    // Options
    NONE("Brak", "None"),
    ELEMENTARY("Podstawowe", "Elementary"),
    INTERMEDIATE("Gimnazjalne", "Intermediate"),
    VOCATIONAL("Zawodowe", "Vocational"),
    SECONDARY("Średnie", "Secondary"),
    HIGHER("Wyższe", "Higher");

    // Fields
    private final String levelOfEducationPL;
    private final String levelOfEducationEN;

    // Constructors
    private LevelOfEducation(String levelOfEducationPL, String levelOfEducationEN) {
        this.levelOfEducationPL = levelOfEducationPL;
        this.levelOfEducationEN = levelOfEducationEN;
    }

    // Getter
    public String getLevelOfEducationPL() {
        return levelOfEducationPL;
    }

    public String getLevelOfEducationEN() {
        return levelOfEducationEN;
    }

}
