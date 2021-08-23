package br.com.cleanschool.application.student.enroll;

import br.com.cleanschool.domain.student.Student;
import br.com.cleanschool.domain.utils.Email;
import br.com.cleanschool.domain.utils.PersonalIdentification;

public class StudentEnrollDto {

    private String studentName;
    private String studentPersonalCode;
    private String studentEmail;

    public StudentEnrollDto(String studentName, String studentPersonalCode, String studentEmail) {
        this.studentName = studentName;
        this.studentPersonalCode = studentPersonalCode;
        this.studentEmail = studentEmail;
    }

    public Student createStudent() {
        return new Student(new PersonalIdentification(studentPersonalCode), studentName, new Email(studentEmail));
    }
}
