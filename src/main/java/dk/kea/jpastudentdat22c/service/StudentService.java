package dk.kea.jpastudentdat22c.service;

import dk.kea.jpastudentdat22c.dto.StudentConverter;
import dk.kea.jpastudentdat22c.dto.StudentDTO;
import dk.kea.jpastudentdat22c.exeption.StudentNotFoundExeption;
import dk.kea.jpastudentdat22c.model.Student;
import dk.kea.jpastudentdat22c.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentService;
    private final StudentConverter studentConverter;

    @Autowired
    public StudentService(StudentRepository studentService,
                          StudentConverter studentConverter){
        this.studentService = studentService;
        this.studentConverter = studentConverter;

    }

    public List<StudentDTO> getAllStudents(){
        List<Student> students = studentService.findAll();
        return  students.stream()
                .map(studentConverter::toDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(int id){
        Optional<Student> studentOptional = studentService.findById(id);
        if (studentOptional.isPresent()){
            return studentConverter.toDTO(studentOptional.get());
        } else {
            throw new StudentNotFoundExeption("Student not found by id: " + id);

        }
    }


    public StudentDTO createStudent(StudentDTO studentDTO){
        Student studentToSave = studentConverter.toEntity(studentDTO);
        // Sæt ID til 0
        studentToSave.setId(0);
        // Gem studentToSave i studentRepository
        Student savedStudent = studentService.save(studentToSave);
        return studentConverter.toDTO(savedStudent);
    }


    public StudentDTO updateStudent(int id, StudentDTO studentDTO){
        Optional<Student> existingStudent = studentService.findById(id);
        if (existingStudent.isPresent()){
            Student studentToUpdate = studentConverter.toEntity(studentDTO);
            //Ensure it's the id from the path that is updated
            studentToUpdate.setId(id);
            Student savedStudent = studentService.save(studentToUpdate);
            return studentConverter.toDTO(savedStudent);
        } else {
            throw new StudentNotFoundExeption("Student not found by id: " + id);
        }
    }

    public void deleteStudentById(int id){
        Optional<Student> studentOptional = studentService.findById(id);
        if (studentOptional.isPresent()){
            studentService.deleteById(id);
        } else {
            throw new StudentNotFoundExeption("Student not found by id: " + id);
        }
    }


}
