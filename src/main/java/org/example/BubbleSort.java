package org.example;

import java.util.List;

/**
 * Diese Klasse implementiert einen einfachen Bubblesort Algorithmus
 *
 * @param <T> Der Typ der zu sortierenden Objekte.
 *            Das Objekt muss zur Vergleichbarkeit das Comparable-Interface implementieren
 */
public class BubbleSort<T extends Comparable<T>> extends GenericSort<T> {

    /**
     * Sortiert die interne Liste nach dem Bubblesort-Algorithmus
     *
     * @return Die sortierte Liste der Objekte
     */
    public List<T> sort() {

        int i, j;
        int n = this.elements.size();

        for (i = n - 1; i > 0; i--) {
            for (j = 0; j < i; j++) {
                if (this.elements.get(j).compareTo(this.elements.get(j + 1)) > 0) {
                    this.swap(j, j + 1);
                }
            }
        }
        return this.elements;
    }
}