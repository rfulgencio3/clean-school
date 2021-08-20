package br.com.cleanschool.domain.utils.validations;

import br.com.cleanschool.domain.utils.exceptions.CustomExceptions;
import br.com.cleanschool.domain.utils.exceptions.enums.ErrorCodes;

public class ValidatePhone {
    public static boolean isValidPhone(String phonePrefix, String phoneNumber) {
        if (phonePrefix.length() == 2 && (phoneNumber.length() >= 8 || phoneNumber.length() <= 9)){
            return true;
        }
        return false;
    }

    public static String formatPhone(String phonePrefix, String phoneNumber) {
        if (phonePrefix.length() == 2 && phoneNumber.length() == 8){
        return("(" + phonePrefix.substring(0, 2) + ")" + " " + phoneNumber.substring(0, 4) + "-" +
                phoneNumber.substring(4, 8));
        }
        else if (phonePrefix.length() == 2 && phoneNumber.length() == 9){
        return("(" + phonePrefix.substring(0, 2) + ")" + " " + phoneNumber.substring(0, 5) + "-" +
                    phoneNumber.substring(5, 9));
        }
        throw new CustomExceptions(ErrorCodes.INVALID_PHONE_NUMBER_FORMAT, "Invalid phone number format");
    }
}
