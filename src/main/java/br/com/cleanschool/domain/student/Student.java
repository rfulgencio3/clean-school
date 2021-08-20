package br.com.cleanschool.domain.student;

import br.com.cleanschool.domain.utils.Email;
import br.com.cleanschool.domain.utils.PersonalIdentification;
import br.com.cleanschool.domain.utils.Phone;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private PersonalIdentification personalIdentification;
    private String name;
    private Email email;
    private List<Phone> phones = new ArrayList<>();
    private String password;

    public Student(PersonalIdentification personalIdentification, String name, Email email) {
        this.personalIdentification = personalIdentification;
        this.name = name;
        this.email = email;
    }

    public void insertPhone(String phonePrefix, String phoneNumber){
        this.phones.add(new Phone(phonePrefix, phoneNumber));
    }

    public String getPersonalIdentification() {
        return personalIdentification.getPersonalCode();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {

        return email.getEmail();
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
