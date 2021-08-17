package org.sparrow;

import java.util.Arrays;

/**
 * Числа Фибоначчи — это последовательность натуральных чисел,которая начинается с чисел ноль и один,
 * а каждое последующее число равно сумме двух предыдущих (иногда 0 опускается, и ряд начинается с 1 1 2 3…)
 * <br>Примечание к решениям: т.к. есть расширение на отрицательные числа и т.д., то тут исключение не бросаю.
 */
public class Fibonacci {

    //Получение n первых чисел Фибоначчи ==========================
    public static int[] getArray(int n) {
        if (n <= 1) {
            return new int[]{0};
        }
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }
    //==============================================================


    //Получения n-ого по счёту числа Фибоначчи =====================
    //отсчет идет от нуля, т.е. для [0, 1, 1, 2, 3, 5, 8, 13, 21, 34] под индексом "3" находится "2"
    public static int getValue(int index) {
        int a = 0;
        if (index == 0) {
            return a;
        }
        int b = 1;
        for (int i = 2; i <= index; ++i) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b;
    }
    //==============================================================

    //Получение суммы двух последних числел=========================
    //т.е. для значения 10, последовательность будет [0, 1, 1, 2, 3, 5, 8, 13, 21, 34], получаем 21+34
    public static int calculateWithFor(int n) {
        int first = 0;
        int second = 1;
        int result = n;
        for (int i = 1; i < n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    //рекурсия в ПЛОХОМ исполнении
    //в хорошем используется мемоизация https://www.youtube.com/watch?v=QlY5BGOhMKk
    public static int calculateRecursiveBad(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return calculateRecursiveBad(n - 2) + calculateRecursiveBad(n - 1);
    }
    //=====================================================================================

    //Получение суммы n первых чисел
    //для int - первые 46 чисел, для long первые 91, затем переполнение :(
    public static int getSum(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int sum = 2;
        int a = 1;
        int b = 1;

        for (int i = 3; i < n; i++) {
            int fibonacci = a + b;
            sum += fibonacci;
            a = b;
            b = fibonacci;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getArray(10)));
        System.out.println(getValue(9));
        System.out.println(calculateWithFor(10));
        System.out.println(calculateRecursiveBad(10));
        System.out.println(getSum(3));
    }
}
