package br.com.cleanschool.domain;

import br.com.cleanschool.domain.utils.Phone;
import br.com.cleanschool.domain.utils.validations.ValidatePhone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneTest {@Test

void createPhoneWithValidInformation(){
    ValidatePhone validatePhone = new ValidatePhone();
    assertTrue(validatePhone.isValidPhone("34","36611000"));
}

    @Test
    void canNotCreatePhoneWithInvalidInformation(){
        assertThrows(IllegalArgumentException.class,
                () -> new Phone("123","1234567"));
    }

    @Test
    void canNotCreatePhoneWithNoInformation(){
        assertThrows(IllegalArgumentException.class,
                () -> new Phone("",""));
    }

    @Test
    void canNotCreatePhoneWithNullInformation(){
        assertThrows(IllegalArgumentException.class,
                () -> new Phone(null,null));
    }

    @Test
    void phoneMustReturnWithFormattedInformation(){
        ValidatePhone validatePhone = new ValidatePhone();
        assertEquals("(34) 3661-0000",validatePhone.formatPhone("34","36610000"));
    }

    @Test
    void cellPhoneMustReturnWithFormattedInformation(){
        ValidatePhone validatePhone = new ValidatePhone();
        assertEquals("(34) 98834-0000",validatePhone.formatPhone("34","988340000"));
    }

    @Test
    void exceptionMustBeReturnedForIncorrectPhoneInformation(){
        assertThrows(IllegalArgumentException.class,
                () -> new Phone("123","45678"));
    }
}