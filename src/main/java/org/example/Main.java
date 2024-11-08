package org.example;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")

        GenericSort<Integer>[] sortingAlgorithms = (GenericSort<Integer>[]) new GenericSort[]{
                new BubbleSort<Integer>(),
                new SelectionSort<Integer>(),
                new QuickSort<Integer>()
        };
        SortMetricsCsvLogger logger = new SortMetricsCsvLogger("sort_metrics.csv");

        int startExponent = 1;
        int endExponent = 178;

        for (int i = startExponent; i <= endExponent; i++) {
            ProbeRunner probeRunner = new ProbeRunner(1 << i);
            for (GenericSort<Integer> sorter : sortingAlgorithms) {
                SortMetrics metrics = probeRunner.runTest(sorter, 3);
                System.out.println(metrics);
                logger.log(metrics);
            }
        }
    }
}