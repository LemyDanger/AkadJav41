package org.example;

/**
 *
 */
public class GenSort {

    public static int[] quicksort(int[] items) {
        return GenSort.qSort(items, 0, items.length-1);
    }

    private static int[] qSort(int[] items, int start, int end) {
        int middle;
        if(start < end) {
            middle = GenSort.qDivide(items, start, end);
            qSort(items, start, middle-1);
            qSort(items, middle+1, end);
        }
        return items;
    }

    private static int qDivide(int[] items, int start, int ende) {

        int pivot = items[ende];
        int links = start;
        int rechts = ende;
        int t;

        while(links < rechts) {

            while(items[links] < pivot) {
                links++;
            }
            while( (items[rechts] >= pivot) && (rechts > links)) {
                rechts--;
            }

            if(links < rechts) {
                t = items[links];
                items[links] = items[rechts];
                items[rechts] = t;

            }
        }
        items[ende] = items[rechts];
        items[rechts] = pivot;
        return rechts;
    }





    public static int[] bubbleSortOpt(int[] items) {
        int i,temp;
        int n = items.length;
        boolean swapped = false;

        do {
            swapped = false;
            for(i = 0; i < n -1; i++) {
                if (items[i] > items[i+1]) {
                    temp = items[i];
                    items[i] = items[i+1];
                    items[i+1] = temp;
                    swapped = true;
                }
            }

        } while(swapped);
        return items;
    }


    public static int[] bubbleSort(int[] items) {
        int i,j, temp;
        int n = items.length;

        for(i = n - 1; n > 1; n-- ) {
            for(j = 0; j < i; j++) {
                if (items[j] > items[j+1]) {
                    temp = items[j];
                    items[j] = items[j+1];
                    items[j+1] = temp;
                }
            }
        }

        return items;
      }



    public static int[] selectionSort(int[] items) {

        int i,j, temp;
        int min;
        int n = items.length;

        for(i=0; i<n-1; i++) {
            min = i;
            for (j = i + 1; j < n; j++) {
                if (items[j] < items[min]) {
                    min = j;
                }
            }
            temp = items[i];
            items[i] = items[min];
            items[min] = temp;

        }
        return items;
    }
}
