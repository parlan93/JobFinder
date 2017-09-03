package pl.edu.utp.jobfinder.generator;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Bartłomiej Skibiński
 */
public class AbstractGeneratorTest {

    // Fields
    private final List<String> testValues = Arrays.asList("lorem", "ipsum", "dolor", "sit", "amet");
    private final AppUserGenerator appUserGenerator = new AppUserGenerator();

    // Constructor
    public AbstractGeneratorTest() {
    }

    /**
     * stringGeneratorTest
     */
    @Test
    public void stringGeneratorTest() {
        // Given
        boolean expected = true;

        // When
        boolean result = false;
        String string = appUserGenerator.stringGenerator(testValues);
        for (String testValue : testValues) {
            if (testValue.equals(string)) {
                result = true;
            }
        }

        // Then
        assertEquals(expected, result);
    }

    /**
     * sentenceGeneratorTest
     */
    @Test
    public void sentenceGeneratorTest() {
        // Given
        int expected = 3;

        // When
        int result = appUserGenerator.sentenceGenerator(testValues, 3, 3).split(" ").length;

        // Then
        assertEquals(expected, result);
    }

    /**
     * fullDateGeneratorTest1
     */
    @Test
    public void fullDateGeneratorTest1() {
        // Given
        int expected = 3;

        // When
        int result = appUserGenerator.fullDateGenerator().split("/").length;

        // Then
        assertEquals(expected, result);
    }

    /**
     * fullDateGeneratorTest2
     */
    @Test
    public void fullDateGeneratorTest2() {
        // Given
        boolean expected = true;

        // When
        boolean result = true;
        String[] generatedDateParts = appUserGenerator.fullDateGenerator().split("/");
        for (String generatedDatePart : generatedDateParts) {
            for (Character character : generatedDatePart.toCharArray()) {
                result = Character.isDigit(character);
            }
        }

        // Then
        assertEquals(expected, result);
    }

    /**
     * dateGeneratorTest1
     */
    @Test
    public void dateGeneratorTest1() {
        // Given
        int expected = 2;

        // When
        int result = appUserGenerator.dateGenerator().split("/").length;

        // Then
        assertEquals(expected, result);
    }

    /**
     * dateGeneratorTest2
     */
    @Test
    public void dateGeneratorTest2() {
        // Given
        boolean expected = true;

        // When
        boolean result = true;
        String[] generatedDateParts = appUserGenerator.dateGenerator().split("/");
        for (String generatedDatePart : generatedDateParts) {
            for (Character character : generatedDatePart.toCharArray()) {
                result = Character.isDigit(character);
            }
        }

        // Then
        assertEquals(expected, result);
    }

    /**
     * datesFromToGeneratorTest
     */
    @Test
    public void datesFromToGeneratorTest() {
        // Given
        int expected = 2;

        // When
        int result = appUserGenerator.datesFromToGenerator().split(";").length;

        // Then
        assertEquals(expected, result);
    }

    /**
     * dateObjectGeneratorTest
     */
    @Test
    public void dateObjectGeneratorTest() {
        // Given
        boolean expected = true;

        // When
        boolean result = appUserGenerator.dateObjectGenerator() instanceof Date;

        // Then
        assertEquals(expected, result);
    }

    /**
     * listOfWordsGeneratorTest
     */
    @Test
    public void listOfWordsGeneratorTest() {
        // Given
        int expected = 5;

        // When
        int result = appUserGenerator.listOfWordsGenerator(testValues, 5).size();

        // Then
        assertEquals(expected, result);
    }

    /**
     * listOfSentencesGeneratorTest
     */
    @Test
    public void listOfSentencesGeneratorTest() {
        // Given
        int expected = 5;

        // When
        int result = appUserGenerator.listOfWordsGenerator(testValues, 5).size();

        // Then
        assertEquals(expected, result);
    }

}
