/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.utp.jobfinder.generator.extractor;

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
    
}
