package school;

import school.validations.ValidatePersonalIdentification;

public class PersonalIdentification {
    private String personalCode;

    public PersonalIdentification(String personalCode) {
        if (personalCode == null ||
                !ValidatePersonalIdentification.isValidPersonalIdentification(personalCode)){
            throw new IllegalArgumentException("Invalid personal identification/code.");
        }
        this.personalCode=personalCode;
    }
}
