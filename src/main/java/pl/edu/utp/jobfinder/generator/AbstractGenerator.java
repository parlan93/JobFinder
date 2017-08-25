package pl.edu.utp.jobfinder.generator;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import pl.edu.utp.jobfinder.generator.data.DataValues;

/**
 *
 * @author Bartłomiej Skibiński
 */
public abstract class AbstractGenerator {

    protected final Random random;

    protected AbstractGenerator() {
        this.random = new Random();
    }

    /**
     * String generator - extract random value of list
     *
     * @param values
     * @return
     */
    protected String stringGenerator(List<String> values) {
        // Check that values list is empty or not
        if (values.isEmpty()) {
            // If values list is empty return empty string
            return "";
        }
        // Return random value of values list
        return values.get(random.nextInt(values.size()));
    }

    /**
     * Full date generator - generate random date from year range (1950, 1995)
     *
     * @return
     */
    protected String fullDateGenerator() {
        return fullDateGenerator(1950, 1995);
    }

    /**
     * Full date generator - generate random date from year range
     *
     * @param yearFrom
     * @param yearTo
     * @return
     */
    protected String fullDateGenerator(int yearFrom, int yearTo) {
        // Create random gregorian calendar
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(gregorianCalendar.YEAR, random.nextInt(yearTo - yearFrom) + yearFrom);
        gregorianCalendar.set(gregorianCalendar.DAY_OF_YEAR, random.nextInt(gregorianCalendar.getActualMaximum(gregorianCalendar.DAY_OF_YEAR)));

        // Create and return string from gregorian calendar
        StringBuilder date = new StringBuilder();
        return date
                .append(gregorianCalendar.get(gregorianCalendar.DAY_OF_MONTH))
                .append("/").append(gregorianCalendar.get(gregorianCalendar.MONTH))
                .append("/").append(gregorianCalendar.get(gregorianCalendar.YEAR))
                .toString();
    }

    /**
     * Date generator - generate random MM/YYYY date from range (1980, 2010)
     *
     * @return
     */
    protected String dateGenerator() {
        return dateGenerator(1980, 2010);
    }

    /**
     * Date generator - generate random MM/YYYY date from range (yearFrom,
     * yearTo)
     *
     * @param yearFrom
     * @param yearTo
     * @return
     */
    protected String dateGenerator(int yearFrom, int yearTo) {
        // Create random gregorian calendar
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(gregorianCalendar.YEAR, random.nextInt(yearTo - yearFrom) + yearFrom);
        gregorianCalendar.set(gregorianCalendar.MONTH, random.nextInt(12));

        // Create and return string from gregorian calendar
        StringBuilder date = new StringBuilder();
        return date
                .append(gregorianCalendar.get(gregorianCalendar.MONTH))
                .append("/")
                .append(gregorianCalendar.get(gregorianCalendar.YEAR))
                .toString();
    }

    /**
     * Dates from to generator - return two dates separated by ";"
     *
     * @return
     */
    protected String datesFromToGenerator() {
        return new StringBuilder(dateGenerator() + ";" + dateGenerator()).toString();
    }

    /**
     * Description generator - generate and returns random number of sentences
     * with random number of words
     *
     * @return
     */
    protected String descriptionsGenerator() {
        // Get random number of sentences
        int numberOfSentences = random.nextInt(8);
        // Create new description
        StringBuilder description = new StringBuilder();

        // Generate sentences
        for (int i = 0; i < numberOfSentences; i++) {
            // Get random number of words in each sentence
            int numberOfWords = random.nextInt(5) + 3;

            // Generate words
            for (int j = 0; j < numberOfWords; j++) {
                // Get random word
                String word = stringGenerator(DataValues.getWords());
                // Check that this word is first in sentence
                if (j == 0) {
                    // Edit first letter of word to uppercase
                    description.append(word.substring(0, 1)).append(word.substring(1));
                } else {
                    description.append(word);
                }
                // Check that this word is not last in sentence
                if ((j + 1) != numberOfWords) {
                    description.append(" ");
                }
            }
            // Add dot in the end of sentence
            description.append(". ");
        }

        // Return description
        return description.toString();
    }

    /**
     * List of strings generator - generate simple list of random string based
     * on declared data source
     *
     * @param dataSource
     * @param amount
     * @return
     */
    protected List<String> listOfStringsGenerator(List<String> dataSource, int amount) {
        // Create new list of strings
        List<String> list = new ArrayList<>();

        // Generate list
        for (int i = 0; i < amount; i++) {
            list.add(stringGenerator(dataSource));
        }

        // Return list of strings
        return list;
    }

}
