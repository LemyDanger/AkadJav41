package org.example;

public class Main {
    public static void main(String[] args) {

        int anzahlWerte = 20;
        TestRunner runner = new TestRunner(80000, Integer.MAX_VALUE);



        BubbleSort<Integer> bubble = new BubbleSort<Integer>();
        SelectionSort<Integer> selection = new SelectionSort<Integer>();
        QuickSort<Integer> quick = new QuickSort<>();

        for(int i = 1; i <= 3; i++) {
            System.out.println("Lauf "+i+ " - "+runner.runTest(bubble) + " ms");
        }



        /*
        GenericSort<Integer> sorter = quick;


        // Erzeuge eine Liste mit 10 Zahlen
        Integer[] zahlen = SortHelper.createInteger(20, 100);
        // Integer[] zahlen = { 1, 7, 2, 3, 0, 5, 7};
        sorter.add(zahlen);

        System.out.println("Vorher");
        System.out.println(sorter.get());

        System.out.println("Nachher");
        System.out.println(sorter.sort());
         */
    }

}