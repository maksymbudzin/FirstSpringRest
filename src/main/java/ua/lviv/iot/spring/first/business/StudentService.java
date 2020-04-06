package ua.lviv.iot.spring.first.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.first.dataaccess.StudentRepository;
import ua.lviv.iot.spring.first.rest.model.Student;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public HttpStatus deleteStudent(Integer id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    public Student getStudent(Integer id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public ResponseEntity<Student> updateStudent(Student student, Integer id) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            Student newStudent = studentRepository.save(student);
            return new ResponseEntity<Student>(newStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    public List<Student> getAllByFirstName(String firstName) {
        return studentRepository.findAllByFirstName(firstName);
    }
}
