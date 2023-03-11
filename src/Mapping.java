import java.util.*;


public class Mapping {
    /*Bu sinifta ceviri islemleri gerceklesiyor. Metoda gore girilen parametredeki Stringe uygun parametredeki list içinde bir eslesme bulunursa, cevrilen String kelime doner
      sözlük için kelime ve çevirilerinde <key, value> HashMap yapısı kullanıldı
     */

    public String fromTurkish(String translate, List<String> lines) {
        Map<String, String[]> TRdictionary = new HashMap<>();
        lines.forEach(line -> {
            String[] words = line.split("/"); //"/" karakterinden bölüp String list oluşturuluyor
            String word = words[0]; // ilk eleman çevirisi yapılacak kelime veya kelime grubudur
            String[] request = word.split(","); // "," ile aynı anlama sahip birden fazla kelime olabilir bunlar request listesinde tutulacak
            for (int i = 0; i < request.length; i++) {
                request[i] = request[i].trim();
            }
            String[] translations = words[1].split(",");

            for(String s : request){ // hashmap içinde çevrilmesi istenen değer aranıyor.  Eğer kelime birden fazla kez anlama sahipse, bu kod bloğu sözcüğün mevcut çevirileri listesine yeni çeviriler ekler.
                if (TRdictionary.containsKey(s)) {
                    String[] existingTranslations = TRdictionary.get(s); // "TRdictionary" içinde zaten bu kelime varsa, o zaman önceden var olan çevirileri alır
                    String[] newTranslations = new String[existingTranslations.length + translations.length];
                    System.arraycopy(existingTranslations, 0, newTranslations, 0, existingTranslations.length); //mevcut çevirilerin sayısı kadar bir dizi oluştur ve önceki çevirileri yeni diziye kopyala
                    System.arraycopy(translations, 0, newTranslations, existingTranslations.length, translations.length);//yeni çeviriyi yeni dizinin sonuna koy
                    TRdictionary.put(s, newTranslations);
                } else {
                    TRdictionary.put(s, translations);
                }
            }
        });
        String[] translationsList = TRdictionary.getOrDefault(translate, new String[0]);
        String translations = String.join(",", translationsList);

        return translations;
    }

    public String fromEnglish(String translate, List<String> lines) {
        Map<String, String[]> ENGdictionary = new HashMap<>();
        lines.forEach(line -> {
            String[] words = line.split("/");
            String[] translations = words[1].split(",");// // "," ile bir kelime birden fazla anlama sahip olabilir bu anlamları translation listesinde tut
            String word = words[0]; //çevrilecek ingilizce kelime
            //     for (int i = 0; i < translations.length; i++) {
            //         translations[i] = translations[i].trim(); // trim sayesinde kelimeler arasındaki boşluklar problem oluşturmayacak ve aradaki virgüllerle ayrılmış her bir kelime ayrı bir eleman olarak işlenebilecek
            //     }

            if (ENGdictionary.containsKey(word)) {
                String[] existingTranslations = ENGdictionary.get(word);
                String[] newTranslations = new String[existingTranslations.length + translations.length];
                System.arraycopy(existingTranslations, 0, newTranslations, 0, existingTranslations.length);
                System.arraycopy(translations, 0, newTranslations, existingTranslations.length, translations.length);
                ENGdictionary.put(word, newTranslations);
            } else {
                ENGdictionary.put(word, translations);
            }

        });
        String[] translationsList = ENGdictionary.getOrDefault(translate, new String[0]);
        String translations = String.join(",", translationsList);
        return translations;
    }
}