package fileanalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class FileAnalyzer {
    public Map<String, Integer> wordMap(String path) throws IOException {
        Map<String, Integer> wordCountMap = new HashMap<>();
        List<String> lines = Files.readAllLines(Path.of(path));
        for (String line : lines) {
            String[] words = line.toLowerCase().split("\\W+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        }
        return wordCountMap;
    }

    public int totalWordCount(String path) throws IOException {
        return wordMap(path).values().stream().mapToInt(Integer::intValue).sum();
    }

    public int uniqueWordCount(String path) throws IOException {
        return wordMap(path).size();
    }

    public Map<String, Integer> topFrequentWords(String path, int n) throws IOException {
        return wordMap(path).entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(n)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public int countWordOccurrences(String path, String word) throws IOException {
        return wordMap(path).getOrDefault(word.toLowerCase(), 0);
    }
}