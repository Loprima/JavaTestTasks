package Task4;

import java.util.Scanner;

public class FormatNumber {
    private static final String[][] FormatedDigits = { //строчный массив форматированных чисел
            {
                    "XXXX",
                    "X  X",
                    "X  X",
                    "X  X",
                    "XXXX"
            },
            {
                    "   X",
                    "   X",
                    "   X",
                    "   X",
                    "   X"
            },
            {
                    "XXXX",
                    "   X",
                    "XXXX",
                    "X   ",
                    "XXXX"
            },
            {
                    "XXXX",
                    "   X",
                    "XXXX",
                    "   X",
                    "XXXX"
            },
            {
                    "X  X",
                    "X  X",
                    "XXXX",
                    "   X",
                    "   X"
            },
            {
                    "XXXX",
                    "X   ",
                    "XXXX",
                    "   X",
                    "XXXX"
            },
            {
                    "XXXX",
                    "X   ",
                    "XXXX",
                    "X  X",
                    "XXXX"
            },
            {
                    "XXXX",
                    "   X",
                    "   X",
                    "   X",
                    "   X"
            },
            {
                    "XXXX",
                    "X  X",
                    "XXXX",
                    "X  X",
                    "XXXX"
            },
            {
                    "XXXX",
                    "X  X",
                    "XXXX",
                    "   X",
                    "   X"
            }
    };
    private static final String[][] FormatedDigitsMax = { //строчный массив форматированных чисел (при условии написания максимальной цифры в числе)
            {
                    "0000",
                    "0  0",
                    "0  0",
                    "0  0",
                    "0000"
            },
            {
                    "   1",
                    "   1",
                    "   1",
                    "   1",
                    "   1"
            },
            {
                    "2222",
                    "   2",
                    "2222",
                    "2   ",
                    "2222"
            },
            {
                    "3333",
                    "   3",
                    "3333",
                    "   3",
                    "3333"
            },
            {
                    "4  4",
                    "4  4",
                    "4444",
                    "   4",
                    "   4"
            },
            {
                    "5555",
                    "5   ",
                    "5555",
                    "   5",
                    "5555"
            },
            {
                    "6666",
                    "6   ",
                    "6666",
                    "6  6",
                    "6666"
            },
            {
                    "7777",
                    "   7",
                    "   7",
                    "   7",
                    "   7"
            },
            {
                    "8888",
                    "8  8",
                    "8888",
                    "8  8",
                    "8888"
            },
            {
                    "9999",
                    "9  9",
                    "9999",
                    "   9",
                    "9999"
            }
    };
    public static void print(int number){ //построчная печать числа
        int max = maxNumber(number);
        int length = getlength(number);
        int current;
        String buffString = ""; //строка вывода строки символов :)
        for (int line = 0; line < 5; line++){ //перебор строк по высоте
            for (int element = 0; element < length; element++){ //перебор наборов символов форматированных чисел на данной высоте
                current = getNumber(number, element+1);
                if (current != max){
                    buffString = buffString+FormatedDigits[current][line];//формирование строки из наборов символов данной высоты для данной цифры
                } else {
                    buffString = buffString+FormatedDigitsMax[current][line];//то же самое если цифра максимальная
                }
                if (element+1 != length){
                    buffString = buffString+" ";//пробелы между числами
                }
            }
            System.out.println(buffString);
            buffString = "";
        }
    }

    public static int maxNumber(int number){ //поиск максимальной цифры
        int max = 0;
        while (number > 0) {
            if (max < number%10){
                max = number%10;
            }
            number = number/10;
        }
        return max;
    }

    public static int getlength(int number){//поиск длины числа
        int k=0;
        while (number > 0) {
            k++;
            number = number/10;
        }
        return k;
    }

    public static int getNumber(int number, int i){//поиск числа по индексу
        int length = getlength(number);
        int output;
        while (number > 0) {
            output = number%10;
            if (i == length){
                return output;
            }
            length--;
            number = number/10;
        }
        return 10;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        String str = in.nextLine();
        int input = Integer.parseInt(str);
        print(input); //систем аут принтлн нет потому что оно встроено в наш метод
    }
}
