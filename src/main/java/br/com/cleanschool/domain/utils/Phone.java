package br.com.cleanschool.domain.utils;

import br.com.cleanschool.domain.utils.validations.ValidatePhone;

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

    public String getPhonePrefix() {
        return this.phonePrefix;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}