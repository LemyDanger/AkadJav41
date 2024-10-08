package org.example;

import java.util.List;

/**
 * Diese Klasse implementiert einen Selection-Sort Algorithmus
 *
 * @param <T> Der Typ der zu sortierenden Objekte.
 *            Das Objekt muss zur Vergleichbarkeit das Comparable-Interface implementieren
 */
public class SelectionSort<T extends Comparable<T>> extends GenericSort<T> {

    /**
     * Sortiert die interne Liste nach dem Selection-Algorithmus
     *
     * @return Die sortierte Liste der Objekte
     */
    public List<T> sort() {

        int i, j, min;
        int n = this.elements.size();


        for (i = 0; i < n - 1; i++) {
            min = i;
            for (j = i + 1; j < n; j++) {
                if (this.elements.get(j).compareTo(this.elements.get(min)) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                swap(i, min);
            }
        }
        return this.elements;
    }
}

