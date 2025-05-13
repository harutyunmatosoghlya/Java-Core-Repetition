package fileanalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class FileAnalyzerTest {
    public static void main(String[] args) {
        String content = "The quick brown fox jumps over the lazy dog. This sentence contains all the letters of the English alphabet, making it a pangram. The purpose of a pangram is to test fonts, typewriters, and other text systems. There are many types of pangrams, and they can vary in complexity. Some pangrams use more common words, while others incorporate more obscure terms. For example, one of the simplest and most famous pangrams is The quick brown fox jumps over the lazy dog. However, there are longer and more complex versions of pangrams, such as: Pack my box with five dozen liquor jugs, which also contains all the letters of the alphabet but uses more unusual words. Pangrams are an important part of language exercises, helping students practice writing and typing skills. They are also used in testing various font rendering systems, keyboard layouts, and even speech recognition programs. Although the main goal of a pangram is to include every letter of the alphabet, it can also provide an interesting challenge for people to come up with creative and novel sentences. The quick brown fox jumps over the lazy dog again. The fox is quick, but the dog is not so lazy today.";
        FileAnalyzer analyzer = new FileAnalyzer();
        Path filePath = Paths.get("sample.txt");
        try {
            Files.write(filePath, content.getBytes());
            System.out.println("Файл 'sample.txt' успешно создан!");
        } catch (IOException e) {
            System.err.println("Ошибка при создании файла: " + e.getMessage());
            return;
        }
        try {
            System.out.println("Общее количество слов: " + analyzer.totalWordCount(String.valueOf(filePath)));
            System.out.println("Уникальных слов: " + analyzer.uniqueWordCount(String.valueOf(filePath)));
            System.out.println("\nТоп-5 самых частых слов:");
            Map<String, Integer> topWords = analyzer.topFrequentWords(String.valueOf(filePath), 5);
            topWords.forEach((word, count) -> System.out.println(word + ": " + count));
            String targetWord = "dog";
            int occurrences = analyzer.countWordOccurrences(String.valueOf(filePath), targetWord);
            System.out.println("\nСлово \"" + targetWord + "\" встречается: " + occurrences + " раз");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        try {
            Files.delete(filePath);
            System.out.println("\nФайл 'sample.txt' успешно удалён.");
        } catch (IOException e) {
            System.err.println("Ошибка при удалении файла: " + e.getMessage());
        }
    }
}