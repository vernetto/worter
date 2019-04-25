package org.pierre.worter;

import org.pierre.worter.model.Genre;
import org.pierre.worter.model.Type;
import org.pierre.worter.model.Word;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.Optional.of;
import static org.pierre.worter.model.Genre.*;
import static org.pierre.worter.model.Type.NOUN;

@Service
public class WordRepository {

    List<Word> allNames = Arrays.asList(
            Word.of("Löffel", M, NOUN),
            Word.of("Gabel", F, NOUN),
            Word.of("Messer", N, NOUN),
            Word.of("Mensch", M, NOUN),
            Word.of("Nachbarin", F, NOUN),
            Word.of("Gast", M, NOUN)
    )
            ;

    public List<Word> findAll() {
        return allNames;
    }

    public Word getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(allNames.size());
        return allNames.get(index);
    }
}
