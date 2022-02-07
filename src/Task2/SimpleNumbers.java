package Task2;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class SimpleNumbers {

    private static boolean isDigit(String s) throws NumberFormatException { //ошибка при вводе любых данных кроме целого числа
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error! This is not integer!");
            return false;
        }
    }
    public static Set primeFactors(long number) { //поиск простых множителей
        Set primefactors = new HashSet<>();
        long copyOfInput = number;
        for (int i = 2; i <= copyOfInput; i++) { //перебор простых чисел
            if (copyOfInput % i == 0) {
                primefactors.add(i); //добавляем множитель в наш набор
                copyOfInput /= i;
                i--;
            }
        }
        return primefactors;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        do {
            System.out.println("Введите целое число: ");
            str = in.nextLine();
        } while (isDigit(str) == false); //конструкция для ввода
        int test = Integer.parseInt(str);
        System.out.println("Простые множители: "+primeFactors(test));
    }
}