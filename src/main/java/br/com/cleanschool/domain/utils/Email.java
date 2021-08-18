package br.com.cleanschool.domain.utils;

import br.com.cleanschool.domain.utils.validations.ValidateEmail;

public class Email {
    private String emailAddress;

    public Email(String emailAddress) {
        if (!ValidateEmail.isValidEmail(emailAddress)){
            throw new IllegalArgumentException("Invalid e-mail address.");
        }
        this.emailAddress = emailAddress;
    }
}
