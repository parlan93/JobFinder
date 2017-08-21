/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.utp.jobfinder.model;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum EducationTitle {

    // Options
    NONE("Brak"),
    BACHELOR("Licencjat"),
    ENGINEER("Inżynier"),
    MASTER("Magister"),
    DOCTOR("Doktor"),
    PROFESSOR("Profesor");

    // Fields
    private String title;

    // Constructors
    private EducationTitle(String title) {
        this.title = title;
    }

    // Getter
    public String getTitle() {
        return title;
    }

}
