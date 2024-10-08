package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BubbleSort<Integer> bubble = new BubbleSort<Integer>();
        SelectionSort<Integer> selection = new SelectionSort<Integer>();

        GenericSort<Integer> sorter = selection;


        // Erzeuge eine Liste mit 10 Zahlen
        Integer[] zahlen = SortHelper.createInteger(20, 100);
        // Integer[] zahlen = { 1, 7, 2, 3, 0, 5, 7};
        sorter.add(zahlen);

        SortHelper.print(sorter.get());
        System.out.println("");
        System.out.println("");

        System.out.println(sorter.sort());


    }

}