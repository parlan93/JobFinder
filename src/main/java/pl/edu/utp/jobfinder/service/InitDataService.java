package pl.edu.utp.jobfinder.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    // Random class to generate values
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

    // TODO : CV Generator
    private List<Cv> generateCVs(List<AppUser> users) {
        List<Cv> cvs = new ArrayList<>();
        boolean sout = true;
        for (AppUser user : users) {
            Cv cv = user.getCv();
            if (sout) {
                System.out.println(cv.toString());
                sout = false;
            }
            cvs.add(cv);
        }

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

    ////////////////////////////////////////////////////////////
    /// Possible data to generate
    ////////////////////////////////////////////////////////////
    List<String> firstnames = Arrays.asList(
            "James", "John", "Robert", "Michael", "William", "David", "Richard", "Charles", "Joseph", "Thomas",
            "Christopher", "Daniel", "Paul", "Mark", "Donald", "George", "Kenneth", "Steven", "Edward", "Brian",
            "Ronald", "Anthony", "Kevin", "Jason", "Matthew", "Mary", "Patricia", "Linda", "Barbara", "Elizabeth",
            "Jennifer", "Maria", "Susan", "Margaret", "Dorothy", "Lisa", "Nancy", "Karen", "Betty", "Hellen",
            "Sandra", "Donna", "Carol", "Ruth", "Sharon", "Michelle", "Laura", "Sarah", "Kimberly", "Deborah"
    );
    List<String> lastnames = Arrays.asList(
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson",
            "Martinez", "Anderson", "Taylor", "Thomas", "Hernandez", "Moore", "Martin", "Jackson", "Thompson", "White",
            "Lopez", "Lee", "Gonzalez", "Harris", "Clark", "Lewis", "Robinson", "Walker", "Perez", "Hull",
            "Young", "Allen", "Sanchez", "Wright", "King", "Scott", "Green", "Baker", "Adams", "Nelson",
            "Hill", "Ramirez", "Campbell", "Mitchell", "Roberts", "Carter", "Phillips", "Evans", "Turner", "Torres"
    );
    List<String> emailProviders = Arrays.asList(
            "aol.com", "atmail.com", "fastmail.com", "gmail.com", "gmx.net",
            "hushmail.com", "icloud.com", "lycos.com", "mail.com", "mail.ru",
            "mailfence.com", "outlook.com", "protonmail.com", "rackspace.com", "rediff.com",
            "runbox.com", "tutanota.com", "yahoo.com", "yandex.com", "zohocorp.com"
    );

}
