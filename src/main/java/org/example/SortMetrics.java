package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class SortMetrics {

    public String name;

    private int numElemnts;
    private long[] probeTimes;

    public long min, max, avg;

    public SortMetrics(String name, int numElemnts, long[] probeTimes) {
        this.name = name;
        this.numElemnts = numElemnts;
        this.probeTimes = probeTimes;
        this.calcMetrics();
    }

    public String getName() {
        return name;
    }

    public int getNumElemnts() {
        return numElemnts;
    }

    /**
     * @// TODO: 08.11.2024 Division by zero
     */
    private void calcMetrics() {
        
        int sum = 0;

        this.min = this.probeTimes[0];
        this.max = this.probeTimes[0];

        for (long value : this.probeTimes) {
            sum += value;
            this.min = (value < this.min) ? value : this.min;
            this.max = (value > this.max) ? value : this.max;
        }
        this.avg = (sum / probeTimes.length);

    }

    public String toString() {

        return "Alg: " + this.name + " Anz: " + this.numElemnts
                + " Avg: " + this.avg
                + " Min: " + this.min
                + " Max: " + this.max ;
    }

}
