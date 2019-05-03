package org.pierre.worter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;


@SpringBootTest(webEnvironment = NONE)
public class WorterApplicationTests {
    @Autowired
    WordManipulator wordManipulator;
    @Autowired
    WordJSONRepository wordRepository;

    @Test
    public void testDerDieDas() {
        assertEquals("der Löffel", wordManipulator.derDieDas("Löffel"));
        assertEquals("das Messer", wordManipulator.derDieDas("Messer"));
        assertEquals("die Gabel", wordManipulator.derDieDas("Gabel"));
    }

}
