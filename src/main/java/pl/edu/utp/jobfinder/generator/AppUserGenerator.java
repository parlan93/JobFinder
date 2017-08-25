package pl.edu.utp.jobfinder.generator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pl.edu.utp.jobfinder.generator.data.DataValues;
import pl.edu.utp.jobfinder.model.AppUser;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Service
public class AppUserGenerator extends AbstractGenerator {

    // Constructors
    public AppUserGenerator() {
        super();
    }

    /**
     * Generate AppUsers - generates given amount of random users
     *
     * @param amount
     * @return
     */
    public List<AppUser> generateAppUsers(int amount) {
        // Create empty user list
        List<AppUser> appUsers = new ArrayList<>();

        // Fill user list with random values
        for (int i = 0; i < amount; i++) {

            // Generate random firstname and lastname
            String firstname = stringGenerator(DataValues.getFirstnames());
            String lastname = stringGenerator(DataValues.getLastnames());

            // Add new user with random values
            appUsers.add(new AppUser(firstname, lastname, emailGenerator(firstname, lastname), passwordGenerator(firstname, lastname)));
        }

        // Return generated users
        return appUsers;
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
        return firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + DataValues.getEmailProviders().get(random.nextInt(DataValues.getEmailProviders().size()));
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

}
