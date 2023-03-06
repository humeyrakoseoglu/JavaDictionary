import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NewWord {

    public static void addNewWord(String newWord, String fileName, List<String> wordlist) throws IOException {
        // FileWriter, BufferedWriter ile sarilir ve sozluge eklenen kelime yeni bir satirda dosyaya yazilir
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(newWord);

         /*
        //Dosyadaki tum kelimeleri oku ve yeniden sirala
        wordlist = Files.lines(Paths.get(dosyaAdi))
                .filter(w -> Boolean.parseBoolean(w.split("/")[0]))
                .map(w -> w.split("/")[0])
                .sorted((s1,s2)->s1.compareTo(s2)).collect(Collectors.toList());
        Collections.sort(wordlist);
        for (String word : wordlist) {
            writer.write(word + "\n");
        }*/
        }
    }
}
