import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class FileApplications {
    //Metin belgelerindeki kelime listelerini okuyan ve belgeye yeni eklenen kelimeleri yazdıran bir sinif olusturuldu

    /*Kelime listesini donduren bu fonksiyonda parametre olarak dosyalarin path'i alindi
      Dosyadan tüm satirlar Stream olarak okundu
     */
    public static FileApplications file = new FileApplications();
    public List<String> readFile(String fileName) {
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

    //Parametrede alınan String kelimeyi parametrede belirtilen dosyaya yazdırma işlemi
    public void addNewWord(String newWord, String fileName) throws IOException{
        FileWriter file = new FileWriter(fileName, true);
        BufferedWriter output = new BufferedWriter(file);
        output.write(newWord);
        output.close();
       // FileWriter writer = new FileWriter(fileName, true);
       // writer.write(newWord);
       // writer.close();
    }
}