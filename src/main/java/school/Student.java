package school;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private PersonalIdentification personalIdentification;
    private String name;
    private Email email;
    private List<Phone> phones = new ArrayList<>();

    public void insertPhone(String phonePrefix, String phoneNumber){
        this.phones.add(new Phone(phonePrefix, phoneNumber));
    }
}
