package school;

public class PersonalIdentification {
    private String personalCode;

    public PersonalIdentification(String personalCode) {
        if (personalCode == null ||
                !ValidatePersonalIdentification.validatePersonalIdentification(personalCode)){
            throw new IllegalArgumentException("Invalid personal identification/code.");
        }
        this.personalCode=personalCode;
    }
}
