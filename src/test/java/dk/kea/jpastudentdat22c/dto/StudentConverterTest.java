package dk.kea.jpastudentdat22c.dto;

import dk.kea.jpastudentdat22c.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentConverterTest {

    @Autowired
    StudentConverter studentConverter;

    StudentDTO studentDTOTest = new StudentDTO(42, "Naja", LocalDate.of(1444, 9, 14),
            LocalTime.of(12,54, 17));

    Student studentTest = new Student(42, "Naja", LocalDate.of(1444, 9, 14),
            LocalTime.of(12,54, 17));
    @Test
    void toEntityTest(){
        Student resultStudent = studentConverter.toEntity(studentDTOTest);

        assertEquals(studentDTOTest.id(), resultStudent.getId());
    }

    @Test
    void toDTOTest(){
        StudentDTO resultStudentDTO = studentConverter.toDTO(studentTest);

        assertEquals(studentTest.getId(), resultStudentDTO.id());
    }



}