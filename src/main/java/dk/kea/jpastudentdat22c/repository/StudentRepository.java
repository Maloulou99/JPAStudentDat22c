package dk.kea.jpastudentdat22c.repository;

import dk.kea.jpastudentdat22c.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByName(String name); //JPQL


}
