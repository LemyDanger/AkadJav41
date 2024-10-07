package org.example;

public class Main {
    public static void main(String[] args) {

        int[] zahlen1 = {5, 1, 4, 9, 0, 8, 6, 34, 14, 66, 99, 34, 23, 15, 65};
        int[] zahlen2 = {5, 1, 4, 9, 0, 8, 6, 34, 14, 66, 99, 34, 23, 15, 65};
        int[] zahlen3 = {5, 1, 4, 9, 0, 8, 6, 34, 14, 66, 99, 34, 23, 15, 65};

        //int[] zahlen3 = {5, 8, 1, 4, 9, 0, 8, 6};
        //int[] zahlen3 = {3, 12, 5, 2, 14, 9, 8, 11, 4, 1, 10, 16, 7, 6, 17, 15, 13};


        int[] ergebnis;


        System.out.println("Zahlen1");
        ausgabe(zahlen1);
        System.out.println("Bubble");
        ergebnis = GenSort.bubbleSortOpt(zahlen1);
        SortHelper.ausgabe(zahlen1);
        SortHelper.ausgabe(ergebnis);

        /*
        System.out.println("Selection");
        ergebnis = GenSort.selectionSort(zahlen2);
        SortHelper.ausgabe(ergebnis);

        ergebnis = GenSort.quicksort(zahlen3);
        System.out.println("Quicksort");
        SortHelper.ausgabe(ergebnis);

         */


    }




    public static void ausgabe(int[] zahlen) {

        for(int i=0; i < zahlen.length; i++) {
            System.out.printf("%d ",zahlen[i]);
        }
        System.out.println();
    }



}