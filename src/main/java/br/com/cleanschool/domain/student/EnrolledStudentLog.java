package br.com.cleanschool.domain.student;

import java.time.format.DateTimeFormatter;

public class EnrolledStudentLog {

    public void executeWhen(EnrolledStudent event){
        String formattedMoment = event.moment().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.println(String.format("Student with personal identification %s enrolled at: %s",
                event.getStudentPersonalIdentification(),
                formattedMoment));
    }
}
