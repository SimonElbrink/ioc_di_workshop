package se.lexicon.workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.workshop.data_access.StudentDao;
import se.lexicon.workshop.data_access.StudentDaoImpl;
import se.lexicon.workshop.service.StudentManagement;
import se.lexicon.workshop.service.StudentManagementConsoleImpl;
import se.lexicon.workshop.util.ScannerInputService;
import se.lexicon.workshop.util.UserInputService;

import java.util.Scanner;

@Configuration
//@ComponentScan("se.lexicon.workshop.*")
public class ComponentScanConfig {

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }

    @Bean
    public UserInputService userInputService(){
        return new ScannerInputService(scanner());
    }

    @Bean
    public StudentDao studentDao(){
        return new StudentDaoImpl();
    }

    @Bean
    public StudentManagement studentManager(){
        StudentManagementConsoleImpl studentManagementConsole = new StudentManagementConsoleImpl();
        studentManagementConsole.setStudentDao(studentDao());
        studentManagementConsole.setUserInputService(userInputService());
        return studentManagementConsole;
    }

}
