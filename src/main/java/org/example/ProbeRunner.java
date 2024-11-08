package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProbeRunner {

    private Integer[] sortData;

    public ProbeRunner(int numElements) {
        this.createData(numElements);
    }

    private void createData(int numElements) {
        this.sortData = new Integer[numElements];
        Random random = new Random();

        for (int i = 0; i < numElements; i++) {
            this.sortData[i] = random.nextInt(Integer.MAX_VALUE);
        }
    }

    public SortMetrics runTest(GenericSort<Integer> sort, int numProbes) {

        // Ablage der einzelnen Messwerte
        long[] probeTimes = new long[numProbes];

        System.out.println("================ WARM UP ====================");

        for (int probeRun = 0; probeRun < 3; probeRun++) {
            // Lege eine neue Kopie der Daten an
            Integer[] probeData = Arrays.copyOf(this.sortData, this.sortData.length);
            sort.clear();
            sort.add(probeData);
            sort.sort();
        }



            System.out.println("============================================================");
        System.out.println("Starte Messung für " + sort.toString() + "Anzahl Elemnte: " + this.sortData.length);

        for (int probeRun = 0; probeRun < numProbes; probeRun++) {
            // Lege eine neue Kopie der Daten an
            Integer[] probeData = Arrays.copyOf(this.sortData, this.sortData.length);

            // Setze das Sortier-Objekt zurück
            sort.clear();
            sort.add(probeData);
            System.gc();

            Instant start = Instant.now();
            List<Integer> sortData = sort.sort();
            Instant end = Instant.now();
            Duration duration = Duration.between(start, end);

            System.out.println("Lauf " + probeRun + ": " + duration.toMillis() + " Millisekunden");
            // System.out.println("ProbeHash: " + probeHash + " SortHash: " + sortHash);

            probeTimes[probeRun] = duration.toMillis();

        }
        System.out.println("------------------------------------------");
        return new SortMetrics(sort.getClass().getSimpleName(), this.sortData.length, probeTimes);

    }

    private int getHash(Integer[] numbers) {
        return Arrays.hashCode(numbers);
    }


    public int getNumOfElements() {
        return this.sortData.length;
    }

    public String getData() {
        return Arrays.toString(this.sortData);
    }
}
