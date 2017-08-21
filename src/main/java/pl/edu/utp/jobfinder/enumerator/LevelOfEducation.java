package pl.edu.utp.jobfinder.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum LevelOfEducation {

    // Options
    NONE("Brak"),
    ELEMENTARY("Podstawowe"),
    INTERMEDIATE("Gimnazjalne"),
    VOCATIONAL("Zawodowe"),
    SECONDARY("Średnie"),
    HIGHER("Wyższe");

    // Fields
    private String name;

    // Constructors
    private LevelOfEducation(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

}
