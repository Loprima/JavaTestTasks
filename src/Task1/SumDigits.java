package Task1;

import java.util.Scanner;

public class SumDigits {
    public static int digitSum(String input){
        input = input.replaceAll("[^0-9]", ""); //оставляем в строке только цифры
        if (input.isEmpty()) //0 если пустая строка
            return 0;
        int sum=0;
        int numberOnlyInt = Integer.parseInt(input); //переводим строку из цифр в число
        while (numberOnlyInt > 0){
            sum += numberOnlyInt%10; //прибавляем последнюю цифру к сумме
            numberOnlyInt = numberOnlyInt/10; //удаляем прибавленную цифру из числа
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("Введите строку: ");
        Scanner in = new Scanner(System.in);
        String str= in.nextLine();
        System.out.println("Сумма цифр: "+SumDigits.digitSum(str));
    }
}
