/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.utp.jobfinder.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum EducationTitle {

    // Options
    NONE("Brak", "None"),
    BACHELOR("Licencjat", "Bachelor"),
    ENGINEER("Inżynier", "Engineer"),
    MASTER("Magister", "Master"),
    DOCTOR("Doktor", "Doctor"),
    PROFESSOR("Profesor", "Professor");

    // Fields
    private final String titlePL;
    private final String titleEN;

    // Constructors
    private EducationTitle(String titlePL, String titleEN) {
        this.titlePL = titlePL;
        this.titleEN = titleEN;
    }

    // Getter
    public String getTitlePL() {
        return titlePL;
    }

    public String getTitleEN() {
        return titleEN;
    }

}
