package org.pierre.worter;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.shell.standard.ShellMethod;
//import org.springframework.shell.standard.ShellComponent;

//@ShellComponent
public class WorterShell {
    @Autowired
    WordRepository wordRepository;

//    @ShellMethod("print random word")
    public void random() {
        System.out.println(wordRepository.getRandomWord());
    }
}
