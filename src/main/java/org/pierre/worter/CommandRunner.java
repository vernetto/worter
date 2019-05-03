package org.pierre.worter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.pierre.worter.model.Noun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
public class CommandRunner implements CommandLineRunner {
    @Autowired
    WordJSONRepository wordJSONRepository;

    @Autowired
    WordRepository wordRepository;

    @Autowired
    WordManipulator wordManipulator;

    @Autowired
    WordLoader wordLoader;

    @Override
    public void run(String... args) throws Exception {
        loadDBFFromJSON();
    }

    private void writeRandom() {
        Noun randomNoun = wordJSONRepository.getRandomWord();
        System.out.println(randomNoun);
        System.out.println(wordManipulator.derDieDas(randomNoun));
    }

    private void readWriteAll() throws IOException {
        List<Noun> allNouns = wordJSONRepository.findAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter writer = new FileWriter("allwordsout.json");
        gson.toJson(allNouns, writer);
        writer.close();

        FileReader reader = new FileReader("allwordsout.json");
        Noun[] nouns = gson.fromJson(reader, Noun[].class);
        Arrays.asList(nouns).stream().forEach(System.out::println);
    }

    private void loadDBFFromJSON() {
        List<Noun> allNouns = wordJSONRepository.findAll();
        wordRepository.saveAll(allNouns);
    }
}
