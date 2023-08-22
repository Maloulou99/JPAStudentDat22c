package dk.kea.jpastudentdat22c.config;

import dk.kea.jpastudentdat22c.model.Student;
import dk.kea.jpastudentdat22c.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setName("Sigurd");
        s1.setBornDate(LocalDate.of(2010,11,12));
        s1.setBornTime(LocalTime.of(23, 59, 59));

        studentRepository.save(s1);
        s1.setName("kurt");
        studentRepository.save(s1);
        studentRepository.save(s1);
    }
}
