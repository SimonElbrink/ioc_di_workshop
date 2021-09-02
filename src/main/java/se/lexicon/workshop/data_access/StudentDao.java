package se.lexicon.workshop.data_access;

import se.lexicon.workshop.models.Student;

import java.util.Collection;

public interface StudentDao {

    Student save(Student student);
    Student find(int id);
    Collection<Student> findAll();
    void delete(int id);

}
