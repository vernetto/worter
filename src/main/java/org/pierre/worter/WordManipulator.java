package org.pierre.worter;

import org.pierre.worter.model.DerDieDas;
import org.pierre.worter.model.Type;
import org.pierre.worter.model.Word;
import org.springframework.stereotype.Component;

@Component
public class WordManipulator {
    public String derDieDas(Word word) {
        if (word.getType() != Type.NOUN) {
            throw new IllegalArgumentException(String.format("Type.NOUN  is required for %s", word.toString()));
        }
        return DerDieDas.find(word.getGenre()) + " " + word.getName();
    }
}
