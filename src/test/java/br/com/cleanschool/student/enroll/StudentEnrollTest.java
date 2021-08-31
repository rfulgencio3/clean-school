package br.com.cleanschool.student.enroll;

import br.com.cleanschool.application.student.enroll.StudentEnroll;
import br.com.cleanschool.application.student.enroll.StudentEnrollDto;
import br.com.cleanschool.domain.student.Student;
import br.com.cleanschool.domain.utils.PersonalIdentification;
import br.com.cleanschool.infra.student.StudentRepositoryInMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentEnrollTest {

    @Test
    void StudentMusBePersisted(){
        StudentRepositoryInMemory repository = new StudentRepositoryInMemory();
        StudentEnroll studentEnroll = new StudentEnroll(repository);

        StudentEnrollDto studentEnrollDto = new StudentEnrollDto(
                "Sample Name",
                "11340299003",
                "valid@email.com");
        studentEnroll.execute(studentEnrollDto);

        Student findStudent = repository.findByPersonalIdentification(new PersonalIdentification("11340299003"));

        assertEquals("Sample Name", findStudent.getName());
        assertEquals("11340299003", findStudent.getPersonalIdentification());
        assertEquals("valid@email.com", findStudent.getEmail());
    }
}
