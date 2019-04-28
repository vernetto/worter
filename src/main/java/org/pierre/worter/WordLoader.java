package org.pierre.worter;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Reads wordsSet from a file and put them into a JSON format without duplicates
 */

@Service
public class WordLoader {

    Set<String> wordsSet = new HashSet<>();

    public void loadFile(String filename) throws IOException {
        Files.lines(Paths.get(filename)).forEach(line -> parse(line));
        List<String> list = new ArrayList<>(wordsSet);
        list.sort(String::compareToIgnoreCase);
        list.forEach(System.out::println);
    }

    private void parse(String line) {
        String[] arr = line.split("\\W+");
        Arrays.asList(arr).forEach(wordsSet::add);
    }
}
