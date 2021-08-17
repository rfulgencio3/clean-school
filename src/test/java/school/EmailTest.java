package school;

import org.junit.jupiter.api.Test;
import school.validations.ValidateEmail;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    void createEmailWithValidEmailAddress(){
        ValidateEmail validateEmail = new ValidateEmail();
        assertTrue(validateEmail.isValidEmail("validemail@valid.com"));
    }

    @Test
    void canNotCreateEmailWithInvalidEmailAddress(){
        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));

        assertThrows(IllegalArgumentException.class,
                () -> new Email("invalidemailaddress"));
    }

    @Test
    void canNotCreateEmailWithNullEmailAddress(){
        assertThrows(NullPointerException.class,
                () -> new Email(null));
    }
}
