package se.lexicon.workshop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.workshop.config.ComponentScanConfig;
import se.lexicon.workshop.data_access.StudentDao;
import se.lexicon.workshop.models.Student;
import se.lexicon.workshop.service.StudentManagement;
import se.lexicon.workshop.util.UserInputService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        UserInputService userInputService =context.getBean(UserInputService.class);

//        String string = userInputService.getString();
//
//        System.out.println("string = " + string);

//        int integer = userInputService.getInt();
//
//        System.out.println("integer = " + integer);

//        StudentDao studentDao = context.getBean(StudentDao.class);
//
//        studentDao.save(new Student(1337,"Simon Elbrink"));
//        studentDao.save(new Student(1338,"Erik Svensson"));
//
//        studentDao.findAll().forEach(System.out::println);

        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        studentManagement.create();

        studentManagement.findAll().forEach(System.out::println);


    }
}
