/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.utp.jobfinder.generator;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 *
 * @author bskibinski
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
    
}
