package org.pierre.worter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.pierre.worter.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Configuration
public class CommandRunner implements CommandLineRunner {
    @Autowired
    WordRepository wordRepository;

    @Autowired
    WordManipulator wordManipulator;

    @Override
    public void run(String... args) throws Exception {
        readWriteAll();
    }

    private void writeRandom() {
        Word randomWord = wordRepository.getRandom();
        System.out.println(randomWord);
        System.out.println(wordManipulator.derDieDas(randomWord));
    }

    private void readWriteAll() throws IOException {
        List<Word> allWords = wordRepository.findAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter writer = new FileWriter("allwordsout.json");
        gson.toJson(allWords, writer);
        writer.close();

        FileReader reader = new FileReader("allwordsout.json");
        Word[] words = gson.fromJson(reader, Word[].class);
        Arrays.asList(words).stream().forEach(System.out::println);
    }
}
