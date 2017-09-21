package pl.edu.utp.jobfinder.generator.extractor;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bartłomiej Skibiński
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

    public String shortFromDateMonthExtractor(String dates) {
        return shortDateMonthExtractor(dates, true);
    }

    public String shortToDateMonthExtractor(String dates) {
        return shortDateMonthExtractor(dates, false);
    }

    public String shortFromDateYearExtractor(String dates) {
        return shortDateYearExtractor(dates, true);
    }

    public String shortToDateYearExtractor(String dates) {
        return shortDateYearExtractor(dates, false);
    }

    private String shortDateMonthExtractor(String dates, boolean fromDate) {
        String date;
        if (fromDate) {
            date = separateDateFromTo(dates).get(0);
        } else {
            date = separateDateFromTo(dates).get(1);
        }
        StringTokenizer tokenizer = new StringTokenizer(date, "/");
        return tokenizer.nextToken();
    }

    private String shortDateYearExtractor(String dates, boolean fromDate) {
        String date;
        if (fromDate) {
            date = separateDateFromTo(dates).get(0);
        } else {
            date = separateDateFromTo(dates).get(1);
        }
        StringTokenizer tokenizer = new StringTokenizer(date, "/");
        tokenizer.nextToken();
        return tokenizer.nextToken();
    }

    private List<String> separateDateFromTo(String dates) {
        List<String> datesList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(dates, ";");
        String fromDate = tokenizer.nextToken();
        String toDate = tokenizer.nextToken();
        datesList.add(fromDate);
        datesList.add(toDate);
        return datesList;
    }

}
