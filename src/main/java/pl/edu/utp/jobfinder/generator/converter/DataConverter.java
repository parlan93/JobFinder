/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.utp.jobfinder.generator.converter;

import java.util.StringTokenizer;
import org.springframework.stereotype.Component;

/**
 *
 * @author bskibinski
 */
@Component
public class DataConverter {

    public String birthDateConverter(String birthDate) {
        StringBuilder builder = new StringBuilder();

        StringTokenizer tokenizer = new StringTokenizer(birthDate, "/");
        int tokens = tokenizer.countTokens();
        for (int i = 0; i < tokens; i++) {
            String token = tokenizer.nextToken();
            if (i == 1) {
                token = String.valueOf(Integer.valueOf(token) + 1);
            }
            builder.append(token);
            if (tokens - 1 != i) {
                builder.append(".");
            }
        }

        return builder.toString().trim();
    }
    
    public String addressConverter(String address) {
        StringBuilder builder = new StringBuilder();

        StringTokenizer tokenizer = new StringTokenizer(address, ";");
        int tokens = tokenizer.countTokens();
        for (int i = 0; i < tokens; i++) {
            builder.append(tokenizer.nextToken());
            if (i == 1) {
                builder.append("/");
            } else {
                builder.append(" ");
            }
        }

        return builder.toString().trim();
    }

}
