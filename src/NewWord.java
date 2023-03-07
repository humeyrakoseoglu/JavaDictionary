import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NewWord {

    public static void addNewWord(String newWord, String fileName, List<String> wordlist) throws IOException {


            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(newWord);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }
}
         /*
        //Dosyadaki tum kelimeleri oku ve yeniden sirala
        wordlist = Files.lines(Paths.get(dosyaAdi))
                .filter(w -> Boolean.parseBoolean(w.split("/")[0]))
                .map(w -> w.split("/")[0])
                .sorted().collect(Collectors.toList());
        Collections.sort(wordlist);
        for (String word : wordlist) {
            writer.write(word + "\n");
        }*/