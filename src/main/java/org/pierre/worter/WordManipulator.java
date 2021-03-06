package org.pierre.worter;

import org.pierre.worter.model.DerDieDas;
import org.pierre.worter.model.Noun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Combines Words, Articles, Adjectives to form grammatically correct sentences,
 * with a stress on the infamous Declination rules of German Grammar
 */

@Component
public class WordManipulator {
    private WordJSONRepository wordRepository;

    @Autowired
    public WordManipulator(WordJSONRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public String derDieDas(Noun noun) {
        return DerDieDas.valueOfGenre(noun.getGenre()) + " " + noun.getName();
    }

    public String derDieDas(String wordString) {
        Noun noun = wordRepository.findWord(wordString).get();
        return derDieDas(noun);
    }

}
