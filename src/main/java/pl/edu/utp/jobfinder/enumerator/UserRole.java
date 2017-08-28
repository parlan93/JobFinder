package pl.edu.utp.jobfinder.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum UserRole {

    // Options
    USER("Użytkownik", "User"),
    EMPLOYEE("Pracownik", "Employee");

    // Fields
    private final String rolePL;
    private final String roleEN;

    // Constructor
    private UserRole(String rolePL, String roleEN) {
        this.rolePL = rolePL;
        this.roleEN = roleEN;
    }

    // Getters
    public String getRolePL() {
        return rolePL;
    }

    public String getRoleEN() {
        return roleEN;
    }

}
