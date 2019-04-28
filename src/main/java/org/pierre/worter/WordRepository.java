package org.pierre.worter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.pierre.worter.model.Word;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WordRepository {

    private List<Word> allWords = new ArrayList<>();
    private List<Word> allAdjectives = new ArrayList<>();
    private List<Word> allNouns = new ArrayList<>();

    @PostConstruct
    private void init() throws FileNotFoundException {
        loadFromFile();
    }

    private void loadFromFile() throws FileNotFoundException {
        FileReader reader = new FileReader("allwords.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Word[] words = gson.fromJson(reader, Word[].class);
        allWords = Arrays.asList(words);
        allAdjectives = allWords.stream().filter(Word.isAdjective).collect(Collectors.toList());
        allNouns = allWords.stream().filter(Word.isNoun).collect(Collectors.toList());
        log.info("total {} wordsSet, {} nouns, {} adjectives", allWords.size(), allNouns.size(), allAdjectives.size());
    }

    public List<Word> findAll() {
        return allWords;
    }

    public Optional<Word> findWord(String theName) {
        return allWords.stream().filter( word -> word.hasName(theName)).findFirst();
    }


    public Word getRandomWord() {
        Random rand = new Random();
        int index = rand.nextInt(allWords.size());
        return allWords.get(index);
    }

    public Word getRandomNoun() {
        Random rand = new Random();
        int index = rand.nextInt(allWords.size());
        return allNouns.get(index);
    }

    public Word getRandomAdjective() {
        Random rand = new Random();
        int index = rand.nextInt(allWords.size());
        return allAdjectives.get(index);
    }

}
