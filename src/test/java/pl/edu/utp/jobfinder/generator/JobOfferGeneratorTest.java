package pl.edu.utp.jobfinder.generator;

import org.junit.Test;
import static org.junit.Assert.*;
import pl.edu.utp.jobfinder.enumerator.WorkTime;

/**
 *
 * @author Bartłomiej Skibiński
 */
public class JobOfferGeneratorTest {

    // Fields
    private final JobOfferGenerator jobOfferGenerator = new JobOfferGenerator();
    
    // Constructor
    public JobOfferGeneratorTest() {
    }

    /**
     * generateJobOffersTest
     */
    @Test
    public void generateJobOffersTest() {
        // Given
        int expected = 5;
        
        // When
        int result = jobOfferGenerator.generateJobOffers(5).size();
        
        // Then
        assertEquals(expected, result);
    }

    /**
     * workTimeGeneratorTest
     */
    @Test
    public void workTimeGeneratorTest() {
        // Given
        boolean expected = true;
        
        // When
        boolean result = jobOfferGenerator.generateJobOffers(1).get(0).getWorkTime() instanceof WorkTime;
        
        // Then
        assertEquals(expected, result);
    }

    /**
     * isAvailableGeneratorTest
     */
    @Test
    public void isAvailableGeneratorTest() {
        // Given
        
        // When
        boolean result = jobOfferGenerator.generateJobOffers(1).get(0).getIsAvailable();
        
        // Then
        assertNotNull(result);
    }

}
