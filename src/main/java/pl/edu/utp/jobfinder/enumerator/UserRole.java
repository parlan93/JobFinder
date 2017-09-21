package pl.edu.utp.jobfinder.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum UserRole {

    // Options
    USER("USER", "Użytkownik", "User"),
    EMPLOYEE("EMPLOYEE", "Pracownik", "Employee");

    // Fields
    private final String role;
    private final String rolePL;
    private final String roleEN;

    // Constructor
    private UserRole(String role, String rolePL, String roleEN) {
        this.role = role;
        this.rolePL = rolePL;
        this.roleEN = roleEN;
    }

    // Getters
    public String getRole() {
        return role;
    }
    
    public String getRolePL() {
        return rolePL;
    }

    public String getRoleEN() {
        return roleEN;
    }

}
