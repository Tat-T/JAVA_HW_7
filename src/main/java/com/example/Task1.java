package com.example;

import java.util.*;
import java.util.stream.*;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> numbers = new Random()
                .ints(-1000, 1000)
                .limit(100)
                .boxed()
                .collect(Collectors.toList());

        // Количество положительных чисел
        long positiveCount = numbers.stream()
                .filter(n -> n > 0)
                .count();

        // Количество отрицательных чисел
        long negativeCount = numbers.stream()
                .filter(n -> n < 0)
                .count();

        // Количество двузначных чисел
        long twoDigitCount = numbers.stream()
                .filter(n -> Math.abs(n) >= 10 && Math.abs(n) <= 99)
                .count();

        // Количество зеркальных чисел (например, 121, 4224)
        long mirroredCount = numbers.stream()
                .filter(n -> isMirrored(n))
                .count();

        System.out.println("Список чисел: " + numbers);
        System.out.println("Положительных: " + positiveCount);
        System.out.println("Отрицательных: " + negativeCount);
        System.out.println("Двузначных: " + twoDigitCount);
        System.out.println("Зеркальных: " + mirroredCount);
    }

    // Метод для проверки "зеркальности" числа
    private static boolean isMirrored(int n) {
        String s = Integer.toString(Math.abs(n));
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
