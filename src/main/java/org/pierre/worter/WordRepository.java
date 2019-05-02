package org.pierre.worter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.pierre.worter.model.Adjective;
import org.pierre.worter.model.Noun;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WordRepository {

    private List<Adjective> allAdjectives = new ArrayList<>();
    private List<Noun> allNouns = new ArrayList<>();

    @PostConstruct
    private void init() throws FileNotFoundException {
        loadFromFile();
    }

    private void loadFromFile() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Noun[] nouns = gson.fromJson(new FileReader("allwords.json"), Noun[].class);
        Adjective[] adjectives = gson.fromJson(new FileReader("alladjectives.json"), Adjective[].class);
        allNouns = Arrays.asList(nouns);
        allAdjectives = Arrays.asList(adjectives);
        allNouns = allNouns.stream().collect(Collectors.toList());
        log.info("total {} wordsSet, {} nouns, {} adjectives", allNouns.size(), allNouns.size(), allAdjectives.size());
    }

    public List<Noun> findAll() {
        return allNouns;
    }

    public Optional<Noun> findWord(String theName) {
        return allNouns.stream().filter(word -> word.hasName(theName)).findFirst();
    }


    public Noun getRandomWord() {
        Random rand = new Random();
        int index = rand.nextInt(allNouns.size());
        return allNouns.get(index);
    }

    public Noun getRandomNoun() {
        Random rand = new Random();
        int index = rand.nextInt(allNouns.size());
        return allNouns.get(index);
    }

    public Adjective getRandomAdjective() {
        Random rand = new Random();
        int index = rand.nextInt(allNouns.size());
        return allAdjectives.get(index);
    }

}
