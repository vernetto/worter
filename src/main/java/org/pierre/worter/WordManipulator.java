package org.pierre.worter;

import org.pierre.worter.model.DerDieDas;
import org.pierre.worter.model.Type;
import org.pierre.worter.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Combines Words, Articles, Adjectives to form grammatically correct sentences,
 * with a stress on the infamous Declination rules of German Grammar
 */

@Component
public class WordManipulator {
    private WordRepository wordRepository;

    @Autowired
    public WordManipulator(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public String derDieDas(Word word) {
        if (word.getType() != Type.NOUN) {
            throw new IllegalArgumentException(String.format("Type.NOUN  is required for %s", word.toString()));
        }
        return DerDieDas.valueOfGenre(word.getGenre()) + " " + word.getName();
    }

    public String derDieDas(String wordString) {
        Word word = wordRepository.findWord(wordString).get();
        return derDieDas(word);
    }

}
