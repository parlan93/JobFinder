package pl.edu.utp.jobfinder.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum ApplyStatus {

    // Options
    NEGATIVE("Negatywny", "Negative"),
    NEUTRAL("Brak", "None"),
    POSITIVE("Pozytywny", "Positive");

    // Fields
    private final String applyStatusPL;
    private final String applyStatusEN;

    // Constructors
    private ApplyStatus(String applyStatusPL, String applyStatusEN) {
        this.applyStatusPL = applyStatusPL;
        this.applyStatusEN = applyStatusEN;
    }

    // Getters
    public String getApplyStatusPL() {
        return applyStatusPL;
    }

    public String getApplyStatusEN() {
        return applyStatusEN;
    }

}
