package se.lexicon.workshop.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.workshop.models.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao{

    List<Student> storage;

    public StudentDaoImpl() {
        storage = new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        storage.add(student);
        return student;
    }

    @Override
    public Student find(int id) {
        return storage.stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Student> findAll() {
        return storage;
    }

    @Override
    public void delete(int id) {
        storage.remove(find(id));

    }
}
