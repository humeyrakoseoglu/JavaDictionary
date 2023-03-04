import java.util.List;

public class WordMatching {
    //Bu sınıfta çeviri işlemleri gerçekleşiyor. Metoda göre bir eşleşme bulunursa, çevrilen kelime döndürülür ve eşleşmezse, orElse() yöntemi kullanılarak yöntem null değerini döndürür.

    private String translate;

    public String wordMatcing(String word, List<String> wordList){
        return translate = wordList.stream()
                .filter(w -> w.split("/")[0].contains(word)) // listedeki her kelimenin "/" karakterinden bölündüğü ve bölünmüş dizenin ilk bölümünün parametredeki Stringi içermesi gerektiği bir koşula dayalı olarak filtreler
                .map(w -> w.split("/")[1]) // karakterinden sonra gelen kısmı alır
                .findFirst() // İlk uygun kelimeyi bulur
                .orElse(null); // Bulunamazsa null döndürür
    }
}
