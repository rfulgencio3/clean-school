package br.com.cleanschool.domain.student;

import br.com.cleanschool.domain.utils.PersonalIdentification;

import java.util.List;

public interface StudentRepository {

    void enroll(Student student);
    Student findByPersonalIdentification(PersonalIdentification personalIdentification);
    List<Student> listEnrolledStudents();
}
