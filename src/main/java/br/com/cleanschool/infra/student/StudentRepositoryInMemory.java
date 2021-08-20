package br.com.cleanschool.infra.student;

import br.com.cleanschool.domain.student.Student;
import br.com.cleanschool.domain.student.StudentRepository;
import br.com.cleanschool.domain.utils.PersonalIdentification;
import br.com.cleanschool.domain.utils.exceptions.CustomExceptions;
import br.com.cleanschool.domain.utils.exceptions.enums.ErrorCodes;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryInMemory implements StudentRepository {

    private List<Student> enrroled = new ArrayList<>();

    @Override
    public void enroll(Student student) {
        this.enrroled.add(student);
    }

    @Override
    public Student findByPersonalIdentification(PersonalIdentification personalIdentification) {
        return this.enrroled.stream()
                .filter(s -> s.getPersonalIdentification().equals(personalIdentification.getPersonalCode()))
                .findFirst()
                .orElseThrow(() -> new CustomExceptions(ErrorCodes.STUDENT_NOT_FOUND, personalIdentification.getPersonalCode()));
    }

    @Override
    public List<Student> listEnrolledStudents() {
        return this.enrroled;
    }
}
