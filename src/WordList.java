import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class WordList {
    //Metin belgelerindeki kelime listelerini okuyacak bir sinif olusturuldu
    List<String> getTurkishWords = readFile("src/tureng.txt");
    List<String> getEnglishWords = readFile("src/engtur.txt");

    /*Kelime listesini donduren bu fonksiyonda parametre olarak dosyalarin path'i alindi
      Dosyadan tüm satirlar Stream olarak okundu
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