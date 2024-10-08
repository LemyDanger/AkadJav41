package org.example;

import java.util.ArrayList;
import java.util.Random;

public class SortHelper {

    public static Integer[] createInteger(int count, int max) {

        Integer[] zahlen = new Integer[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            zahlen[i] = random.nextInt(max);
        }
        return zahlen;
    }


    public static void print(Integer[] numbers) {

        for (int num : numbers) {
            System.out.print(num);
            System.out.print(' ');
        }

        System.out.println("-----");
    }

    public static void print(ArrayList<Integer> numbers) {
        for (int num : numbers) {
            System.out.print(num);
            System.out.print(' ');
        }
    }


}
