package org.sparrow;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * если используем int, то максимальный факториал, который можем взять без потери данных, - 31, для long - 39.
 * <br>Примечание к решениям:
 * на просторах интернета проверка отрицательного значения или не выполняется, или выполняется как if (f <= 1) return 1,
 * но т.к. это функция, определённая на множестве <b>неотрицательных</b> целых чисел, то дописала проверки
 */

public class Factorial {

    //через цикл
    public static int getFactorial1(int value) {
        int result = 1;

        if (value < 0) {
            throw new ArithmeticException("Value must be > 0");
        } else if (value == 0 || value == 1) {
            return result;
        } else {

            for (int i = 1; i <= value; i++) {
                result *= i;
            }
        }
        return result;
    }

    //рекурсия
    public static int getFactorial2(int value) {
        if (value < 0) {
            throw new ArithmeticException("Value must be > 0");
        } else if (value == 0 || value == 1) {
            return 1;
        } else {
            return value * getFactorial2(value - 1);
        }
    }

    //сртим
    public static int getFactorial3(int value) {
        if (value < 0) {
            throw new ArithmeticException("Value must be > 0");
        } else if (value == 0 || value == 1) {
            return 1;
        } else {
            return IntStream
                    .rangeClosed(2, value) //создаёт значения с 2 до value включительно с шагом 1
                    .reduce((x, y) -> x * y) //объединяем все значения
                    .getAsInt(); //получаем результирующее значение
        }
    }

    //большие значения
    public static BigInteger getFactorialBig(int value) {
        if (value < 0) {
            throw new ArithmeticException("Value must be > 0");
        } else if (value == 0 || value == 1) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(value).multiply(getFactorialBig(value - 1));
        }
    }

    //проверить, что всё работает
    public static void main(String[] args) {
        System.out.println(getFactorial1(0));
        System.out.println(getFactorial2(0));
        System.out.println(getFactorial3(0));

        System.out.println(getFactorial1(1));
        System.out.println(getFactorial2(1));
        System.out.println(getFactorial3(1));

        System.out.println(getFactorial1(5));
        System.out.println(getFactorial2(5));
        System.out.println(getFactorial3(5));

        System.out.println("-BIG-");
        System.out.println(getFactorialBig(0));
        System.out.println(getFactorialBig(1));
        System.out.println(getFactorialBig(5));
        System.out.println(getFactorialBig(100));
    }
}