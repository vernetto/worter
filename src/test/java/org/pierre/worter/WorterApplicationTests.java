package org.pierre.worter;

import org.junit.jupiter.api.Test;
import org.pierre.worter.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;


@SpringBootTest(webEnvironment = NONE)
public class WorterApplicationTests {
    @Autowired
    WordManipulator wordManipulator;
    @Autowired
    WordRepository wordRepository;

    @Test
    public void testDerDieDas() {
        Word word = wordRepository.findWord("Löffel").get();
        String result = wordManipulator.derDieDas(word);
        assertEquals("der Löffel", result);
    }

}
