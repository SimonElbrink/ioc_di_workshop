package se.lexicon.workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.workshop.data_access.StudentDao;
import se.lexicon.workshop.models.Student;
import se.lexicon.workshop.util.UserInputService;

import java.util.Arrays;
import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement{

    UserInputService userInputService;
    StudentDao studentDao;


//    /**
//     * Used for Injecting userInputService and studentDao.
//     * @param userInputService
//     * @param studentDao
//     */
//    @Autowired // Constructor injection
//    public StudentManagementConsoleImpl(UserInputService userInputService, StudentDao studentDao) {
//        this.userInputService = userInputService;
//        this.studentDao = studentDao;
//    }

    @Autowired // Setter injection
    public void setUserInputService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    @Autowired // Setter injection
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {

        System.out.print("Id: ");
        int id = userInputService.getInt();

        System.out.print("Name: ");
        String name = userInputService.getString();

        return save(new Student(id, name));
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student studentToRemove = find(id);
        studentDao.delete(id);
        return studentToRemove;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {

        if (find(student.getId()) != null){
            studentDao.delete(student.getId());
            studentDao.save(student);
        }
        return student;
    }
}
