package br.com.cleanschool.infra.student;

import br.com.cleanschool.domain.utils.exceptions.CustomExceptions;
import br.com.cleanschool.domain.utils.exceptions.enums.ErrorCodes;
import br.com.cleanschool.domain.student.Student;
import br.com.cleanschool.domain.student.StudentRepository;
import br.com.cleanschool.domain.utils.Email;
import br.com.cleanschool.domain.utils.PersonalIdentification;
import br.com.cleanschool.domain.utils.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentContext  implements StudentRepository {

    private final Connection connection;

    public StudentContext(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enroll(Student student) {
        try {
            String sql="INSERT INTO student VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getPersonalIdentification());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.execute();

            sql = "INSERT INTO phone VALUES(?,?)";
            ps = connection.prepareStatement(sql);

            for (Phone phone : student.getPhones()) {
                ps.setString(1, phone.getPhonePrefix());
                ps.setString(2, phone.getPhoneNumber());
                ps.execute();
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findByPersonalIdentification(PersonalIdentification personalIdentification) {
        try{
            String sql = "SELECT id, name, email FROM student WHERE personalIdentification = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, personalIdentification.getPersonalCode());

            ResultSet rs = ps.executeQuery();
            boolean found = rs.next();
            if(!found){
                throw new CustomExceptions(ErrorCodes.STUDENT_NOT_FOUND, "personalIdentification: " + personalIdentification.getPersonalCode());
            }

            String name = rs.getString("name");
            Email email = new Email(rs.getString("email"));
            Student foundedStudent = new Student(personalIdentification, name, email);

            Long id = rs.getLong("id");
            sql = "SELECT phone_prefix, phone_number FROM phone where student_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                String phonePrefix = rs.getString("phone_prefix");
                String phoneNumber = rs.getString("phone_number");
                foundedStudent.insertPhone(phonePrefix,phoneNumber);
            }
            return foundedStudent;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Student> listEnrolledStudents() {
        try{
            String sql = "SELECT id, personal_identificatiom name, email FROM student";
            PreparedStatement psStudent = connection.prepareStatement(sql);
            ResultSet rsStudent = psStudent.executeQuery();
            List<Student> students = new ArrayList<>();

            while (rsStudent.next()){
                PersonalIdentification personalIdentification = new PersonalIdentification(rsStudent.getString("personal_identification"));
                String name = rsStudent.getString("name");
                Email email = new Email(rsStudent.getString("email"));
                Student student = new Student(personalIdentification, name, email);

                Long id = rsStudent.getLong("id");
                sql = "SELECT phone_prefyx, phone_number FROM phone WHERE student_id = ?";
                PreparedStatement psPhone = connection.prepareStatement(sql);
                psPhone.setLong(1, id);
                ResultSet rsPhone = psPhone.executeQuery();

                while (rsPhone.next()){
                    String phonePrefix = rsPhone.getString("phone_prefix");
                    String phoneNumber = rsPhone.getString("phone_number");
                    student.insertPhone(phonePrefix,phoneNumber);
                    }
                students.add(student);
                }
            return students;
            } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
