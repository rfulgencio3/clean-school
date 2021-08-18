package br.com.cleanschool.domain.utils.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidEmail(String emailAddress) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailAddress);
        Boolean validateCharacters =  matcher.find();

        if (!validateCharacters || emailAddress == null){
            return false;
        }
        return true;
    }
}