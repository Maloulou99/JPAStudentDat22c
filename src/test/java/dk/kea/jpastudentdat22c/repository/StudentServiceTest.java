package dk.kea.jpastudentdat22c.repository;

import dk.kea.jpastudentdat22c.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentServiceTest {

    @Autowired
    StudentRepository studentService;

    @BeforeEach
    void init(){
        Student s1 = new Student(42, "Tim", LocalDate.of(1999,12,24),
                LocalTime.of(20, 13,12));
        Student s2 = new Student(42, "The Beast", LocalDate.of(1999,12,24),
                LocalTime.of(20, 13,12));

        studentService.save(s1);
        studentService.save(s2);
    }

    @Test
    void findByNameTest(){
        List<Student> studentList = studentService.findAllByName("Tim");
        assertEquals(1, studentList.size());

    }

    @Test
    void findAllByNameTest() {
        List<Student> studentList = studentService.findAll();

        assertEquals(2, studentList.size());
        assertThat(studentList, containsInAnyOrder(hasProperty("name", is("The Beast")),
                hasProperty("name", is("Tim"))));
    }


}