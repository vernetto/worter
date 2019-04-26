package org.pierre.worter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.pierre.worter.model.Genre;
import org.pierre.worter.model.Type;
import org.pierre.worter.model.Word;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.Optional.of;
import static org.pierre.worter.model.Genre.*;
import static org.pierre.worter.model.Type.NOUN;

@Service
public class WordRepository {

    List<Word> allNames = new ArrayList<>();

    @PostConstruct
    void init() throws FileNotFoundException {
        loadFromFile();
    }

    private void loadFromFile() throws FileNotFoundException {
        FileReader reader = new FileReader("allwords.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Word[] words = gson.fromJson(reader, Word[].class);
        allNames = Arrays.asList(words);
    }

    public List<Word> findAll() {
        return allNames;
    }

    public Word getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(allNames.size());
        return allNames.get(index);
    }
}
