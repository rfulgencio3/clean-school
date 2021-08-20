package br.com.cleanschool.domain.student;

import br.com.cleanschool.domain.utils.Email;
import br.com.cleanschool.domain.utils.PersonalIdentification;

public class StudentBuilder {

    private Student student;

    public StudentBuilder withNamePersonalIdentificationEmail(String name, String personalIdentification, String email){
        this.student = new Student(new PersonalIdentification(personalIdentification), name, new Email(email));
        return this;
    }

    public StudentBuilder withPhone(String phonePrefix, String phone){
        this.student.insertPhone(phonePrefix, phone);
        return this;
    }

    public Student create(){
        return this.student;
    }
}
