package pl.edu.utp.jobfinder.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum LanguageLevel {

    // Options
    A1("A1"),
    A2("A2"),
    B1("B1"),
    B2("B2"),
    C1("C1"),
    C2("C2");

    // Fields
    private String levelLabel;

    // Constructor
    private LanguageLevel(String levelLabel) {
        this.levelLabel = levelLabel;
    }

    // Getter
    public String getLevelLabel() {
        return levelLabel;
    }

}
