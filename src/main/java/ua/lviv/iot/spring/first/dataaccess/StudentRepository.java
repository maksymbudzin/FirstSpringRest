package ua.lviv.iot.spring.first.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.spring.first.rest.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>  {

}

