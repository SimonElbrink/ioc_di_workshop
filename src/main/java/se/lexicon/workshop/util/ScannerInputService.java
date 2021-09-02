package se.lexicon.workshop.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService{

//    @Autowired // Field Injection
    Scanner scanner;

    @Autowired // Constructor Injection
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    //    @Autowired // Setter Injection
//    public void setScanner(Scanner scanner) {
//        this.scanner = scanner;
//    }

    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        boolean valid = false;
        int number = 0;
        while(!valid) {
            try {
                number = Integer.parseInt(getString().trim());
                valid = true;
            }catch(NumberFormatException e) {
                System.out.println("Input was not a number");
            }
        }
        return number;
    }
}
