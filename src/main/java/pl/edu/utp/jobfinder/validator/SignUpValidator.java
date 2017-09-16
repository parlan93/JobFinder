package pl.edu.utp.jobfinder.validator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.utp.jobfinder.model.AppUser;
import pl.edu.utp.jobfinder.service.AppUserService;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Component
public class SignUpValidator {

    @Autowired
    private AppUserService appUserService;

    public boolean emailValidation(String email) {
        return checkEmailExisting(email) && isEmailValidate(email);
    }

    public boolean passwordValidation(String password, String repeatedPassword) {
        return password.trim().equals(repeatedPassword.trim()) && checkPasswordLengthCorrectness(password.trim()) && checkPasswordCharactersCorrectness(password.trim());
    }

    private boolean checkEmailExisting(String email) {
        for (AppUser appUser : appUserService.findAll()) {
            if (appUser.getEmail().equals(email.trim().toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    private boolean isEmailValidate(String email) {
        try {
            InternetAddress address = new InternetAddress(email);
            address.validate();
        } catch (AddressException e) {
            return false;
        }
        return true;
    }

    private boolean checkPasswordLengthCorrectness(String password) {
        return password.trim().length() >= 8;
    }

    private boolean checkPasswordCharactersCorrectness(String password) {
        boolean containsDigit = false;
        boolean containsLetters = false;
        for (char c : password.trim().toCharArray()) {
            if (Character.isLetter(c)) {
                containsLetters = true;
            }
            if (Character.isDigit(c)) {
                containsDigit = true;
            }
        }
        return containsLetters && containsDigit;
    }

}
