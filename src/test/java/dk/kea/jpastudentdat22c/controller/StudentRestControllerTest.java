package dk.kea.jpastudentdat22c.controller;

import dk.kea.jpastudentdat22c.model.Student;
import dk.kea.jpastudentdat22c.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRestControllerTest {

    @Autowired
    StudentRepository studentService;

    @Test
    void testOneTime(){
        List<Student> lst = studentService.findAllByName("kurt");
        assertEquals(1, lst.size());
    }

}