package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestRunner {

    private Integer[] data;

    public TestRunner(int count, int max) {
        this.createData(count, max);
    }

    private void createData(int count, int max) {
        this.data = new Integer[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            this.data[i] = random.nextInt(max);
        }
    }

    public long runTest(GenericSort sort) {


        Integer[] probe = Arrays.copyOf(this.data, this.data.length);
        long starttime, endtime;

        sort.clear();
        sort.add(probe);

        // System.out.println("Start");
        // System.out.println(sort.get());
        starttime = System.currentTimeMillis();


        sort.sort();
        endtime = System.currentTimeMillis();

        // System.out.println("Ende");
        // System.out.println(sort.get());


        return (endtime-starttime);



    }


}
