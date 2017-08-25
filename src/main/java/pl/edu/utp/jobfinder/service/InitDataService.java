package pl.edu.utp.jobfinder.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.utp.jobfinder.enumerator.EducationTitle;
import pl.edu.utp.jobfinder.enumerator.LanguageLevel;
import pl.edu.utp.jobfinder.enumerator.LevelOfEducation;
import pl.edu.utp.jobfinder.enumerator.SkillLevel;
import pl.edu.utp.jobfinder.model.AppUser;
import pl.edu.utp.jobfinder.model.Cv;
import pl.edu.utp.jobfinder.repository.AppUserRepository;
import pl.edu.utp.jobfinder.repository.ApplyRepository;
import pl.edu.utp.jobfinder.repository.CvRepository;
import pl.edu.utp.jobfinder.repository.JobOfferRepository;
import pl.edu.utp.jobfinder.repository.MessageRepository;
import pl.edu.utp.jobfinder.repository.UserRoleRepository;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Service
@Transactional
public class InitDataService {

    // Repositories
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private ApplyRepository applyRepository;
    @Autowired
    private CvRepository cvRepository;
    @Autowired
    private JobOfferRepository jobOfferRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    // Random object to generate values
    Random random = new Random();

    // Constructor
    public InitDataService() {
    }

    /**
     * Init - generate initial data
     */
    @PostConstruct
    public void init() {

        // Delete existing data in database
        deleteExistingData();

        // Generate new data
        List<AppUser> appUsers = generateAppUsers(random.nextInt(50) + 50);
        List<Cv> cvs = generateCVs(appUsers);

    }

    /**
     * Delete existing data in database
     */
    private void deleteExistingData() {
        // Delete data from all repositories
        appUserRepository.deleteAll();
        applyRepository.deleteAll();
        cvRepository.deleteAll();
        jobOfferRepository.deleteAll();
        messageRepository.deleteAll();
        userRoleRepository.deleteAll();
    }

    ////////////////////////////////////////////////////////////
    /// Data generators
    ////////////////////////////////////////////////////////////    
    /**
     * Generate AppUsers - generates given amount of random users
     *
     * @param amount
     * @return
     */
    private List<AppUser> generateAppUsers(int amount) {
        // Create empty user list
        List<AppUser> appUsers = new ArrayList<>();

        // Fill user list with random values
        for (int i = 0; i < amount; i++) {

            // Generate random firstname and lastname
            String firstname = stringGenerator(firstnames);
            String lastname = stringGenerator(lastnames);

            // Add new user with random values
            appUsers.add(new AppUser(firstname, lastname, emailGenerator(firstname, lastname), passwordGenerator(firstname, lastname)));
        }

        // Return generated users
        return appUsers;
    }

    /**
     * Generate CVs - generate random CV for every user
     * 
     * @param users
     * @return 
     */
    private List<Cv> generateCVs(List<AppUser> users) {
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
                cvSchools.add(stringGenerator(schools));
                cvSubjects.add(stringGenerator(subjects));
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
                cvEmployers.add(stringGenerator(employers));
                cvPositions.add(stringGenerator(positions));
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
                cvSkills.add(stringGenerator(skills));
                cvSkillsLevels.add(skillLevelGenerator());
            }
            cv.setSkills(cvSkills);
            cv.setSkillsLevels(cvSkillsLevels);

            // Generate and set information about languages
            int numberOfLanguages = random.nextInt(5);
            List<String> cvLanguages = new ArrayList<>();
            List<LanguageLevel> cvLanguagesLevels = new ArrayList<>();
            for (int i = 0; i < numberOfLanguages; i++) {
                cvLanguages.add(stringGenerator(languages));
                cvLanguagesLevels.add(languageLevelGenerator());
            }
            cv.setLanguages(cvLanguages);
            cv.setLanguagesLevels(cvLanguagesLevels);

            // Generate and set information about interests
            int numberOfInterests = random.nextInt(12);
            List<String> cvInterests = new ArrayList<>();
            for (int i = 0; i < numberOfInterests; i++) {
                cvInterests.add(stringGenerator(interests));
            }
            cv.setInterests(cvInterests);

            // Generate and set about
            int numberOfAboutSentences = random.nextInt(8);
            StringBuilder cvAbout = new StringBuilder();
            for (int i = 0; i < numberOfAboutSentences; i++) {
                int numberOfWordsInSentece = random.nextInt(5) + 3;
                for (int j = 0; j < numberOfWordsInSentece; j++) {
                    String word = stringGenerator(about);
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

    ////////////////////////////////////////////////////////////
    /// Values generators
    ////////////////////////////////////////////////////////////
    /**
     * String generator - extract random value of list
     *
     * @param values
     * @return
     */
    private String stringGenerator(List<String> values) {
        // Check that values list is empty or not
        if (values.isEmpty()) {
            // If values list is empty return empty string
            return "";
        }
        // Return random value of values list
        return values.get(random.nextInt(values.size()));
    }

    /**
     * Email generator - generate email address based on user firstname and
     * lastname
     *
     * @param firstname
     * @param lastname
     * @return
     */
    private String emailGenerator(String firstname, String lastname) {
        // Check that firstname and lastname are empty or not
        if (firstname.isEmpty() || lastname.isEmpty()) {
            // If firstname or lastname is empty return empty string
            return "";
        }
        // Return generated email address
        return firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + emailProviders.get(random.nextInt(emailProviders.size()));
    }

    /**
     * Password generator - generate password based on user firstname and
     * lastname
     *
     * @param firstname
     * @param lastname
     * @return
     */
    private String passwordGenerator(String firstname, String lastname) {
        // Create password
        StringBuilder password = new StringBuilder();

        // Add to password first 3 letters of fistname (if fistname is not empty and is equal or longer than 3 letters)
        if (!firstname.isEmpty() && firstname.length() >= 3) {
            password.append(firstname.substring(0, 3));
        }
        // Add to password first 3 letters of lastname (if lastname is not empty and is equal or longer than 3 letters)
        if (!lastname.isEmpty() && lastname.length() >= 3) {
            password.append(lastname.substring(0, 3));
        }

        // Check current password length
        switch (password.length()) {
            case 0:
                // Add 8 numbers if current set password is empty
                password.append(String.valueOf(random.nextInt(89999999) + 10000000));
                break;
            case 3:
                // Add 5 numbers if current set password size is 3
                password.append(String.valueOf(random.nextInt(89999) + 10000));
                break;
            case 6:
                // Add 2 numbers if current set password size is 6
                password.append(String.valueOf(random.nextInt(89) + 10));
                break;
        }

        // Return generated password
        return password.toString();
    }

    /**
     * Full date generator - generate random date from year range (1950, 1995)
     *
     * @return
     */
    private String fullDateGenerator() {
        return fullDateGenerator(1950, 1995);
    }

    /**
     * Full date generator - generate random date from year range
     *
     * @param yearFrom
     * @param yearTo
     * @return
     */
    private String fullDateGenerator(int yearFrom, int yearTo) {
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
    private String dateGenerator() {
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
    private String dateGenerator(int yearFrom, int yearTo) {
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
        address.append(stringGenerator(streetNames)).append(";");
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
        address.append(stringGenerator(cities));

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
     * Dates from to generator - return two dates separated by ";"
     *
     * @return
     */
    private String datesFromToGenerator() {
        return new StringBuilder(dateGenerator() + ";" + dateGenerator()).toString();
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

    ////////////////////////////////////////////////////////////
    /// Possible data to generate
    ////////////////////////////////////////////////////////////
    List<String> firstnames = Arrays.asList( // 50 (5 x 10)
            "James", "John", "Robert", "Michael", "William", "David", "Richard", "Charles", "Joseph", "Thomas",
            "Christopher", "Daniel", "Paul", "Mark", "Donald", "George", "Kenneth", "Steven", "Edward", "Brian",
            "Ronald", "Anthony", "Kevin", "Jason", "Matthew", "Mary", "Patricia", "Linda", "Barbara", "Elizabeth",
            "Jennifer", "Maria", "Susan", "Margaret", "Dorothy", "Lisa", "Nancy", "Karen", "Betty", "Hellen",
            "Sandra", "Donna", "Carol", "Ruth", "Sharon", "Michelle", "Laura", "Sarah", "Kimberly", "Deborah"
    );
    List<String> lastnames = Arrays.asList( // 50 (5 x 10)
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson",
            "Martinez", "Anderson", "Taylor", "Thomas", "Hernandez", "Moore", "Martin", "Jackson", "Thompson", "White",
            "Lopez", "Lee", "Gonzalez", "Harris", "Clark", "Lewis", "Robinson", "Walker", "Perez", "Hull",
            "Young", "Allen", "Sanchez", "Wright", "King", "Scott", "Green", "Baker", "Adams", "Nelson",
            "Hill", "Ramirez", "Campbell", "Mitchell", "Roberts", "Carter", "Phillips", "Evans", "Turner", "Torres"
    );
    List<String> emailProviders = Arrays.asList( // 20 (4 x 5)
            "aol.com", "atmail.com", "fastmail.com", "gmail.com", "gmx.net",
            "hushmail.com", "icloud.com", "lycos.com", "mail.com", "mail.ru",
            "mailfence.com", "outlook.com", "protonmail.com", "rackspace.com", "rediff.com",
            "runbox.com", "tutanota.com", "yahoo.com", "yandex.com", "zohocorp.com"
    );
    List<String> streetNames = Arrays.asList( // 50 (10 x 5)
            "High Street", "Station Road", "Main Street", "Park Road", "Church Road",
            "Church Street", "London Road", "Victoria Road", "Green Lane", "Manor Road",
            "Church Lane", "Park Avenue", "The Avenue", "The Crescent", "Queens Road",
            "New Road", "Grange Road", "Kings Road", "Kingsway", "Windsor Road",
            "Highfield Road", "Mill Lane", "Alexander Road", "York Road", "St. John's Road",
            "Main Road", "Broadway", "King Street", "The Green", "Springfield Road",
            "Georg Street", "Park Lane", "Victoria Street", "Albert Road", "Queensway",
            "New Street", "Queen Street", "West Street", "North Street", "Manchaster Road",
            "The Groove", "Richmond Road", "Grove Road", "South Street", "School Lane",
            "The Drive", "North Road", "Stanley Road", "Chester Road", "Mill Road"
    );
    List<String> cities = Arrays.asList( // 64 (8 x 8)
            "Aberdeen", "Armagh", "Bangor", "Bath", "Belfast", "Birmingham", "Bradford", "Brighton & Hove",
            "Bristol", "Cambridge", "Canterbury", "Cardiff", "Carlisle", "Chelmsford", "Chester", "Chichester",
            "Coventry", "Derby", "Derry", "Dundee", "Durham", "Edinburgh", "Ely", "Exeter",
            "Glasgow", "Gloucester", "Hereford", "Inverness", "Lancaster", "Leeds", "Leicester", "Winchester",
            "Lichfield", "Lincoln", "Lisborn", "Liverpool", "City of London", "Manchaster", "Newcastle upon Tyne", "Newport",
            "Newry", "Norwich", "Nottingham", "Oxford", "Perth", "Peterborough", "Plymouth", "Portsmouth",
            "Preston", "Ripon", "Salford", "Salisbury", "Sheffield", "Southampton", "Stirling", "Sunderland",
            "Swansea", "Truro", "Wakefield", "Wells", "City of Westminster", "Wolverhampton", "Worcester", "York"
    );
    List<String> schools = Arrays.asList( // 50 (10 x 5)
            "Balliol Lower School", "Christopher Reeves VA Lower School", "The Hills Academy", "Lakeview School", "Shackleton Primary School",
            "Mark Rutherford School", "Bedford Academy", "Beauchamp Middle School", "St Gregory's Roman Catholic Middle School", "Westfield School",
            "Fox Primary School", "St Mary's RC Primary School", "Thomas Jones Primary School", "Chelsea Academy", "Beddington Infants' School",
            "Robin Hood Junior School", "Stanley Park Junior School", "Cheam High School", "Wilson's School", "Sherwood Park School",
            "Hallfield Primary School", "King Solomon Academy", "St Luke's CE Primary School", "Queen's Park Primary School", "Paddington Academy",
            "Westminster Academy", "Queen Elizabeth II Jubilee School", "City of Westminster College", "Westminster Kingsway College", "Albert Bradbeer Primary School",
            "Arden Primary School", "Birches Green Infant School", "Gossey Lane Junior & Infant & Nursery School", "James Watt Primary School", "Wattville Primary School",
            "Cherry Oak School", "James Brindley School", "Victoria School", "Queensbury School", "Birmingham Metropolitan College",
            "Fircroft College", "Joseph Chamberlain Sixth Form College", "Bournville College", "Norfolk House School", "Green Heath School",
            "York College", "Askham Bryan College", "Huntington School", "York High School", "Manor Church of England School"
    );
    List<String> subjects = Arrays.asList( // 80 (10 x 8)
            "Veterinary Medicine", "Farm Management", "Astronomy", "Biology", "Chemistry", "Earth Sciences", "Environmental Sciences", "Food Science and Technology",
            "Physical Geography", "Life Sciences", "Material Sciences", "Mathematics", "Physics", "Sports Science", "Architecture", "Built Environment",
            "Construction", "Planning", "Accounting", "Business Studies", "E-Commerce", "Finance", "Human Resources Management", "Management",
            "Marketing", "Office Administration", "Transportation and Logistics", "Computer Science", "Computing", "IT", "Multimedia", "Software",
            "Art", "Graphic Design", "Interior Design", "Music", "Theatre and Drama Studies", "Adult Education", "Childhood Education", "Pedagogy",
            "Electronic Engineering", "Electrical Engineering", "Mechanical Engineering", "Power and Energy Engineering", "Telecommunications", "Vehicle Engineering", "Massage", "Health and Fitness",
            "Complementary Health", "Dentistry", "Health Studies", "Health and Safety", "Medicine", "Nursing", "Pharmacology", "Physiology",
            "Physiotherapy", "Psychology", "Archaeology", "Cultural Studies", "History", "Languages", "Literature", "Philosophy",
            "Religious Studies", "Civil Law", "Criminal Law", "Public Law", "Economics", "Politics", "Sociology", "Photography",
            "Journalism", "Hotel Management", "Travel and Tourism", "Media", "Linguistics", "International relations", "Legal Advice", "Ophthalmology"
    );
    List<String> employers = Arrays.asList( // 60 (10 x 6)
            "Costco Wholesale", "Google", "REI", "Memorial Hermann Health System", "United Services Automobile Association", "MD Anderson Cancer Center",
            "Penn Medicine", "Mayo Clinic", "City of Austin", "Wegmans Food Markets", "The Container Store", "JetBlue Airways",
            "Facebook", "University of Iowa Hospitals & Clinics", "University of Miami", "Trader Joe's", "QuikTrip", "Winthrop University Hospital",
            "Genentech", "Sandia National Laboratories", "SAS", "Williams", "Coldwell Banker", "The Christ Hospital Health Network",
            "Navy Federal Credit Union", "Four Seasons Hotels and Resorts", "Duke University", "Black & Veatch", "Lee Memorial Health System", "Publix Super Markets",
            "University of Texas Health Science Center at Houston", "WL Gore & Associates", "Intercontinental Hotels Group", "Michelin Group", "Southwest Airlines", "Stater Bros",
            "NASA", "Covenant Health", "H&M", "University of Colorado Health", "H-E-B Grocery Stores", "Promedica",
            "U.S. Courts", "Vanguard", "Sharp HealthCare", "Garmin", "Methodist Le Bonheur Healthcare", "Kimberly-Clark",
            "Partners HealthCare System", "Microsoft", "Houston Methodist", "UCSF Medical Center", "Cargill", "In-N-Out Burger",
            "Montgomery County Public Schools", "Marathon Petroleum", "Yale New Haven Health", "Sikorsky", "Johns Hopkins University", "LinkedIn"
    );
    List<String> positions = Arrays.asList( // 80 (8 x 10)
            "Accountant", "Air Traffic Controller", "Animal Scientist", "Archeologist", "Architect", "Artist", "Astronomer", "Baker", "Barber", "Bartender",
            "Biochemist", "Biologist", "Bus Driver", "Butcher", "Camera Operator", "CEO", "CFO", "Chef", "Chemist", "Child Care",
            "Cleaner of Vehicles", "Copy Writer", "Courier", "Database Administrator", "Dentist", "Designer", "Director Of Marketing", "Economist", "Electrician", "Electronics Engineer",
            "Farmer", "Financial Analyst", "Fire Fighter", "Fraud Investigator", "Funeral Director", "Graphic Designer", "Historian", "House Cleaner", "Housekeeper", "HR Manager",
            "Inspector", "Internist", "Judge", "Lawyer", "Librarian", "Locksmith", "Logistician", "Machinist", "Marketing Manager", "Mathematician",
            "Nuclear Engineer", "Orthodontist", "Painter", "Paralegal", "Pharmacist", "Photographer", "Physician", "Physicist", "Plumber", "Police Detective",
            "PR Manager", "Private Detective and Investigator", "Production Worker", "Project Manager", "Psychiatrist", "Psychologist", "Recruiter", "Safety Engineer", "School Bus Driver", "Secretary",
            "Sheriff", "Singer", "Sociologist", "Stripper", "Teacher", "Telemarketer", "Tour Guide", "Veterinarian", "Waitress", "Webmaster"
    );
    List<String> skills = Arrays.asList( // TODO : skills
            "A", "B", "C"
    );
    List<String> languages = Arrays.asList( // TODO : languages
            "A", "B", "C"
    );
    List<String> interests = Arrays.asList( // TODO : interests
            "A", "B", "C"
    );
    List<String> about = Arrays.asList( // TODO : about
            "lorem", "ipsum", "dolor", "sit", "amet"
    );
}
