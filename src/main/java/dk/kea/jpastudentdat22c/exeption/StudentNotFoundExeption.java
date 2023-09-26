package dk.kea.jpastudentdat22c.exeption;

public class StudentNotFoundExeption extends RuntimeException {
    public StudentNotFoundExeption(String message) {
        super(message);
    }
}
