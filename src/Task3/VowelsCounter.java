package Task3;

import java.util.Locale;
import java.util.Scanner;

public class VowelsCounter {

    static int countVowels(String word){ //подсчет колличества гласных
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            counter += isVowel(word.charAt(i)) ? 1: 0;
        }
        return counter;
    }

    private static boolean isVowel(char c){ //является ли символ гласной буквой?
        c = Character.toLowerCase(c);
        return c == 'а' || c == 'о' || c == 'у' || c == 'ы' || c == 'е' || c == 'я' || c == 'ю' || c == 'и' || c == 'ё' || c == 'э';
    }

    static String upperFirst(String word){ //делает первую гласную букву заглавной
        for (int i = 0; i < word.length(); i++) {
            char let = word.charAt(i);
            if (isVowel(let)) {
                word = word.replaceFirst(Character.toString(let), Character.toString(Character.toUpperCase(let)));
                return word;
            }
        }
        return word;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите предложение: ");
        String str = in.nextLine();
        str = str.toLowerCase(Locale.ROOT);
        String[] words = str.split(" "); //делим предложение на массив слов
        String buff;
        for (int i = 0; i < words.length; i++){ //сортировка массива по гласным буквам пузырьком :)
            for (int j = 0; j < words.length-1; j++){
                if (countVowels(words[j+1]) > countVowels(words[j])){
                    buff = words[j+1];
                    words[j+1] = words[j];
                    words[j] = buff;
                }
            }
        }
        for(String word:words) {
            System.out.println("Отсортированное предложение, в котором первые гласные заглавные: ");
            System.out.println(upperFirst(word));
        }
    }
}
