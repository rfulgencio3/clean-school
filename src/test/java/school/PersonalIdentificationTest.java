package school;

import org.junit.jupiter.api.Test;
import school.validations.ValidateEmail;
import school.validations.ValidatePersonalIdentification;

import static org.junit.jupiter.api.Assertions.*;

public class PersonalIdentificationTest {

    @Test
    void createPersonalIdentificationWithValidInformation(){
        ValidatePersonalIdentification validatePersonalIdentification = new ValidatePersonalIdentification();
        assertTrue(validatePersonalIdentification.isValidPersonalIdentification("08306764064"));
    }

    @Test
    void canNotCreatePersonalIdentificationWithInvalidInformation(){
        assertThrows(IllegalArgumentException.class,
                () -> new PersonalIdentification("454998956542"));
    }

    @Test
    void canNotCreatePersonalIdentificationWithNoInformation(){
        assertThrows(IllegalArgumentException.class,
                () -> new PersonalIdentification(""));
    }

    @Test
    void canNotCreatePersonalIdentificationWithNullInformation(){
        assertThrows(IllegalArgumentException.class,
                () -> new PersonalIdentification(null));
    }

    @Test
    void personalIdentificationMustReturnWithFormattedInformation(){
        ValidatePersonalIdentification validatePersonalIdentification = new ValidatePersonalIdentification();
        assertEquals("083.067.640-64",validatePersonalIdentification.formatPersonalIdentification("08306764064"));
    }
}
