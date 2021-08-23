package br.com.cleanschool.application.student.enroll;

import br.com.cleanschool.domain.student.Student;
import br.com.cleanschool.domain.student.StudentRepository;

public class StudentEnroll {
    private final StudentRepository repository;

    public StudentEnroll(StudentRepository repository) {
        this.repository = repository;
    }

    public void execute(StudentEnrollDto studentEnrollDto){
        Student newStudent = studentEnrollDto.createStudent();
        repository.enroll(newStudent);
    }
}
