package br.com.cleanschool.domain.student;

import br.com.cleanschool.domain.utils.Event;
import br.com.cleanschool.domain.utils.PersonalIdentification;

import java.time.LocalDateTime;

public class EnrolledStudent implements Event {

    private final PersonalIdentification studentPersonalIdentification;
    private final LocalDateTime moment;

    public EnrolledStudent(PersonalIdentification studentPersonalIdentification, LocalDateTime moment) {
        this.studentPersonalIdentification = studentPersonalIdentification;
        this.moment = LocalDateTime.now();
    }

    @Override
    public LocalDateTime moment() {
        return this.moment;
    }

    public PersonalIdentification getStudentPersonalIdentification(){
        return studentPersonalIdentification;
    }
}
