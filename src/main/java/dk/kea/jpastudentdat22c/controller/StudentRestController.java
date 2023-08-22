package dk.kea.jpastudentdat22c.controller;

import dk.kea.jpastudentdat22c.model.Student;
import dk.kea.jpastudentdat22c.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
       List<Student> lst = studentRepository.findAll();

       return lst;

    }

    @GetMapping("/students/{name}")
    public List<Student> getAllStudentsByName(@PathVariable String name){
        return studentRepository.findAllByName(name);
    }

}
