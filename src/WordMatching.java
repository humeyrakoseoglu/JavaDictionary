import java.util.List;

public class WordMatching {
    //Bu sinifta ceviri islemleri gerceklesiyor. Metoda gore bir eslesme bulunursa, cevrilen kelime doner ve eslesmezse, orElse() yontemi kullanilarak null degeri dondurur

    private String translate;

    public String wordMatcing(String word, List<String> wordList){
        return translate = wordList.stream()
                .filter(w -> w.split("/")[0].contains(word)) // listedeki her kelimenin "/" karakterinden bolundugu ve bolunmus dizenin ilk bolumunun parametredeki Stringi icermesi gerektigi kosuluna dayali olarak filtreler
                .map(w -> w.split("/")[1]) // karakterinden sonra gelen kismi alir
                .findFirst() // Ilk uygun kelimeyi bulur
                .orElse(null); // Bulunamazsa null dondurur
    }
}