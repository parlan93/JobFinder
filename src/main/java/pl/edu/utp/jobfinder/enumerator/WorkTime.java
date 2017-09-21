package pl.edu.utp.jobfinder.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum WorkTime {

    // Options
    FULL_TIME("Pełen etat", "Full time"),
    HALF_TIME("Pół etatu", "Half time"),
    NONTRADITIONAL("Niestandardowy wymiar pracy", "Nontraditional employment");

    // Fields
    private final String workTimePL;
    private final String workTimeEN;

    // Constructor
    private WorkTime(String workTimePL, String workTimeEN) {
        this.workTimePL = workTimePL;
        this.workTimeEN = workTimeEN;
    }

    // Getters
    public String getWorkTimePL() {
        return workTimePL;
    }

    public String getWorkTimeEN() {
        return workTimeEN;
    }

}
