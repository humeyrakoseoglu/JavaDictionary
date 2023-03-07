import java.io.IOException;
import java.util.Scanner;
public class Dictionary {
    /***
     *
     * @author Humeyra Koseoglu
     * @since 04.03.2023
     */
    public static void main(String[] args) throws IOException {
        //Kullanilacak diger siniflar icin nesneleri olusturuldu
        WordMatching wordMatch = new WordMatching();
        NewWord newWord = new NewWord();
        WordList wordList = new WordList();
        //Kullanicidan secim icin input alindi
        Scanner scanner = new Scanner(System.in);

        //sonsuz dongu olusturuldu icinde Menu bilgisi yazdirildi ve girilen inputa gore islemler gerceklestirildi
        while (true) {
            System.out.println("Kullanmak istediğiniz sözlük için aşağıdaki seçeneklerden devam ediniz:");
            System.out.println("1 - Türkçe-İngilizce çeviri yap");
            System.out.println("2 - İngilizce-Türkçe çeviri yap");
            System.out.println("3 - Yeni Kelime Ekle");
            System.out.println("0 - Çıkış yap");


            int choice = scanner.nextInt();
            scanner.nextLine();

            // Turkce-Ingilizce Ceviri Islemleri. Kelimeleri karsılıgı ile eslestirmek icin WordMatching sinifi kullaniliyor
                 if (choice == 1) {
                     System.out.println("#### Türkçe-İngilizce Sözlük ####");
                     System.out.print("Kelime : ");
                     String turkishWord = scanner.nextLine();
                     String english = wordMatch.turkish(turkishWord);
                     if (english != null) {
                         System.out.println("İngilizce Karşılığı : " +  english);
                     } else {
                         System.out.println("Kelime bulunamadı.");
                     }
                 } // Ingilizce-Turkce Ceviri Islemleri
                 else if (choice == 2) {
                     System.out.println("#### İngilizce-Türkçe Sözlük ####");
                     System.out.print("Kelime : ");
                     String englishWord = scanner.nextLine();
                     String turkish = wordMatch.english(englishWord);
                     if (turkish != null) {
                         System.out.println("Türkçe Karşılığı : " +  turkish);
                     } else {
                         System.out.println("Kelime bulunamadı.");
                     }
                 } // Yeni Kelime Ekleme Islemleri. Yine bir sonsuz dongu ile yeni bir secim sunuldu. Sozlukler icin WordList sinifi, kelime eklemek icin newWord sinifi kullanildi
                 else if (choice == 3) {
                     while (true) {
                         System.out.println("#### Yeni Kelime Ekle ####");
                         System.out.print("Eklemek istediğiniz kelime türkçe ise 1'e ingilizce ise 2'ye, menüden çıkmak için ise 0'a basınız... ");
                         int newChoice = scanner.nextInt();
                         // Turkce kelime eklemek icin
                         if(newChoice==1){
                             System.out.print("Eklemek istediğiniz türkçe kelime:");
                             String trWord = scanner.next();
                             System.out.print("Eklemek istediğiniz kelimenin ingilizce karşılığı:");
                             String trEngWord = scanner.next();
                             newWord.addNewWord('\n'+trWord+"/"+trEngWord,"JavaDictionary/src/tureng.txt",wordList.getTurkishWords);
                             System.out.println(trWord+" sözlüğe eklendi.");
                         } // Ingilizce kelime eklemek icin
                         else if(newChoice==2){
                             System.out.print("Eklemek istediğiniz ingilizce kelime:");
                             String engWord = scanner.next();
                             System.out.print("Eklemek istediğiniz kelimenin türkçe karşılığı:");
                             String engTWord = scanner.next();
                             newWord.addNewWord('\n'+engWord+'/'+engTWord,"JavaDictionary/src/engtur.txt", wordList.getEnglishWords);
                             System.out.println(engWord+" sözlüğe eklendi.");
                         } // menuden cikmak icin
                         else if(newChoice==0){
                             break;
                         } else{
                             System.out.println("Geçersiz bir tuşa basıldı.");
                         }}
                 }// menuden cikmak icin
                 else if (choice == 0) {
                     break;
                 }else{
                     System.out.println("Geçersiz bir tuşa basıldı.");
                 }
             }
            scanner.close();
        }
    }