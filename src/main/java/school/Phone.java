package school;

import school.validations.ValidatePersonalIdentification;
import school.validations.ValidatePhone;

public class Phone {

    private String phonePrefix;
    private String phoneNumber;

    public Phone(String phonePrefix, String phoneNumber) {
        if (phonePrefix == null || phoneNumber == null ||
                !ValidatePhone.isValidPhone(phonePrefix, phoneNumber)){
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phonePrefix = phonePrefix;
        this.phoneNumber = phoneNumber;
    }
}
