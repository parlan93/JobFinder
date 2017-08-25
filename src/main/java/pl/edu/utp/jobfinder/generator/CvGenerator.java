/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.utp.jobfinder.generator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pl.edu.utp.jobfinder.enumerator.EducationTitle;
import pl.edu.utp.jobfinder.enumerator.LanguageLevel;
import pl.edu.utp.jobfinder.enumerator.LevelOfEducation;
import pl.edu.utp.jobfinder.enumerator.SkillLevel;
import pl.edu.utp.jobfinder.generator.data.DataValues;
import pl.edu.utp.jobfinder.model.AppUser;
import pl.edu.utp.jobfinder.model.Cv;

/**
 *
 * @author bskibinski
 */
@Service
public class CvGenerator extends AbstractGenerator {

    // Constructors
    public CvGenerator() {
        super();
    }

    /**
     * Generate CVs - generate random CV for every user
     *
     * @param users
     * @return
     */
    public List<Cv> generateCVs(List<AppUser> users) {
        // Create new list of cvs
        List<Cv> cvs = new ArrayList<>();

        // Go through every user in users list
        for (AppUser user : users) {
            // Get user cv
            Cv cv = user.getCv();

            // Generate and set personal information
            cv.setBirthDate(fullDateGenerator());
            cv.setPhone(phoneNumberGenerator());
            cv.setAddress(addressGenerator());

            // Generate and set information about education
            cv.setLevelOfEducation(levelOfEducationGenerator());
            cv.setEducationTitle(educationTitleGenerator());
            int cvNumberOfSchools = random.nextInt(3);
            List<String> cvSchools = new ArrayList<>();
            List<String> cvSubjects = new ArrayList<>();
            List<String> cvEducationDates = new ArrayList<>();
            for (int i = 0; i <= cvNumberOfSchools; i++) {
                cvSchools.add(stringGenerator(DataValues.getSchools()));
                cvSubjects.add(stringGenerator(DataValues.getSubjects()));
                cvEducationDates.add(datesFromToGenerator());
            }
            cv.setSchools(cvSchools);
            cv.setSubjects(cvSubjects);
            cv.setEducationDates(cvEducationDates);

            // Generate and set information about experience
            int cvNumberOfEmployers = random.nextInt(3);
            List<String> cvEmployers = new ArrayList<>();
            List<String> cvPositions = new ArrayList<>();
            List<String> cvExperienceDates = new ArrayList<>();
            for (int i = 0; i < cvNumberOfEmployers; i++) {
                cvEmployers.add(stringGenerator(DataValues.getEmployers()));
                cvPositions.add(stringGenerator(DataValues.getPositions()));
                cvExperienceDates.add(datesFromToGenerator());
            }
            cv.setEmployers(cvEmployers);
            cv.setPositions(cvPositions);
            cv.setExperienceDates(cvExperienceDates);

            // Generate and set information about skills
            int numberOfSkills = random.nextInt(8);
            List<String> cvSkills = new ArrayList<>();
            List<SkillLevel> cvSkillsLevels = new ArrayList<>();
            for (int i = 0; i < numberOfSkills; i++) {
                cvSkills.add(stringGenerator(DataValues.getSkills()));
                cvSkillsLevels.add(skillLevelGenerator());
            }
            cv.setSkills(cvSkills);
            cv.setSkillsLevels(cvSkillsLevels);

            // Generate and set information about languages
            int numberOfLanguages = random.nextInt(5);
            List<String> cvLanguages = new ArrayList<>();
            List<LanguageLevel> cvLanguagesLevels = new ArrayList<>();
            for (int i = 0; i < numberOfLanguages; i++) {
                cvLanguages.add(stringGenerator(DataValues.getLanguages()));
                cvLanguagesLevels.add(languageLevelGenerator());
            }
            cv.setLanguages(cvLanguages);
            cv.setLanguagesLevels(cvLanguagesLevels);

            // Generate and set information about interests
            int numberOfInterests = random.nextInt(12);
            List<String> cvInterests = new ArrayList<>();
            for (int i = 0; i < numberOfInterests; i++) {
                cvInterests.add(stringGenerator(DataValues.getInterests()));
            }
            cv.setInterests(cvInterests);

            // Generate and set about
            int numberOfAboutSentences = random.nextInt(8);
            StringBuilder cvAbout = new StringBuilder();
            for (int i = 0; i < numberOfAboutSentences; i++) {
                int numberOfWordsInSentece = random.nextInt(5) + 3;
                for (int j = 0; j < numberOfWordsInSentece; j++) {
                    String word = stringGenerator(DataValues.getAbout());
                    if (j == 0) {
                        cvAbout.append(word.substring(0, 1).toUpperCase()).append(word.substring(1));
                    } else {
                        cvAbout.append(word);
                    }
                    if ((j + 1) != numberOfWordsInSentece) {
                        cvAbout.append(" ");
                    }
                }
                cvAbout.append(". ");
            }
            cv.setAbout(cvAbout.toString());

            // Add generated information to CV list
            cvs.add(cv);
        }

        // Return CVs
        return cvs;
    }

    /**
     * Phone number generator - generate random phone number with separator
     *
     * @return
     */
    private String phoneNumberGenerator() {
        // Create new string of phone nubmer
        StringBuilder phoneNumber = new StringBuilder();

        // Generate 3 parts of number with separator
        for (int i = 0; i < 3; i++) {
            // Append 3 first numbers of phone number
            if (i == 0) {
                // Append value of first number part which must be higher than 100
                phoneNumber.append(random.nextInt(900) + 100);
            } else {
                // Generate random value
                int phoneNumberPart = random.nextInt(1000);
                // Check that number is lower than 10
                if (phoneNumberPart < 10) {
                    // Append 2 zeros and phone number part
                    phoneNumber.append("00").append(phoneNumberPart);
                    // Check that number is lower than 100
                } else if (phoneNumberPart < 100) {
                    // Append zero and phone number part
                    phoneNumber.append("0").append(phoneNumberPart);
                } else {
                    // Add phone number part
                    phoneNumber.append(phoneNumberPart);
                }
            }
            // Check which number part is generate now
            if (i < 2) {
                // Append "-" separator if part is different than last
                phoneNumber.append("-");
            }
        }

        // Return random phone number
        return phoneNumber.toString();
    }

    /**
     * Address Generator - generate random address based on list of streets,
     * cities and random numbers
     *
     * @return
     */
    private String addressGenerator() {
        // Create new address
        StringBuilder address = new StringBuilder();

        // Append random street name
        address.append(stringGenerator(DataValues.getStreetNames())).append(";");
        // Append random building number
        address.append(random.nextInt(150)).append(";");
        // Append random local number
        address.append(random.nextInt(150)).append(";");

        // Append random postal code
        int postCodePart;
        postCodePart = random.nextInt(100);
        if (postCodePart < 10) {
            address.append("0").append(postCodePart).append("-");
        } else {
            address.append(postCodePart).append("-");
        }
        postCodePart = random.nextInt(1000);
        if (postCodePart < 10) {
            address.append("00").append(postCodePart).append(";");
        } else if (postCodePart < 100) {
            address.append("0").append(postCodePart).append(";");
        } else {
            address.append(postCodePart).append(";");
        }

        // Append random city
        address.append(stringGenerator(DataValues.getCities()));

        // Return address
        return address.toString();
    }

    /**
     * Level of education generator - return random value of LevelOfEducation
     * enum
     *
     * @return
     */
    private LevelOfEducation levelOfEducationGenerator() {
        return LevelOfEducation.values()[random.nextInt(LevelOfEducation.values().length)];
    }

    /**
     * Education title generator - return random value of EducationTitle enum
     *
     * @return
     */
    private EducationTitle educationTitleGenerator() {
        return EducationTitle.values()[random.nextInt(EducationTitle.values().length)];
    }

    /**
     * Skill level generator - return random value of SkillLevel enum
     *
     * @return
     */
    private SkillLevel skillLevelGenerator() {
        return SkillLevel.values()[random.nextInt(SkillLevel.values().length)];
    }

    /**
     * Language level generator - retun random value of LanguageLevel enum
     *
     * @return
     */
    private LanguageLevel languageLevelGenerator() {
        return LanguageLevel.values()[random.nextInt(LanguageLevel.values().length)];
    }

}
