/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.utp.jobfinder.generator.extractor;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.springframework.stereotype.Component;

/**
 *
 * @author bskibinski
 */
@Component
public class DataExtractor {

    public String birthDateDayExtractor(String birthDate) {
        StringTokenizer st = new StringTokenizer(birthDate, "/");
        return st.nextToken();
    }

    public String birthDateMonthExtractor(String birthDate) {
        StringTokenizer st = new StringTokenizer(birthDate, "/");
        st.nextToken();
        return st.nextToken();
    }

    public String birthDateYearExtractor(String birthDate) {
        StringTokenizer st = new StringTokenizer(birthDate, "/");
        st.nextToken();
        st.nextToken();
        return st.nextToken();
    }

    public String addressStreetExtractor(String address) {
        StringTokenizer st = new StringTokenizer(address, ";");
        return st.nextToken();
    }

    public String addressNrExtractor(String address) {
        StringTokenizer st = new StringTokenizer(address, ";");
        st.nextToken();
        return st.nextToken();
    }

    public String addressFlatExtractor(String address) {
        StringTokenizer st = new StringTokenizer(address, ";");
        st.nextToken();
        st.nextToken();
        return st.nextToken();
    }

    public String addressPostCodeExtractor(String address) {
        StringTokenizer st = new StringTokenizer(address, ";");
        st.nextToken();
        st.nextToken();
        st.nextToken();
        return st.nextToken();
    }

    public String addressCityExtractor(String address) {
        StringTokenizer st = new StringTokenizer(address, ";");
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        return st.nextToken();
    }

    public List<String> educationBeginningDateMonthsExtractor(List<String> dates) {
        List<String> returnDates = new ArrayList<>();
        for (String date : dates) {
            StringTokenizer st = new StringTokenizer(date, ";");
            String beginning = st.nextToken();
            StringTokenizer tokenizer = new StringTokenizer(beginning, "/");
            returnDates.add(tokenizer.nextToken());
        }
        return returnDates;
    }

    public List<String> educationEndDateMonthsExtractor(List<String> dates) {
        List<String> returnDates = new ArrayList<>();
        for (String date : dates) {
            StringTokenizer st = new StringTokenizer(date, ";");
            st.nextToken();
            String end = st.nextToken();
            StringTokenizer tokenizer = new StringTokenizer(end, "/");
            returnDates.add(tokenizer.nextToken());
        }
        return returnDates;
    }

    public List<String> educationBeginningDateYearsExtractor(List<String> dates) {
        List<String> returnDates = new ArrayList<>();
        for (String date : dates) {
            StringTokenizer st = new StringTokenizer(date, ";");
            String beginning = st.nextToken();
            StringTokenizer tokenizer = new StringTokenizer(beginning, "/");
            tokenizer.nextToken();
            returnDates.add(tokenizer.nextToken());
        }
        return returnDates;
    }

    public List<String> educationEndDateYearsExtractor(List<String> dates) {
        List<String> returnDates = new ArrayList<>();
        for (String date : dates) {
            StringTokenizer st = new StringTokenizer(date, ";");
            st.nextToken();
            String end = st.nextToken();
            StringTokenizer tokenizer = new StringTokenizer(end, "/");
            tokenizer.nextToken();
            returnDates.add(tokenizer.nextToken());
        }
        return returnDates;
    }

}
