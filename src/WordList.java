import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class WordList {
    //Metin belgelerindeki kelime listelerini okuyacak bir sınıf oluşturdum
    List<String> getTurkishWords = readFile("src/tureng.txt");
    List<String> getEnglishWords = readFile("src/engtur.txt");

    /*Kelime listesini döndüren bu fonksiyonda parametre olarak dosyaların path'ini aldım
      Dosyadan tüm satırları Stream olarak okudum
     */
    public static List<String> readFile(String fileName) {

        List<String> words = new ArrayList<>();
        try {
            words = Files.lines(Paths.get(fileName))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("Dosya bulunamadı: " + fileName);
        }
        return words;
    }
}
