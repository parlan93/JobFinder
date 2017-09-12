package pl.edu.utp.jobfinder.generator;

import org.apache.commons.validator.routines.EmailValidator;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Ignore
public class AppUserGeneratorTest {

    // Fields
    private final AppUserGenerator appUserGenerator = new AppUserGenerator();
    
    // Constructor
    public AppUserGeneratorTest() {
    }

    /**
     * generateAppUsersTest
     */
    @Test
    public void generateAppUsersTest() {
        // Given
        int expected = 5;
        
        // When
        int result = appUserGenerator.generateAppUsers(5).size();
        
        // Then
        assertEquals(expected, result);
    }

    /**
     * emailGeneratorTest
     */
    @Test
    public void emailGeneratorTest() {
        // Given
        boolean expected = true;
        
        // When
        boolean result = EmailValidator.getInstance().isValid(appUserGenerator.generateAppUsers(1).get(0).getEmail());
        
        // Then
        assertEquals(expected, result);
    }

    /**
     * passwordGeneratorTest
     */
    @Test
    public void passwordGeneratorTest() {
        // Given
        int expected = 8;
        
        // When
        int result = appUserGenerator.generateAppUsers(1).get(0).getPassword().length();
        
        // Then
        assertEquals(expected, result);
    }

}
