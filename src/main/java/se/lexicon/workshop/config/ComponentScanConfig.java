package se.lexicon.workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.workshop.util.ScannerInputService;
import se.lexicon.workshop.util.UserInputService;

import java.util.Scanner;

@Configuration
@ComponentScan("se.lexicon.workshop.*")
public class ComponentScanConfig {

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }

}
