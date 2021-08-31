package br.com.cleanschool;

import br.com.cleanschool.application.student.enroll.StudentEnroll;
import br.com.cleanschool.application.student.enroll.StudentEnrollDto;
import br.com.cleanschool.infra.student.StudentRepositoryInMemory;

public class StudentEnrollByCommandLine {

    public static void main(String[] args){
        String name = "Sample Name Surname";
        String personalIdentification = "69743729062";
        String email = "valid@email.com";

        StudentEnroll enroll = new StudentEnroll(new StudentRepositoryInMemory());
        enroll.execute(new StudentEnrollDto(name, personalIdentification, email));

    }
}
